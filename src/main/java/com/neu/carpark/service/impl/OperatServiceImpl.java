package com.neu.carpark.service.impl;

import com.neu.carpark.entity.Alluser;
import com.neu.carpark.entity.Operat;
import com.neu.carpark.mapper.OperatMapper;
import com.neu.carpark.service.OperatService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lxn123
 * @since 2019-01-29
 */
@Service
public class OperatServiceImpl extends ServiceImpl<OperatMapper, Operat> implements OperatService {

    @Override
    public void updateLogintime(String id, Date newlogintime) {
        Operat operat=this.selectById(id);
        operat.setOperLogintime(newlogintime);
        this.updateById(operat);
    }

    @Override
    public String getOpername(Alluser alluser) {
        Operat operat=this.selectById(alluser.getAllId());
        return operat.getOperName();
    }
}
