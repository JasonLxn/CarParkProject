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

    /**
     * 获取每月订单中各天的金额总和
     * @param format 时间格式 如："%Y%m"
     * @param date 时间 如："201904"
     * @return
     */
    List<Map<String,String>> getFundMoneysum(@Param("format")String format, @Param("date") String date);

    /**
     * 获取月份收益的总和
     * @param num 1表示上个月，0表示当月
     * @return
     */
    double getMonthFund(@Param("num") int num);
}
