package com.neu.carpark.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.neu.carpark.entity.Parkchange;
import com.baomidou.mybatisplus.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lxn123
 * @since 2019-01-29
 */
public interface ParkchangeService extends IService<Parkchange> {
    /**
     * 查询7天内、15天内车位信息统计
     * @param id 车位id
     * @param day 天数
     * @return
     */
    Map<String,String> getDayPark(@Param("id") String id,@Param("day") int day);

    /**
     * 查询当前月份、上个月的车位信息统计
     * @param id 车位id
     * @param month 0表示当月 1表示上个月
     * @return
     */
    Map<String,String> getMonthPark(@Param("id") String id,@Param("month") int month);

    /**
     * 查询特定年份月份的车位信息统计
     * @param id 车位id
     * @param date 日期
     * @return
     */
    Map<String,String> getDatePark(@Param("id") String id,@Param("date") String date);

    /**
     * 获取规定日期列表内车位每天的数据变动，用来渲染echart图
     * useNum:使用中
     * @param datelist 日期列表
     * @return
     */
    List<Integer> getuseNum(List<String> datelist);

    /**
     * 获取规定日期列表内车位每天的数据变动，用来渲染echart图
     * errorNum:故障中
     * @param datelist 日期列表
     * @return
     */
    List<Integer> geterrorNum(List<String> datelist);

    /**
     * 获取规定日期列表内车位每天的数据变动，用来渲染echart图
     * serviceNum:维修中
     * @param datelist 日期列表
     * @return
     */
    List<Integer> getserviceNum(List<String> datelist);

}
