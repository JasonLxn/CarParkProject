package com.neu.carpark.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.neu.carpark.entity.Detect;
import com.baomidou.mybatisplus.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lxn123
 * @since 2019-03-03
 */
public interface DetectService extends IService<Detect> {

    /**
     * 分页获取指定维修员维修报告的列表
     * @param page 分页
     * @param opstid 维修员id
     * @param date 按年月格式如201902
     * @return
     */
    Page<Detect> getOperDetePage(Page<Detect> page, @Param("opstid") String opstid, @Param("date") String date);
}
