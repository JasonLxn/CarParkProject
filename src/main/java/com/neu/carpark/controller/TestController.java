package com.neu.carpark.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.neu.carpark.entity.Users;
import com.neu.carpark.service.UsersService;
import com.neu.carpark.statictool.ResponseBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    UsersService usersService;

    @RequestMapping("/test1")
    @ResponseBody
    public ResponseBo test01(){
        List<Users> usersList=usersService.selectList(new EntityWrapper<Users>());
        return ResponseBo.ok().put("users",usersList);
    }

    @RequestMapping("login")
    public String login(){
        return "login";
    }
}