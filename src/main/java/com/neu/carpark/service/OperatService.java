package com.neu.carpark.service;

import com.neu.carpark.entity.Operat;
import com.baomidou.mybatisplus.service.IService;

import java.util.Date;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lxn123
 * @since 2019-01-24
 */
public interface OperatService extends IService<Operat> {

    /**
     * 修改最后一次登录时间
     * @param id 登录ID
     * @param newlogintime 新的登录时间
     */
    void updateLogintime(String id, Date newlogintime);
}
