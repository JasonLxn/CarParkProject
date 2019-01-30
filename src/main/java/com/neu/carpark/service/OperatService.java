package com.neu.carpark.service;

import com.neu.carpark.entity.Alluser;
import com.neu.carpark.entity.Operat;
import com.baomidou.mybatisplus.service.IService;

import java.util.Date;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lxn123
 * @since 2019-01-29
 */
public interface OperatService extends IService<Operat> {

    /**
     * 更新用户登录时间
     * @param id 用户ID
     * @param newlogintime 新的登录时间
     */
    void updateLogintime(String id, Date newlogintime);

    /**
     * 获取登录用户姓名
     * @param alluser
     * @return
     */
    String getOpername(Alluser alluser);
}
