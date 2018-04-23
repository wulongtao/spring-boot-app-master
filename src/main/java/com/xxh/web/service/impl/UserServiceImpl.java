package com.xxh.web.service.impl;

import com.xxh.web.mapper.UserMapper;
import com.xxh.web.mapper.dao.User;
import com.xxh.web.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wulongtao on 2018/4/11.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserMapper userMapper;


    @Transactional
    @Override
    public User findByName() {
//        int id = userMapper.insert("AAA", 20);
        User u = userMapper.findByName("CCC");
//        User u = userMapper.findById(id);
        return u;
    }

    @Override
    public List<User> findAllUsers() {
        userMapper.listUsers();
        return userMapper.listUsers();
    }

    @Override
    public User testEhcache() {
        /*userMapper.insert("BBB", 15);
        User u = new User(34, "CCC", 16);
        userMapper.update(u);*/
        /*userMapper.findByName("BBB");
        User u = userMapper.findByName("BBB");

        System.out.println("old user == " + u.getName() + "-" + u.getId());

        u.setName("CCC");
        u.setAge(88);

        System.out.println("new user == " + u.getName() + "-" + u.getId());
        userMapper.update(u);*/

        userMapper.findByName("CCC");

        userMapper.findByName("CCC");


        return userMapper.findByName("CCC");
    }


}
