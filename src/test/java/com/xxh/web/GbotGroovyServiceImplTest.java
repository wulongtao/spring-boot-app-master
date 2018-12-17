package com.xxh.web;

import com.giantan.gbot.groovy.service.GbotGroovyService;
import com.giantan.gbot.groovy.service.impl.GbotGroovyServiceImpl;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wulongtao
 */
public class GbotGroovyServiceImplTest {

    @Test
    public void testParseGroovy() {
        String expression = "if(a == \"a23\") return \"a = 123\";";
        Map<String, Object> params = new HashMap<>();
        params.put("a", "a23");


        GbotGroovyService gbotGroovyService = new GbotGroovyServiceImpl();
        System.out.println(gbotGroovyService.parseGroovy(expression, params));
    }

}