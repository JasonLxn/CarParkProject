package com.neu.carpark.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.neu.carpark.config.shiro.ShiroUtils;
import com.neu.carpark.entity.Alluser;
import com.neu.carpark.entity.Role;
import com.neu.carpark.entity.Userrole;
import com.neu.carpark.mapper.AlluserMapper;
import com.neu.carpark.service.AlluserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.neu.carpark.service.RoleService;
import com.neu.carpark.service.UserroleService;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    UserroleService userroleService;
    @Autowired
    RoleService roleService;

    @Override
    public void encryptionPwd(Alluser alluser) {
        //生成指定长度的字母和数字的随机组合字符串
        String salt= RandomStringUtils.randomAlphanumeric(20);
        alluser.setAllSalt(salt);
        alluser.setAllPwd(ShiroUtils.sha256(alluser.getAllPwd(),alluser.getAllSalt()));
    }

    @Override
    public String getUserRolename(Alluser alluser) {
        Userrole userrole=userroleService.selectOne(new EntityWrapper<Userrole>().eq("ur_allid",alluser.getAllId()));
        Role role=roleService.selectOne(new EntityWrapper<Role>().eq("ro_id",userrole.getUrRoid()));
        return role.getRoName();
    }
}
