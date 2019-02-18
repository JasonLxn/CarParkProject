package com.neu.carpark.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.neu.carpark.entity.Parking;
import com.baomidou.mybatisplus.service.IService;
import com.neu.carpark.entity.bean.ParkTimeNum;

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
public interface ParkingService extends IService<Parking> {

    /**
     * 车位信息分页
     * @param page 自动导入关于分页page的相关信息
     * @return
     */
    Page<Parking> parklistPage(Page<Parking> page);

    /**
     * 查询7天内、15天内车位信息统计
     * @param parkingList 车位信息列表
     * @param day 天数
     * @return
     */
    List<Map<String,String>> selectParkinfo(List<Parking> parkingList, int day);

    /**
     * 查询当前月份、上个月的车位信息统计
     * @param parkingList 车位信息列表
     * @param month 0表示当月 1表示上个月
     * @return
     */
    List<Map<String,String>> selectMonthParkinfo(List<Parking> parkingList,int month);


    /**
     * 查询特定年份月份的车位信息统计
     * @param parkingList 车位信息列表
     * @param date 日期
     * @return
     */
    List<Map<String,String>> selectDateParkinfo(List<Parking> parkingList,String date);


}
