package com.neu.carpark.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.neu.carpark.entity.Detect;
import com.neu.carpark.entity.Funds;
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
 * @since 2019-03-04
 */
public interface FundsService extends IService<Funds> {

    /**
     * 分页获取订单信息
     * @param page 分页
     * @param state 支付状态
     * @param date 日期 格式为201904
     * @return
     */
    Page<Funds> getDateFundPage(Page<Funds> page,@Param("format")String format,@Param("state") String state, @Param("date") String date);

    List<Map<String,String>> getFundMoneysum(@Param("format")String format, @Param("date") String date);
}
