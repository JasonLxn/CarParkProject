package com.neu.carpark.controller.login;

import com.neu.carpark.service.AlluserService;
import com.neu.carpark.service.OperatService;
import com.neu.carpark.statictool.ResponseBo;
import com.neu.carpark.statictool.UtilsTools;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class LoginController {
    @Autowired
    AlluserService alluserService;
    @Autowired
    OperatService operatService;

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
    @GetMapping ("/login")
    public String loginPage(){
        return "login";
    }

    @ResponseBody
    @PostMapping ("/login")
    public ResponseBo login(String account, String password) {
        //shiro身份验证
        UsernamePasswordToken token = new UsernamePasswordToken(account, password);
        Subject subject = SecurityUtils.getSubject();
        //定义跳转页面路径
        String nextpage="";
        try {
            //shiro登录
            subject.login(token);
            //获取用户类型
            String rolename=alluserService.getUserRolename(UtilsTools.getuser());
            if(rolename.equals("运营员")){
                operatService.updateLogintime(UtilsTools.getuser().getAllId(),new Date());
                nextpage="/loginstaff";
                return ResponseBo.ok().put("nextpage",nextpage);
            }else if(rolename.equals("维修员")){
                operatService.updateLogintime(UtilsTools.getuser().getAllId(),new Date());
                nextpage="/loginservice";
                return ResponseBo.ok().put("nextpage",nextpage);
            }else if(rolename.equals("管理员")){
                return ResponseBo.ok().put("nextpage",nextpage);
            }
            return ResponseBo.ok().put("nextpage",nextpage);
        } catch (UnknownAccountException e) {
            return ResponseBo.error("用户名或密码错误");
        } catch (IncorrectCredentialsException e) {
            return ResponseBo.error("用户名或密码错误");
        } catch (LockedAccountException e) {
            return ResponseBo.error("账号状态异常,请联系管理员");
        } catch (AuthenticationException e) {
            return ResponseBo.error("认证失败,请重新登录");
        }
    }

    /**
     * 跳转运营员角色界面
     * @return
     */
    @RequestMapping("/loginstaff")
    public String loginstaff(){
        return "/OperatorsStaff/opst_home.html";
    }

    /**
     * 跳转维修员角色界面
     * @return
     */
    @RequestMapping("/loginservice")
    public String loginservice(){
        return "/OperatorsStaff/opst_parkstate.html";
    }
}
