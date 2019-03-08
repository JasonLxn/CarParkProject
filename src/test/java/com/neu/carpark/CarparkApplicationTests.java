package com.neu.carpark;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.neu.carpark.entity.*;
import com.neu.carpark.entity.bean.ParkTimeNum;
import com.neu.carpark.service.*;
import com.neu.carpark.statictool.DateUtils;
import com.neu.carpark.statictool.UtilsTools;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarparkApplicationTests {
    @Autowired
    OperatService operatService;
    @Autowired
    AlluserService alluserService;
    @Autowired
    RoleService roleService;
    @Autowired
    UserroleService userroleService;
    @Autowired
    ParkingService parkingService;
    @Autowired
    ParkchangeService parkchangeService;
    @Autowired
    FeedbackService feedbackService;
    @Autowired
    DetectService detectService;
    @Autowired
    FundsService fundsService;

    @Test
    public void insertop() {
//        String uuid= UtilsTools.uuid();
//        Operat operat=new Operat();
//        operat.setOperId(uuid);
//        operat.setOperWorknum("admin");
//        operat.setOperName("admin");
//        operat.setOperSex("男");
//        operat.setOperPhone("17812345678");
//        operat.setOperPosition("管理员");
//        operat.setOperRegisttime(new Date());
//        operat.setOperLogintime(new Date());
//        Alluser alluser=new Alluser();
//        alluser.setAllId(uuid);
//        alluser.setAllPwd("123456");
//        alluser.setAllAccount("admin");
//        alluser.setAllState("1");
//        alluserService.encryptionPwd(alluser);
//        alluserService.insert(alluser);
//        operatService.insert(operat);
//        Userrole userrole=new Userrole();
//        userrole.setUrAllid(uuid);
//        userrole.setUrRoid(roleService.selectOne(new EntityWrapper<Role>().eq("ro_name", operatService.selectById(uuid).getOperPosition())).getRoId());
//        userroleService.insert(userrole);

    }

//    @Test
//    public void test(){
//        for (int i=2;i<=30;i++){
//            DecimalFormat mFormat = new DecimalFormat("000");//确定格式，把1转换为001
//            String s = mFormat.format(i);
//            Parking parking=new Parking();
//            parking.setParkId(UtilsTools.uuid());
//            parking.setParkNum(s);
//            parking.setParkState("正常");
//            parking.setParkTime(new Date());
//            parkingService.insert(parking);
//        }
//    }

    @Test
    public void test01(){

//        Calendar cal=Calendar.getInstance();
//        int month=cal.get(Calendar.MONTH);
//        int day=cal.get(Calendar.DATE);
//        cal.set(Calendar.MONTH,month-1);
//        String date=DateUtils.format(cal.getTime(),"YYYYMM");
//        System.out.println(date);

//        SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMdd");
//        String format="%Y%m%d";
//        Page page=new Page(1,10);
//        page=fundsService.getDateFundPage(page,format,"已支付",sdf.format(new Date()));
//        List<Funds> list=page.getRecords();
//        System.out.println(list);
//        List<Map<String, String>> list=fundsService.getFundMoneysum("%Y%m","201902");
//        List<String> monthlist=DateUtils.getMonthList(2019,2);
//        List<String> moneylist=new ArrayList<>();
//        Map<String, String> map=new HashMap<>();
//        int count=0;
//        int listlenght=list.size();
//        for (String s:monthlist) {
//            for (int i=0;i<listlenght;i++) {
//                if(list.get(i).get("time").equals(s)){
//                    moneylist.add(list.get(i).get("money"));
//                    list.remove(i);
//                    listlenght=list.size();
//                    count++;
//                    continue;
//                }
//            }
//            if(count==0){
//                moneylist.add("0");
//            }
//            else
//                count=0;
//        }
        System.out.println(Integer.valueOf("01"));
    }
}

