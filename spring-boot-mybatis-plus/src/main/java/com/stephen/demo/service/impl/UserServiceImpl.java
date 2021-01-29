package com.stephen.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stephen.demo.entity.Users;
import com.stephen.demo.mapper.UserMapper;
import com.stephen.demo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by stephen on 2021-01-29 11:01 .
 * Description: 继承通用实现类
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, Users> implements UserService {
}
