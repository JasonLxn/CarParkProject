package com.neu.carpark.controller.staff;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.neu.carpark.entity.Feedback;
import com.neu.carpark.service.FeedbackService;
import com.neu.carpark.statictool.ResponseBo;
import com.neu.carpark.statictool.UtilsTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/staffFed")
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;

    int size=3;//定义每页数据条数
    /**
     * 反馈信息列表数据渲染
     * @return
     */
    @RequestMapping("/fed")
    @ResponseBody
    public ResponseBo fed(){
        Page page=new Page(1,size);
        page=feedbackService.getDayFeedback(page,"未处理",7);
        List<Feedback> feedbackList=page.getRecords();

        int monthcount=feedbackService.selectCount(new EntityWrapper<Feedback>().eq("feba_operid",UtilsTools.getuser().getAllId())
                        .addFilter("DATE_FORMAT(CURDATE(),'%Y%m')=DATE_FORMAT(feba_opertime,'%Y%m')",""));
        int daycount=feedbackService.selectCount(new EntityWrapper<Feedback>().eq("feba_operid",UtilsTools.getuser().getAllId())
                .addFilter("DATE_FORMAT(CURDATE(),'%Y%m%d')=DATE_FORMAT(feba_opertime,'%Y%m%d')",""));

        return ResponseBo.ok().put("fed",feedbackList).put("page",page).put("monthcount",monthcount).put("daycount",daycount);
    }

    /**
     * 按天数分页获取反馈信息
     * @param num 页码
     * @param state 反馈信息状态
     * @param day 天数
     * @return
     */
    @RequestMapping("/dayFed/{num}")
    @ResponseBody
    public ResponseBo dayFed(@PathVariable int num,String state, int day){
        Page page=new Page(num,size);
        page=feedbackService.getDayFeedback(page,state,day);
        List<Feedback> feedbackList=page.getRecords();
        return ResponseBo.ok().put("fed",feedbackList).put("page",page);
    }

    /**
     * 按天数分页获取反馈信息
     * @param num 页码
     * @param state 反馈信息状态
     * @param date 天数
     * @return
     */
    @RequestMapping("/dateFed/{num}")
    @ResponseBody
    public ResponseBo dateFed(@PathVariable int num,String state, String date){
        Page page=new Page(num,size);
        page=feedbackService.getDateFeedback(page,state,date);
        List<Feedback> feedbackList=page.getRecords();
        return ResponseBo.ok().put("fed",feedbackList).put("page",page);
    }

    /**
     * 获取单一反馈信息的详细信息
     * @param id 主键id
     * @return
     */
    @RequestMapping("/infoFed/{id}")
    @ResponseBody
    public ResponseBo infoFed(@PathVariable String id){
        Feedback feedback=feedbackService.selectById(id);
        return ResponseBo.ok().put("fedinfo",feedback);
    }

    /**
     * 更新反馈信息的状态
     * @param id 主键id
     * @param state 修改的状态
     * @return
     */
    @RequestMapping("/updateFed/{id}/{state}")
    @ResponseBody
    public ResponseBo updateFed(@PathVariable String id,@PathVariable String state){
        Feedback feedback=feedbackService.selectById(id);
        if(feedback.getFebaState().equals("未处理")){
            feedback.setFebaState(state);
            feedback.setFebaOperid(UtilsTools.getuser().getAllId());
            feedback.setFebaOpertime(new Date());
            feedbackService.updateById(feedback);
            return ResponseBo.ok().put("fedinfo",feedback);
        }else{
            return ResponseBo.error();
        }
    }
}
