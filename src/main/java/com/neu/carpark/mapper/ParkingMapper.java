package com.neu.carpark.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.neu.carpark.entity.Parking;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lxn123
 * @since 2019-01-29
 */
public interface ParkingMapper extends BaseMapper<Parking> {

    List<Parking> parklistPage(Pagination page);


}
