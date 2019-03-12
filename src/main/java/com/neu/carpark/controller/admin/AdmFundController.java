package com.neu.carpark.controller.admin;

import com.baomidou.mybatisplus.plugins.Page;
import com.neu.carpark.entity.Funds;
import com.neu.carpark.service.FundsService;
import com.neu.carpark.statictool.DateUtils;
import com.neu.carpark.statictool.ResponseBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/admfund")
public class AdmFundController {
    @Autowired
    FundsService fundsService;

    /**
     * 分页获取订单列表
     * @param num 当前页码
     * @param date 日期
     * @param state 订单状态
     * @param formatnum 日期格式
     * @return
     */
    @RequestMapping("/fundlist/{num}/{formatnum}")
    public ResponseBo fundlist(@PathVariable int num,String date,String state,@PathVariable String formatnum){
        String format;
        int size=10;
        if(formatnum.equals("1")){
            format="%Y-%m-%d";
        }else{
            format="%Y-%m";
        }
        Page page=new Page(num,size);
        page=fundsService.getDateFundPage(page,format,state,date);
        List<Funds> fundsList=page.getRecords();
        return ResponseBo.ok().put("fund",fundsList).put("page",page);
    }

    /**
     * 获取订单的echarts图
     * @param value
     * @return
     */
    @RequestMapping("/fundecharts/{value}")
    public ResponseBo fundecharts(@PathVariable String value){
        List<String> monthlist=new ArrayList<>();
        String format;
        String date;
        Calendar cal = Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH)+1;
        if(value.equals("1")){  //今天数据
            monthlist= DateUtils.getDayList(new Date(),1);
            date= new SimpleDateFormat("YYYYMMdd").format(new Date());
            format="%Y%m%d";
        }else if(value.equals("0")){ //本月数据
            monthlist= DateUtils.getMonthList(year,month);
            date= new SimpleDateFormat("YYYYMM").format(new Date());
            format="%Y%m";
        }else{  //指定月份数据
            date=value;
            int yearval=Integer.valueOf(value.substring(0,4));
            int monthval=Integer.valueOf(value.substring(5,7));
            monthlist= DateUtils.getMonthList(yearval,monthval);
            format="%Y-%m";
        }

        List<Map<String, String>> list=fundsService.getFundMoneysum(format,date);
        List<String> moneylist=new ArrayList<>();
        Map<String, String> map=new HashMap<>();
        int count=0;
        int listlenght=list.size();
        for (String s:monthlist) {
            for (int i=0;i<listlenght;i++) {
                if(list.get(i).get("time").equals(s)){
                    moneylist.add(list.get(i).get("money"));
                    list.remove(i);
                    listlenght=list.size();
                    count++;
                    continue;
                }
            }
            if(count==0) moneylist.add("0");
            else count=0;
        }
        return ResponseBo.ok().put("time",monthlist).put("money",moneylist);
    }
}
