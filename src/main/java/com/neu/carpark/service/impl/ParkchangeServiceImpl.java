package com.neu.carpark.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.neu.carpark.entity.Parkchange;
import com.neu.carpark.mapper.ParkchangeMapper;
import com.neu.carpark.service.ParkchangeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class ParkchangeServiceImpl extends ServiceImpl<ParkchangeMapper, Parkchange> implements ParkchangeService {
    @Autowired
    ParkchangeMapper parkchangeMapper;

    @Override
    public Map<String,String> getDayPark(String id,int day) {
        Map<String,String> parkInfoList=parkchangeMapper.getDayPark(id,day);
        return parkInfoList;
    }

    @Override
    public Map<String, String> getMonthPark(String id, int month) {
        Map<String,String> parkInfoList=parkchangeMapper.getMonthPark(id, month);
        return parkInfoList;
    }

    @Override
    public Map<String, String> getDatePark(String id, String date) {
        Map<String,String> parkInfoList=parkchangeMapper.getYearMonthPark(id,date);
        return parkInfoList;
    }

    @Override
    public List<Integer> getuseNum(List<String> datelist) {
        List<Integer> parkTimeNumList=new ArrayList<>();
        for (String date:datelist) {
            int useNum=this.selectCount(new EntityWrapper<Parkchange>().eq("parc_astate","使用中")
                    .addFilter("(DATEDIFF(parc_time,{0})=0)",date));
            parkTimeNumList.add(useNum);
        }
        return parkTimeNumList;
    }

    @Override
    public List<Integer> geterrorNum(List<String> datelist) {
        List<Integer> parkTimeNumList=new ArrayList<>();
        for (String date:datelist) {
            int errorNum=this.selectCount(new EntityWrapper<Parkchange>().eq("parc_astate","故障中")
                    .addFilter("(DATEDIFF(parc_time,{0})=0)",date));
            parkTimeNumList.add(errorNum);
        }
        return parkTimeNumList;
    }

    @Override
    public List<Integer> getserviceNum(List<String> datelist) {
        List<Integer> parkTimeNumList=new ArrayList<>();
        for (String date:datelist) {
            int serviceNum=this.selectCount(new EntityWrapper<Parkchange>().eq("parc_astate","维修中")
                    .addFilter("(DATEDIFF(parc_time,{0})=0)",date));
            parkTimeNumList.add(serviceNum);
        }
        return parkTimeNumList;
    }
}
