package com.xxh.web.controller;

import com.xxh.web.bean.ErrorInfo;
import com.xxh.web.handler.MyException;
import com.xxh.web.redis.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wulongtao
 * @date 2018/4/10
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @Value("${author.id}")
    private String authorId;
    @Value("${author.name}")
    private String authorName;
    @Value("${author.site}")
    private String authorSite;
    @Value("${author.desc}")
    private String authorDesc;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate<String, User> redisTemplate;

    @RequestMapping("/say")
    public String say() {
        return "hello spring boot";
    }

    @RequestMapping("/author")
    public String author() {
        return "authorId=" + authorId  + ",name=" + authorName + ",site=" + authorSite + ",desc=" + authorDesc;
    }

    @RequestMapping("/hello")
    public String hello() throws Exception {
        throw new Exception("发生错误");
    }

    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("发生错误2");
    }

    @RequestMapping("/redisObj")
    public User redisObj(String id) {
        User user = new User(id, 20);
        redisTemplate.opsForValue().set("user"+id, user);
        return redisTemplate.opsForValue().get("user"+id);
    }

    @RequestMapping("/redisStr")
    public String redisStr(String value) {
        stringRedisTemplate.opsForValue().set("id", value);

        return stringRedisTemplate.opsForValue().get("id");
    }
}
