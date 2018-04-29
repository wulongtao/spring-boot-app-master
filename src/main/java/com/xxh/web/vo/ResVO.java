package com.xxh.web.vo;

import com.xxh.web.component.LocaleMessageSourceComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author 小小黑
 */
public class ResVO<T> {

    private Integer result;
    private String message;
    private T data;

    public ResVO() {
    }

    public ResVO(Integer result, String message) {
        this.result = result;
        this.message = message;
    }

    public ResVO(Integer result, String message, T data) {
        this.result = result;
        this.message = message;
        this.data = data;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResVO{" +
                "result=" + result +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
