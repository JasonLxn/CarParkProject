package com.neu.carpark;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.neu.carpark.entity.*;
import com.neu.carpark.service.*;
import com.neu.carpark.statictool.UtilsTools;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
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
        String account="A000001";
        String password="123456";
        UsernamePasswordToken token=new UsernamePasswordToken(account,password);
        Subject subject=SecurityUtils.getSubject();
        subject.login(token);

        try {
            //shiro的登录方法
            System.out.println(UtilsTools.getuser().getAllId());
        } catch (UnknownAccountException e) {
            System.out.println("error1");
        } catch (IncorrectCredentialsException e) {
            System.out.println("账号或密码错误");
        } catch (LockedAccountException e) {
            System.out.println("error2");
        } catch (AuthenticationException e) {
            System.out.println("认证失败！");
        }
    }
}

