package com.neu.carpark.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.neu.carpark.entity.Detect;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.neu.carpark.entity.Feedback;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lxn123
 * @since 2019-03-03
 */
public interface DetectMapper extends BaseMapper<Detect> {

    List<Detect> getOperDetePage(Pagination page, @Param("opstid") String opstid, @Param("date") String date);

}
