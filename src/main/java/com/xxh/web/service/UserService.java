package com.xxh.web.service;

import com.xxh.web.mapper.dao.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by wulongtao on 2018/4/11.
 */
public interface UserService {
    User findByName();

    List<User> findAllUsers();
}
