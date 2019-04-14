package com.neu.carpark.controller.admin;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.neu.carpark.entity.Parkchange;
import com.neu.carpark.entity.Parking;
import com.neu.carpark.entity.Users;
import com.neu.carpark.service.FundsService;
import com.neu.carpark.service.ParkchangeService;
import com.neu.carpark.service.ParkingService;
import com.neu.carpark.service.UsersService;
import com.neu.carpark.statictool.DateUtils;
import com.neu.carpark.statictool.ResponseBo;
import com.neu.carpark.statictool.UtilsTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("/common")
public class CommonController {
    @Autowired
    ParkingService parkingService;
    @Autowired
    ParkchangeService parkchangeService;
    @Autowired
    FundsService fundsService;
    @Autowired
    UsersService usersService;

    @RequestMapping("/home")
    public ResponseBo home(){
        //查询当前车位的情况
        int usernum=parkingService.selectCount(new EntityWrapper<Parking>().eq("park_state","使用中"));
        int unusernum=parkingService.selectCount(new EntityWrapper<Parking>().eq("park_state","未使用"));
        int errornum=parkingService.selectCount(new EntityWrapper<Parking>().eq("park_state","故障中"));
        int servicenum=parkingService.selectCount(new EntityWrapper<Parking>().eq("park_state","维修中"));

        //查询当月车位修改情况
        Calendar cal=Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH)+1;
        List<String> timelist= DateUtils.getMonthList(year,month);
        List<Integer> uselist=parkchangeService.getuseNum(timelist);
        List<Integer> errorlist=parkchangeService.geterrorNum(timelist);
        List<Integer> servicelist=parkchangeService.getserviceNum(timelist);

        //查询当前月收益趋向图
        String date=DateUtils.getNowYearmonths();
        List<Map<String, String>> fundslist=fundsService.getFundMoneysum("%Y%m",date);
        List<String> moneylist=new ArrayList<>();
        int count=0;
        int listlenght=fundslist.size();
        for (String s:timelist) {
            for (int i=0;i<listlenght;i++) {
                if(fundslist.get(i).get("time").equals(s)){
                    moneylist.add(fundslist.get(i).get("money"));
                    fundslist.remove(i);
                    listlenght=fundslist.size();
                    count++;
                    continue;
                }
            }
            if(count==0) moneylist.add("0");
            else count=0;
        }

        //查询用户流量
        double userCountnow=usersService.selectCount(new EntityWrapper<Users>().addFilter("DATE_FORMAT(CURDATE(),'%Y%m')-DATE_FORMAT(user_registtime,'%Y%m')=0",""));
        double userCountbefore=usersService.selectCount(new EntityWrapper<Users>().addFilter("DATE_FORMAT(CURDATE(),'%Y%m')-DATE_FORMAT(user_registtime,'%Y%m')=1",""));
        BigDecimal userSpeed=UtilsTools.sumIncease(userCountnow,userCountbefore);

        //查询故障次数
        double errorCountnow=parkchangeService.selectCount(new EntityWrapper<Parkchange>().eq("parc_astate","故障中").addFilter("DATE_FORMAT(CURDATE(),'%Y%m')-DATE_FORMAT(parc_time,'%Y%m')=0",""));
        double errorCountbefore=parkchangeService.selectCount(new EntityWrapper<Parkchange>().eq("parc_astate","故障中").addFilter("DATE_FORMAT(CURDATE(),'%Y%m')-DATE_FORMAT(parc_time,'%Y%m')=1",""));
        BigDecimal errorSpeed=UtilsTools.sumIncease(errorCountnow,errorCountbefore);

        //查询维修次数
        double serviceCountnow=parkchangeService.selectCount(new EntityWrapper<Parkchange>().eq("parc_astate","维修中").addFilter("DATE_FORMAT(CURDATE(),'%Y%m')-DATE_FORMAT(parc_time,'%Y%m')=0",""));
        double serviceCountbefore=parkchangeService.selectCount(new EntityWrapper<Parkchange>().eq("parc_astate","维修中").addFilter("DATE_FORMAT(CURDATE(),'%Y%m')-DATE_FORMAT(parc_time,'%Y%m')=1",""));
        BigDecimal serviceSpeed=UtilsTools.sumIncease(serviceCountnow,serviceCountbefore);

        //查询月收益
        double fundCountnow=fundsService.getMonthFund(0);
        double fundCountbefore=fundsService.getMonthFund(1);
        BigDecimal fundSpeed=UtilsTools.sumIncease(fundCountnow,fundCountbefore);

        return ResponseBo.ok().put("usernum",usernum).put("unusernum",unusernum).put("errornum",errornum).put("servicenum",servicenum)
                .put("timelist",timelist).put("uselist",uselist).put("errorlist",errorlist).put("servicelist",servicelist)
                .put("moneylist",moneylist).put("userCountnow",userCountnow).put("userSpeed",userSpeed)
                .put("errorCountnow",errorCountnow).put("errorSpeed",errorSpeed).put("serviceCountnow",serviceCountnow)
                .put("serviceSpeed",serviceSpeed).put("fundCountnow",fundCountnow).put("fundSpeed",fundSpeed);
    }
}
