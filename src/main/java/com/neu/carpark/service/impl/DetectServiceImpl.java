package com.neu.carpark.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.neu.carpark.entity.Detect;
import com.neu.carpark.mapper.DetectMapper;
import com.neu.carpark.service.DetectService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lxn123
 * @since 2019-03-03
 */
@Service
public class DetectServiceImpl extends ServiceImpl<DetectMapper, Detect> implements DetectService {

    @Override
    public Page<Detect> getOperDetePage(Page<Detect> page, String opstid, String date) {
        page.setRecords(baseMapper.getOperDetePage(page,opstid,date));
        return page;
    }
}
