package com.stephen.demo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stephen.demo.common.ListResult;
import com.stephen.demo.entity.Users;
import com.stephen.demo.mapper.UserMapper;
import com.stephen.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by stephen on 2021-01-29 10:56 .
 * Description:
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("list")
    public Object list(@RequestParam int current,@RequestParam int pageSize) {
        // mybatisplus分页
        Page<Users> page = new Page<>(current,pageSize);
        userService.page(page);
        long totalPage = page.getTotal() % pageSize == 0 ? page.getTotal() / pageSize : page.getTotal() / pageSize + 1;
        List<Users> records = page.getRecords();
        ListResult<Users> result = new ListResult<>(current,pageSize,totalPage,page.getTotal(),records);
        return result;
    }

    @GetMapping("get/{id}")
    public Object get(@PathVariable Long id) {
        return userService.getById(id);
    }

}
