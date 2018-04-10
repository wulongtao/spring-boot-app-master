package com.xxh.web.redis;

import java.io.Serializable;

/**
 *
 * @author wulongtao
 * @date 2018/4/10
 */
public class User implements Serializable {
    private String username;
    private Integer age;

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
