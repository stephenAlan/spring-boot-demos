package com.stephen.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Created by stephen on 2021-01-29 10:54 .
 * Description:
 */
@Data
@TableName("users")
public class Users {

    private Long id;

    private String username;

    private String password;

}
