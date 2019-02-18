package com.neu.carpark.controller.staff;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.neu.carpark.entity.Alluser;
import com.neu.carpark.entity.Parking;
import com.neu.carpark.entity.bean.ParkTimeNum;
import com.neu.carpark.service.AlluserService;
import com.neu.carpark.service.OperatService;
import com.neu.carpark.service.ParkchangeService;
import com.neu.carpark.service.ParkingService;
import com.neu.carpark.statictool.DateUtils;
import com.neu.carpark.statictool.ResponseBo;
import com.neu.carpark.statictool.UtilsTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/staffpark")
public class ParkcarController {
    @Autowired
    OperatService operatService;
    @Autowired
    ParkingService parkingService;
    @Autowired
    AlluserService alluserService;
    @Autowired
    ParkchangeService parkchangeService;

    /**
     * 渲染车位状态首页信息
     * @return
     */
    @RequestMapping("/carmsg")
    @ResponseBody
    public ResponseBo carmsg(){
        List<Parking> parkingList=parkingService.selectList(new EntityWrapper<Parking>().orderBy("park_num"));
        return ResponseBo.ok().put("park",parkingList);
    }

    /**
     * 获取指定车位的详细信息
     * @param parkid 车位id
     * @return
     */
    @RequestMapping("/parkinfo/{parkid}")
    @ResponseBody
    public ResponseBo parkinfo(@PathVariable String parkid){
        Parking parking=parkingService.selectById(parkid);
        String[] parktime= DateUtils.getDatePoor(new Date(),parking.getParkTime()).split(":");
        return ResponseBo.ok().put("parkinfomeg",parking).put("parkhour",parktime[0]).put("parkmin",parktime[1])
                .put("parksec",parktime[2]);
    }

    /**
     * 获取车位二维码
     * @param parkid 车位ID
     * @param resp
     * @throws IOException
     */
    @RequestMapping("/getZing/{parkid}")
    public void getqcode(@PathVariable String parkid, HttpServletResponse resp) throws IOException {
        String url =parkid;
        if (url != null && !"".equals(url)) {
            ServletOutputStream stream = null;
            try {
                // 设置编码字符集
                Map<EncodeHintType, Object> hints = new HashMap<>();
                //设置编码
                hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
                //设置容错率最高
                hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
                hints.put(EncodeHintType.MARGIN, 1);

                int width = 250;//图片的宽度
                int height = 250;//高度
                stream = resp.getOutputStream();
                QRCodeWriter writer = new QRCodeWriter();
                BitMatrix m = writer.encode(url, BarcodeFormat.QR_CODE, height, width,hints);
                MatrixToImageWriter.writeToStream(m, "png", stream);
            } catch (WriterException e) {
                e.printStackTrace();
            } finally {
                if (stream != null) {
                    stream.flush();
                    stream.close();
                }
            }
        }
    }

    /**
     * 车位详情页数据渲染
     * @return
     */
    @RequestMapping("/parkitem")
    @ResponseBody
    public ResponseBo parkitem(){
        Page page = new Page(1,10);
        page = parkingService.parklistPage(page);
        List<Parking> parkingList = page.getRecords();
        List<Map<String,String>> parkInfoList=parkingService.selectParkinfo(parkingList,7);
        return ResponseBo.ok().put("parkinfo",parkInfoList).put("page",page);
    }

    /**
     * 7天、15天车位信息分页跳转
     * @param num 页码
     * @param day 天数
     * @return
     */
    @RequestMapping("/turndaypark/{num}/{day}")
    @ResponseBody
    public ResponseBo turndaypark(@PathVariable int num,@PathVariable int day){
        Page page = new Page(num,10);
        page = parkingService.parklistPage(page);
        List<Parking> parkingList = page.getRecords();
        List<Map<String,String>> parkInfoList=parkingService.selectParkinfo(parkingList,day);
        return ResponseBo.ok().put("parkinfo",parkInfoList).put("page",page);
    }

    /**
     * 当月、上个月车位信息分页跳转
     * @param num 页码
     * @param month 0表示当月 1表示上个月
     * @return
     */
    @RequestMapping("/turnmonthpark/{num}/{month}")
    @ResponseBody
    public ResponseBo turnmonthpark(@PathVariable int num,@PathVariable int month){
        Page page = new Page(num,10);
        page = parkingService.parklistPage(page);
        List<Parking> parkingList = page.getRecords();
        List<Map<String,String>> parkInfoList=parkingService.selectMonthParkinfo(parkingList,month);
        return ResponseBo.ok().put("parkinfo",parkInfoList).put("page",page);
    }

    /**
     * 特定年份月份车位信息分页跳转
     * @param num 页码
     * @param date 日期
     * @return
     */
    @RequestMapping("/turndatepark/{num}/{date}")
    @ResponseBody
    public ResponseBo turnmonthpark(@PathVariable int num,@PathVariable String date){
        Page page = new Page(num,10);
        page = parkingService.parklistPage(page);
        List<Parking> parkingList = page.getRecords();

        List<Map<String,String>> parkInfoList=parkingService.selectDateParkinfo(parkingList,date);
        return ResponseBo.ok().put("parkinfo",parkInfoList).put("page",page);
    }

    /**
     * 获取echart图的数据
     * @param value
     * @return
     */
    @RequestMapping("/echartpark/{value}")
    @ResponseBody
    public ResponseBo echartpark(@PathVariable int value){
        List<String> timelist=new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH)+1;
        if(value==7||value==15){
            timelist=DateUtils.getDayList(new Date(),value);
        }else if(value==0){
            timelist=DateUtils.getMonthList(year,month);
        }else if(value==1){
            timelist=DateUtils.getMonthList(year,month-1);
        }else{
            int yearval=Integer.valueOf(String.valueOf(value).substring(0,4));
            int monthval=Integer.valueOf(String.valueOf(value).substring(5,6));
//            System.out.println(value+"---"+yearval+"---"+monthval);
            timelist=DateUtils.getMonthList(yearval,monthval);
        }

        List<Integer> useNum=parkchangeService.getuseNum(timelist);
        List<Integer> errorNum=parkchangeService.geterrorNum(timelist);
        List<Integer> serviceNum=parkchangeService.getserviceNum(timelist);
        return ResponseBo.ok().put("time",timelist).put("useNum",useNum).put("errorNum",errorNum).put("serviceNum",serviceNum);
    }
}
