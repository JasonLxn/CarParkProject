package com.neu.carpark.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.neu.carpark.entity.Parkchange;
import com.neu.carpark.entity.Parking;
import com.neu.carpark.entity.bean.ParkTimeNum;
import com.neu.carpark.mapper.ParkingMapper;
import com.neu.carpark.service.ParkchangeService;
import com.neu.carpark.service.ParkingService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lxn123
 * @since 2019-01-29
 */
@Service
public class ParkingServiceImpl extends ServiceImpl<ParkingMapper, Parking> implements ParkingService {

    @Autowired
    ParkchangeService parkchangeService;

    @Override
    public Page<Parking> parklistPage(Page<Parking> page) {
        page.setRecords(baseMapper.parklistPage(page));
        return page;
    }

    @Override
    public List<Map<String,String>> selectParkinfo(List<Parking> parkingList,int day) {
        List<Map<String,String>> parkInfoList=new ArrayList<>();
        for (Parking parking:parkingList) {
            Map<String,String> info=parkchangeService.getDayPark(parking.getParkId(),day);
            parkInfoList.add(info);
        }
        return parkInfoList;
    }

    @Override
    public List<Map<String,String>> selectMonthParkinfo(List<Parking> parkingList, int month) {
        List<Map<String,String>> parkInfoList=new ArrayList<>();
        for (Parking parking:parkingList) {
            Map<String,String> info=parkchangeService.getMonthPark(parking.getParkId(),month);
            parkInfoList.add(info);
        }
        return parkInfoList;
    }

    @Override
    public List<Map<String, String>> selectDateParkinfo(List<Parking> parkingList, String date) {
        List<Map<String,String>> parkInfoList=new ArrayList<>();
        for (Parking parking:parkingList) {
            Map<String,String> info=parkchangeService.getDatePark(parking.getParkId(),date);
            parkInfoList.add(info);
        }
        return parkInfoList;
    }


}
