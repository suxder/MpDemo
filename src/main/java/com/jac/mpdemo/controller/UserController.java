package com.jac.mpdemo.controller;

import com.jac.mpdemo.entity.User;
import com.jac.mpdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user")
    public List query() {

        // mybatis的写法
        // List<User> list = userMapper.find();
        List<User> list = userMapper.selectList(null);
        System.out.println(list);
        // 返回的值会自动转为JSON
        return list;
    }

    @PostMapping("/user")
    public String save(User user) {

        int i = userMapper.insert(user);
        if (i > 0) {
            return "插入成功";
        } else {
            return "插入失败";
        }
    }
}
