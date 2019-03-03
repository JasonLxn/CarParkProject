package com.neu.carpark.controller.service;

import com.neu.carpark.service.AlluserService;
import com.neu.carpark.service.OperatService;
import com.neu.carpark.statictool.ResponseBo;
import com.neu.carpark.statictool.UtilsTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/service")
public class SerJumpController {
    @Autowired
    OperatService operatService;
    @Autowired
    AlluserService alluserService;

    /**
     * 跳转运营员首页信息界面
     * @return
     */
    @RequestMapping("/home")
    public String operHome(){
        return "/OperatorsService/opse_home";
    }


    /**
     * 跳转车位信息--车位详情界面
     * @return
     */
    @RequestMapping("/parkitem")
    public String operParkitem(){
        return "/OperatorsService/opse_parkitem";
    }

    /**
     * 跳转车位信息--车位状态界面
     * @return
     */
    @RequestMapping("/parkstate")
    public String operParkstate(){
        return "/OperatorsService/opse_parkstate";
    }

    /**
     * 跳转检测维修--提交报告界面
     * @return
     */
    @RequestMapping("/serform")
    public String operReport(){
        return "/OperatorsService/opse_serform";
    }

    /**
     * 跳转检测维修--我的提交界面
     * @return
     */
    @RequestMapping("/mysubmit")
    public String operService(){
        return "/OperatorsService/opse_mysubmit";
    }

}
