package com.xxh.web.repository;

import com.xxh.web.repository.dao.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by wulongtao on 2018/4/11.
 */
public interface UserRepository extends MongoRepository<User, Long> {
    User findByUsername(String username);
}
