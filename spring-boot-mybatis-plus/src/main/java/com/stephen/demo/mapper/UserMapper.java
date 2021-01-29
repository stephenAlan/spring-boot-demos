package com.stephen.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stephen.demo.entity.Users;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by stephen on 2021-01-29 10:55 .
 * Description: 继承通用Mapper
 */
@Mapper
public interface UserMapper extends BaseMapper<Users> {
}
