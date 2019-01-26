package com.neu.carpark.controller.login;

import com.neu.carpark.statictool.ResponseBo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    /**
     * 配置默认首页界面
     * @return 默认登录界面
     */
    @RequestMapping("/")
    public String homePage(){
        return "login";
    }

    /**
     * 配置登录首页
     * @return
     */
    @RequestMapping("/loginpage")
    public String loginPage(){
        return "login";
    }

    @ResponseBody
    @PostMapping("/login")
    public ResponseBo login(String account, String password){
        System.out.println(account+"///"+password);
        return ResponseBo.ok();
    }


}
