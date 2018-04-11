package com.xxh.web.mapper;

import com.xxh.web.mapper.dao.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
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

    @Select("SELECT * FROM `user` WHERE `name`=#{name}")
    User findByName(@Param("name") String name);

    @Cacheable
    @Select("SELECT * FROM `user`")
    List<User> listUsers();

    @Insert("INSERT INTO `user`(`name`,`age`) VALUES(#{name}, #{age})")
    Integer insert(@Param("name") String name, @Param("age") Integer age);
}
