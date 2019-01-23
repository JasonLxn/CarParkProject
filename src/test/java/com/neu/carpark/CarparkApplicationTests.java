package com.neu.carpark;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.neu.carpark.entity.Users;
import com.neu.carpark.service.UsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarparkApplicationTests {
    @Autowired
    UsersService usersService;

    @Test
    public void contextLoads() {
        List<Users> usersList=usersService.selectList(new EntityWrapper<Users>());
        for (Users users:usersList) {
            System.out.println(users);
        }
//        Users users=new Users();
////        users.setUserId("1234");
//        users.setUserName("654321");
//        users.setUserPhone("17812345678");
//        users.setUserSex("男");
//        usersService.insert(users);
//
//        usersService.deleteById("123");
    }

}

