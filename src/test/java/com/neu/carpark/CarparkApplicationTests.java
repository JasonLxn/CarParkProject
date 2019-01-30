package com.neu.carpark;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.neu.carpark.entity.*;
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
import java.util.Date;
import java.util.List;
import java.util.UUID;

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

    @Test
    public void insertop() {
        String uuid= UtilsTools.uuid();
        Operat operat=new Operat();
        operat.setOperId(uuid);
        operat.setOperWorknum("B000001");
        operat.setOperName("李四");
        operat.setOperSex("男");
        operat.setOperPhone("17812345678");
        operat.setOperPosition("维修员");
        operat.setOperRegisttime(new Date());
        operat.setOperLogintime(new Date());
        Alluser alluser=new Alluser();
        alluser.setAllId(uuid);
        alluser.setAllPwd("123456");
        alluser.setAllAccount("B000001");
        alluser.setAllState("1");
        alluserService.encryptionPwd(alluser);
        alluserService.insert(alluser);
        operatService.insert(operat);
        Userrole userrole=new Userrole();
        userrole.setUrAllid(uuid);
        userrole.setUrRoid(roleService.selectOne(new EntityWrapper<Role>().eq("ro_name", operatService.selectById(uuid).getOperPosition())).getRoId());
        userroleService.insert(userrole);

    }

    @Test
    public void test(){
        for (int i=2;i<=30;i++){
            DecimalFormat mFormat = new DecimalFormat("000");//确定格式，把1转换为001
            String s = mFormat.format(i);
            Parking parking=new Parking();
            parking.setParkId(UtilsTools.uuid());
            parking.setParkNum(s);
            parking.setParkState("正常");
            parking.setParkTime(new Date());
            parkingService.insert(parking);
        }
    }

    @Test
    public void test01(){
        Parking parking=parkingService.selectOne(new EntityWrapper<Parking>().eq("park_num","001"));
        String time= DateUtils.getDatePoor(new Date(),parking.getParkTime());
        String[] result=time.split(":");
        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
    }
}

