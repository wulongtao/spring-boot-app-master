package com.xxh.web.filter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author wulongtao
 */
public class BMethodFilter implements MethodFilter {
    @Override
    public Map<String, String> makeAction(String key, Integer index) {
        if (Objects.equals(key, "B")) {
            Map<String, String> map = new HashMap<>();
            map.put("name", "BMethodFilter B");
            return map;
        }
        return null;
    }
}
