package com.xxh.web.filter;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wulongtao
 */
@Component
public class TestBean {
    private String a;
    private String b;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }
}
