package com.xxh.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 小小黑
 */
//@Controller
public class ErrorController extends AbstractErrorController {
    private static final String ERROR_PATH = "/ERROR";
    private static final String JSON_SUFFIX = ".json";
    private Logger logger = LoggerFactory.getLogger(ErrorController.class);
    @Autowired
    ObjectMapper objectMapper;

    public ErrorController() {
        super(new DefaultErrorAttributes());
    }

    @RequestMapping(ERROR_PATH)
    public ModelAndView getErrorPath(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> model = Collections.unmodifiableMap(getErrorAttributes(request, false));
        //获取异常，有可能为空
        Throwable cause = getCause(request);
        int status = (int) model.get("status");
        //错误信息
        String message = (String) model.get("message");
        //友好提示
        String errorMessage = getErrorMessage(cause);
        //后台打印日志信息方便查错
        logger.info(status + "," + message, cause);
        response.setStatus(status);
        if (!isJsonRequest(request)) {
            ModelAndView view = new ModelAndView("error");
            view.addAllObjects(model);
            view.addObject("errorMessage", errorMessage);
            view.addObject("status", status);
            view.addObject("cause", status);
            return view;
        } else {
            Map<String, Object> error = new HashMap<>();
            error.put("success", false);
            error.put("errorMessage", errorMessage);
            error.put("message", message);
            writeJson(response, error);
            return null;
        }
    }

    private void writeJson(HttpServletResponse response, Map<String, Object> error) {
    }

    private boolean isJsonRequest(HttpServletRequest request) {
        String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
        if (requestUri != null && requestUri.endsWith(JSON_SUFFIX)) {
            return true;
        }
        return request.getHeader("Accept").contains("application/json");
    }

    private String getErrorMessage(Throwable cause) {
        return "服务器错误，请联系管理员";
    }

    private Throwable getCause(HttpServletRequest request) {
        Throwable error = (Throwable) request.getAttribute("javax.servlet.error.exception");
        if (error != null) {
            //MVC 有可能会封装异常成ServletException，需要调用getCause获取真正的异常
            while (error instanceof ServletException && error.getCause() != null) {
                error = ((ServletException)error).getCause();
            }
        }
        return error;
    }

    @Override
    public String getErrorPath() {
        System.out.println("getErrorPath");
        return null;
    }
}
