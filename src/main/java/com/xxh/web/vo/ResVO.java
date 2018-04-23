package com.xxh.web.vo;

import org.springframework.stereotype.Component;

/**
 * @author 小小黑
 */
@Component
public class ResVO {
    private Integer result;
    private String message;
    private Object data;

    public ResVO() {
    }

    public ResVO(Integer result, String message) {
        this.result = result;
        this.message = message;
    }

    public ResVO(Integer result, String message, Object data) {
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

    public void setData(Object data) {
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
