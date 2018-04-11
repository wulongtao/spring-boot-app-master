package com.xxh.web.service.impl;

import com.xxh.web.mapper.UserMapper;
import com.xxh.web.mapper.dao.User;
import com.xxh.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wulongtao on 2018/4/11.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Transactional
    @Override
    public User findByName() {
        int id = userMapper.insert("AAA", 20);
//        User u = userMapper.findByName("AAA");
        User u = userMapper.findById(id);
        return u;
    }

    @Override
    public List<User> findAllUsers() {
        userMapper.listUsers();
        return userMapper.listUsers();
    }


}
