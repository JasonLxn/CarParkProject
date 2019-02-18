package com.neu.carpark.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.neu.carpark.entity.Parkchange;
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
public interface ParkchangeMapper extends BaseMapper<Parkchange> {

    Map<String,String> getDayPark(@Param("id") String id, @Param("day") int day);

    Map<String,String> getMonthPark(@Param("id") String id, @Param("month") int month);

    Map<String,String> getYearMonthPark(@Param("id") String id, @Param("date") String date);

}
