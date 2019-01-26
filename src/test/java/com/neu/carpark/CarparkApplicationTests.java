package com.neu.carpark;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.neu.carpark.entity.*;
import com.neu.carpark.service.*;
import com.neu.carpark.statictool.UtilsTools;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
    OperatadminService operatadminService;
    @Autowired
    RoleService roleService;
    @Autowired
    UserroleService userroleService;

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
        List<Alluser> allusers=alluserService.selectList(new EntityWrapper<Alluser>());
        for (Alluser alluser:allusers) {
            System.out.println(alluser);
        }
    }
}

