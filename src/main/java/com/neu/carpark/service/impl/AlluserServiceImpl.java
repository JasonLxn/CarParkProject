package com.neu.carpark.service.impl;

import com.neu.carpark.config.shiro.ShiroUtils;
import com.neu.carpark.entity.Alluser;
import com.neu.carpark.mapper.AlluserMapper;
import com.neu.carpark.service.AlluserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lxn123
 * @since 2019-01-21
 */
@Service
public class AlluserServiceImpl extends ServiceImpl<AlluserMapper, Alluser> implements AlluserService {

    @Override
    public void encryptionPwd(Alluser alluser) {
        //生成指定长度的字母和数字的随机组合字符串
        String salt= RandomStringUtils.randomAlphanumeric(20);
        alluser.setAllSalt(salt);
        alluser.setAllPwd(ShiroUtils.sha256(alluser.getAllPwd(),alluser.getAllSalt()));
    }
}
