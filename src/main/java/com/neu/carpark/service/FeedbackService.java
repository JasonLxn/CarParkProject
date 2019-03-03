package com.neu.carpark.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.neu.carpark.entity.Feedback;
import com.baomidou.mybatisplus.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lxn123
 * @since 2019-01-29
 */
public interface FeedbackService extends IService<Feedback> {

    /**
     * 分页获取按天数反馈列表信息
     * @param state 反馈信息状态
     * @param day 天数
     * @return
     */
    Page<Feedback> getDayFeedback(Page<Feedback> page,@Param("state") String state, @Param("day") int day);

    /**
     * 分页获取按日期反馈列表信息
     * @param page 分页
     * @param state 状态
     * @param date 0:当月 1：上个月 -1：按年月格式如201902
     * @return
     */
    Page<Feedback> getDateFeedback(Page<Feedback> page,@Param("state") String state, @Param("date") String date);

    /**
     * 分页获取按天数运营员提交反馈信息的列表
     * @param page 分页
     * @param opstid 运营员id
     * @param day 天数
     * @return
     */
    Page<Feedback> getMyDayFed(Page<Feedback> page, @Param("opstid") String opstid, @Param("day") int day);

    /**
     * 分页获取按日期运营员提交反馈信息的列表
     * @param page 分页
     * @param opstid 运营员id
     * @param date 0:当月 1：上个月 -1：按年月格式如201902
     * @return
     */
    Page<Feedback> getMyDateFed(Page<Feedback> page, @Param("opstid") String opstid, @Param("date") String date);
}
