package com.xxh.web.controller;

import com.xxh.web.component.LocaleMessageSourceComponent;
import com.xxh.web.vo.ResVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wulongtao on 2018/4/25.
 */
@RestController
@RequestMapping("/json")
public class JsonController {
    @Autowired
    LocaleMessageSourceComponent localeMessageSourceComponent;

    @RequestMapping("/i18n")
    public ResVO<String> i18n() {
        ResVO<String> resVO = new ResVO<>();
        resVO.setResult(0);
//        resVO.setMessage(localeMessageSourceComponent.getMessage("hello"));

        System.out.println("localeMessageSourceComponent==" + localeMessageSourceComponent.getMessage("hello"));
        return resVO;
    }

}
