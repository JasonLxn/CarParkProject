package com.neu.carpark.controller.staff;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.neu.carpark.entity.Parking;
import com.neu.carpark.service.AlluserService;
import com.neu.carpark.service.OperatService;
import com.neu.carpark.service.ParkingService;
import com.neu.carpark.statictool.ResponseBo;
import com.neu.carpark.statictool.UtilsTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/staff")
public class JumpController {
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
        return "/OperatorsStaff/opst_home";
    }

    /**
     * 跳转用户反馈--反馈列表界面
     * @return
     */
    @RequestMapping("/feedback")
    public String operFeedback(){
        return "/OperatorsStaff/opst_feedback";
    }

    /**
     * 跳转车位信息--车位详情界面
     * @return
     */
    @RequestMapping("/parkitem")
    public String operParkitem(){
        return "/OperatorsStaff/opst_parkitem";
    }

    /**
     * 跳转用户反馈--我的提交界面
     * @return
     */
    @RequestMapping("/myfeedback")
    public String operMyFeedback(){
        return "/OperatorsStaff/opst_myfeedback";
    }

    /**
     * 跳转车位信息--车位状态界面
     * @return
     */
    @RequestMapping("/parkstate")
    public String operParkstate(){
        return "/OperatorsStaff/opst_parkstate";
    }

    /**
     * 跳转检测维修--检测报告界面
     * @return
     */
    @RequestMapping("/report")
    public String operReport(){
        return "/OperatorsStaff/opst_report";
    }

    /**
     * 跳转检测维修--维修列表界面
     * @return
     */
    @RequestMapping("/service")
    public String operService(){
        return "/OperatorsStaff/opst_service";
    }

    /**
     * 渲染头部用户信息
     * @return
     */
    @RequestMapping("/info")
    @ResponseBody
    public ResponseBo carmsg(){
        String username=operatService.getOpername(UtilsTools.getuser());
        String userrole=alluserService.getUserRolename(UtilsTools.getuser());

        return ResponseBo.ok().put("username",username).put("userrole",userrole);
    }
}
