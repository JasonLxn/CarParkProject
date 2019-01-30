package com.neu.carpark.controller.staff;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.neu.carpark.entity.Alluser;
import com.neu.carpark.entity.Parking;
import com.neu.carpark.service.AlluserService;
import com.neu.carpark.service.OperatService;
import com.neu.carpark.service.ParkingService;
import com.neu.carpark.statictool.DateUtils;
import com.neu.carpark.statictool.ResponseBo;
import com.neu.carpark.statictool.UtilsTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/staffpark")
public class ParkcarController {
    @Autowired
    OperatService operatService;
    @Autowired
    ParkingService parkingService;
    @Autowired
    AlluserService alluserService;

    /**
     * 渲染车位状态首页信息
     * @return
     */
    @RequestMapping("/carmsg")
    @ResponseBody
    public ResponseBo carmsg(){
        List<Parking> parkingList=parkingService.selectList(new EntityWrapper<Parking>().orderBy("park_num"));
        return ResponseBo.ok().put("park",parkingList);
    }

    /**
     * 获取指定车位的详细信息
     * @param parkid 车位id
     * @return
     */
    @RequestMapping("/parkinfo/{parkid}")
    @ResponseBody
    public ResponseBo parkinfo(@PathVariable String parkid){
        Parking parking=parkingService.selectById(parkid);
        String[] parktime= DateUtils.getDatePoor(new Date(),parking.getParkTime()).split(":");
        return ResponseBo.ok().put("parkinfomeg",parking).put("parkhour",parktime[0]).put("parkmin",parktime[1])
                .put("parksec",parktime[2]);
    }

}
