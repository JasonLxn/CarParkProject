package com.neu.carpark.service.impl;

import com.neu.carpark.entity.Users;
import com.neu.carpark.mapper.UsersMapper;
import com.neu.carpark.service.UsersService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lxn123
 * @since 2019-03-04
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

}
