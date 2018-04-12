package com.xxh.web.mapper;

import com.xxh.web.mapper.dao.User;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 *
 * @author wulongtao
 * @date 2018/4/11
 */
@CacheConfig(cacheNames = "users")
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM `user` WHERE `id` = #{id}")
    User findById(@Param("id") Integer id);

    @Cacheable(key = "#p0")
    @Select("SELECT * FROM `user` WHERE `name`=#{name}")
    User findByName(@Param("name") String name);

    @Cacheable
    @Select("SELECT * FROM `user`")
    List<User> listUsers();


    @Insert("INSERT INTO `user`(`name`,`age`) VALUES(#{name}, #{age})")
    Integer insert(@Param("name") String name, @Param("age") Integer age);

    @CachePut(key = "#p0.name")
    @Update("UPDATE `user` SET `name`=#{name},`age`=#{age} WHERE `id`=#{id}")
    Integer update(User user);
}
