package com.neu.carpark.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.neu.carpark.entity.Feedback;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lxn123
 * @since 2019-01-29
 */
public interface FeedbackMapper extends BaseMapper<Feedback> {

    List<Feedback> getDayFeedback(Pagination page, @Param("state") String state, @Param("day") int day);

    List<Feedback> getDateFeedback(Pagination page, @Param("state") String state, @Param("date") String date);

    List<Feedback> getMyDayFed(Pagination page, @Param("opstid") String opstid, @Param("day") int day);

    List<Feedback> getMyDateFed(Pagination page, @Param("opstid") String opstid, @Param("date") String date);

}
