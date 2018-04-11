package com.xxh.web.repository.dao;

import org.springframework.data.annotation.Id;

/**
 *
 * @author wulongtao
 * @date 2018/4/11
 */
public class User {
    @Id
    private Long id;

    private String username;
    private Integer age;

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public User(Long id, String username, Integer age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
