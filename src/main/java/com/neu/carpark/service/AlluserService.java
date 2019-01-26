package com.neu.carpark.service;

import com.neu.carpark.entity.Alluser;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lxn123
 * @since 2019-01-21
 */
public interface AlluserService extends IService<Alluser> {

    /**
     * 生成盐，并加密密码
     */
    void encryptionPwd(Alluser alluser);
}
