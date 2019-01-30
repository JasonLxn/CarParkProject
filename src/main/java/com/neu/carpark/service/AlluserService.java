package com.neu.carpark.service;

import com.neu.carpark.entity.Alluser;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lxn123
 * @since 2019-01-29
 */
public interface AlluserService extends IService<Alluser> {

    /**
     * 登录密码加密
     * @param alluser 登录用户
     */
    void encryptionPwd(Alluser alluser);

    /**
     * 获取用户角色
     * @param alluser 用户实例
     * @return 用户角色类型
     */
    String getUserRolename(Alluser alluser);
}
