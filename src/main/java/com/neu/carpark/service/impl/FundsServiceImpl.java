package com.neu.carpark.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.neu.carpark.entity.Funds;
import com.neu.carpark.mapper.FundsMapper;
import com.neu.carpark.service.FundsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lxn123
 * @since 2019-03-04
 */
@Service
public class FundsServiceImpl extends ServiceImpl<FundsMapper, Funds> implements FundsService {

    @Override
    public Page<Funds> getDateFundPage(Page<Funds> page,String format, String state, String date) {
        page.setRecords(baseMapper.getDateFundPage(page,format,state,date));
        return page;
    }

    @Override
    public List<Map<String, String>> getFundMoneysum(String format, String date) {
        List<Map<String, String>> list=baseMapper.getFundMoneysum(format,date);
        return list;
    }
}
