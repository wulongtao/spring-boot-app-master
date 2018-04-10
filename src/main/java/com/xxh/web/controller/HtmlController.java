package com.xxh.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author wulongtao
 * @date 2018/4/10
 */
@Controller
@RequestMapping("/html")
public class HtmlController {
    @RequestMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("host", "http://www.xiaoxiaohei.top");
        return "index";
    }
}
