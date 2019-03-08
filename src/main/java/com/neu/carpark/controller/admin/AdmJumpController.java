package com.neu.carpark.controller.admin;

import com.neu.carpark.service.AlluserService;
import com.neu.carpark.service.OperatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdmJumpController {
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
        return "/OperatorsAdmin/admin_home";
    }


    /**
     * 跳转车位信息--车位详情界面
     * @return
     */
    @RequestMapping("/parkitem")
    public String operParkitem(){
        return "/OperatorsAdmin/admin_parkitem";
    }

    /**
     * 跳转车位信息--车位状态界面
     * @return
     */
    @RequestMapping("/parkstate")
    public String operParkstate(){
        return "/OperatorsAdmin/admin_parkstate";
    }

    /**
     * 跳转订单管理--订单列表界面
     * @return
     */
    @RequestMapping("/fundlist")
    public String operReport(){
        return "/OperatorsAdmin/admin_fundlist";
    }

    /**
     * 跳转检测维修--我的提交界面
     * @return
     */
//    @RequestMapping("/mysubmit")
//    public String operService(){
//        return "/OperatorsService/opse_mysubmit";
//    }

}
