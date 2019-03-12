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
import org.springframework.web.bind.annotation.PathVariable;
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
     * 跳转车位信息--车位详情界面
     * @return
     */
    @RequestMapping("/parkitem")
    public String operParkitem(){
        return "/OperatorsStaff/opst_parkitem";
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
     * 编辑车位状态界面
     * @Parm id 车位ID
     * @return
     */
    @RequestMapping("/updateParkInfo/{id}")
    public String parkidInfo(@PathVariable String id){
        return "/OperatorsStaff/opst_parkform";
    }

    /**
     * 跳转车场管理--订单管理界面
     * @return
     */
    @RequestMapping("/fundlist")
    public String operReport(){
        return "/OperatorsStaff/opst_fundlist";
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
