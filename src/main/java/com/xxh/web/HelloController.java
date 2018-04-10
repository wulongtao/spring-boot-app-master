package com.xxh.web;

import org.springframework.beans.factory.annotation.Value;
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
    @Value("${author.name}")
    private String authorName;
    @Value("${author.site}")
    private String authorSite;

    @RequestMapping("/say")
    public String say() {
        return "hello spring boot";
    }

    @RequestMapping("/author")
    public String author() {
        return "name=" + authorName + ",site=" + authorSite;
    }
}
