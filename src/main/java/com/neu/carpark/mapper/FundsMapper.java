package com.neu.carpark.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.neu.carpark.entity.Detect;
import com.neu.carpark.entity.Funds;
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
 * @since 2019-03-04
 */
public interface FundsMapper extends BaseMapper<Funds> {

    List<Funds> getDateFundPage (Pagination page,@Param("format")String format, @Param("state") String state, @Param("date") String date);

    List<Map<String,String>> getFundMoneysum(@Param("format")String format, @Param("date") String date);
}
