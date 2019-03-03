package com.neu.carpark.controller.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.neu.carpark.entity.Detect;
import com.neu.carpark.entity.Parkchange;
import com.neu.carpark.entity.Parking;
import com.neu.carpark.service.DetectService;
import com.neu.carpark.service.ParkchangeService;
import com.neu.carpark.service.ParkingService;
import com.neu.carpark.statictool.DateUtils;
import com.neu.carpark.statictool.ResponseBo;
import com.neu.carpark.statictool.UtilsTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/Serservice")
public class SerServiceController {
    @Autowired
    ParkingService parkingService;
    @Autowired
    DetectService detectService;
    @Autowired
    ParkchangeService parkchangeService;

    /**
     * 判断输入的车位编号是否存在
     * @param num 车位编号
     * @return
     */
    @RequestMapping("/parknum/{num}")
    @ResponseBody
    public ResponseBo parknum(@PathVariable String num){
        Parking parking=parkingService.selectOne(new EntityWrapper<Parking>().eq("park_num",num));
        if(parking!=null){
            return ResponseBo.ok().put("park",parking);
        }else{
            return ResponseBo.error();
        }
    }

    /**
     * 插入维修报告
     * @param detect 实体
     * @return
     */
    @RequestMapping("/insertDetect")
    @ResponseBody
    public ResponseBo insertDetect(Detect detect){
        Date nowdate=new Date();
        detect.setDeteId(UtilsTools.uuid());
        detect.setDeteTime(nowdate);
        detect.setDeteOperid(UtilsTools.getuser().getAllId());
        Parking parking=parkingService.selectOne(new EntityWrapper<Parking>().eq("park_num",detect.getDeteParkid()));
        detect.setDeteParkid(parking.getParkId());
        switch (detect.getDeteAtate()){
            case "1":detect.setDeteAtate("未使用");break;
            case "2":detect.setDeteAtate("使用中");break;
            case "3":detect.setDeteAtate("维修中");break;
            case "4":detect.setDeteAtate("故障中");break;
        }
        if(detectService.insert(detect)){
            parking.setParkState(detect.getDeteAtate());
            parking.setParkTime(nowdate);
            parkingService.updateById(parking);
            Parkchange parkchange=new Parkchange();
            parkchange.setParcId(UtilsTools.uuid());
            parkchange.setParcAstate(detect.getDeteAtate());
            parkchange.setParcBstate(detect.getDeteBstate());
            parkchange.setParcReason(detect.getDeteMeg());
            parkchange.setParcTime(nowdate);
            parkchange.setParcOperid(detect.getDeteOperid());
            parkchange.setParcParkid(detect.getDeteParkid());
            parkchangeService.insert(parkchange);
            return ResponseBo.ok();
        }else
            return ResponseBo.error();
    }


    /**
     * 渲染维修员--我的提交的界面
     */
    @RequestMapping("/myservice")
    @ResponseBody
    public ResponseBo myservice(){
        int size=2;
        Page page=new Page(1,size);
        page=detectService.getOperDetePage(page,UtilsTools.getuser().getAllId(),DateUtils.getNowYearmonths());
        List<Detect> detectList=page.getRecords();
        int monthcount=detectService.selectCount(new EntityWrapper<Detect>().eq("dete_operid",UtilsTools.getuser().getAllId())
                .addFilter("DATE_FORMAT(CURDATE(),'%Y%m')=DATE_FORMAT(dete_time,'%Y%m')",""));
        int daycount=detectService.selectCount(new EntityWrapper<Detect>().eq("dete_operid",UtilsTools.getuser().getAllId())
                .addFilter("DATE_FORMAT(CURDATE(),'%Y%m%d')=DATE_FORMAT(dete_time,'%Y%m%d')",""));
        return ResponseBo.ok().put("list",detectList).put("monthcount",monthcount).put("daycount",daycount).put("page",page);
    }


    @RequestMapping("/pageservice/{currentpage}/{date}")
    @ResponseBody
    public ResponseBo pageservice(@PathVariable int currentpage,@PathVariable String date){
        int size=2;
        Page page=new Page(currentpage,size);
        page=detectService.getOperDetePage(page,UtilsTools.getuser().getAllId(),date);
        List<Detect> detectList=page.getRecords();
        int monthcount=detectService.selectCount(new EntityWrapper<Detect>().eq("dete_operid",UtilsTools.getuser().getAllId())
                .addFilter("DATE_FORMAT(CURDATE(),'%Y%m')=DATE_FORMAT(dete_time,'%Y%m')",""));
        int daycount=detectService.selectCount(new EntityWrapper<Detect>().eq("dete_operid",UtilsTools.getuser().getAllId())
                .addFilter("DATE_FORMAT(CURDATE(),'%Y%m%d')=DATE_FORMAT(dete_time,'%Y%m%d')",""));
        return ResponseBo.ok().put("list",detectList).put("monthcount",monthcount).put("daycount",daycount).put("page",page);

    }

    @RequestMapping("/onedetect/{id}")
    @ResponseBody
    public ResponseBo onedetect(@PathVariable String id){
        Detect detect=detectService.selectById(id);
        return ResponseBo.ok().put("detect",detect);
    }
}
