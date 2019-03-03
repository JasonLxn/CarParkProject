package com.neu.carpark.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.neu.carpark.entity.Feedback;
import com.neu.carpark.mapper.FeedbackMapper;
import com.neu.carpark.service.FeedbackService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.neu.carpark.statictool.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lxn123
 * @since 2019-01-29
 */
@Service
public class FeedbackServiceImpl extends ServiceImpl<FeedbackMapper, Feedback> implements FeedbackService {

    @Override
    public Page<Feedback> getDayFeedback(Page<Feedback> page,String state, int day) {
        page.setRecords(baseMapper.getDayFeedback(page,state,day));
        return page;
    }

    @Override
    public Page<Feedback> getDateFeedback(Page<Feedback> page, String state, String date) {
        if(date.equals("0")){
            date=DateUtils.format(new Date(),"YYYYMM");
        }else if(date.equals("1")){
            Calendar cal=Calendar.getInstance();
            int month=cal.get(Calendar.MONTH);
            cal.set(Calendar.MONTH,month-1);
            date=DateUtils.format(cal.getTime(),"YYYYMM");
        }else{
            date=date;
        }
        page.setRecords(baseMapper.getDateFeedback(page,state,date));
        return page;
    }

    @Override
    public Page<Feedback> getMyDayFed(Page<Feedback> page, String opstid, int day) {
        page.setRecords(baseMapper.getMyDayFed(page,opstid,day));
        return page;
    }

    @Override
    public Page<Feedback> getMyDateFed(Page<Feedback> page, String opstid, String date) {
        if(date.equals("0")){
            date=DateUtils.format(new Date(),"YYYYMM");
        }else if(date.equals("1")){
            Calendar cal=Calendar.getInstance();
            int month=cal.get(Calendar.MONTH);
            cal.set(Calendar.MONTH,month-1);
            date=DateUtils.format(cal.getTime(),"YYYYMM");
        }else{
            date=date;
        }
        page.setRecords(baseMapper.getMyDateFed(page,opstid,date));
        return page;
    }
}
