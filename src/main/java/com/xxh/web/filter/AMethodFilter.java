package com.xxh.web.filter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author wulongtao
 */
public class AMethodFilter implements MethodFilter {
    @Override
    public Map<String, String> makeAction(String key, Integer index) {
        if (Objects.equals(key, "A")) {
            Map<String, String> map = new HashMap<>();
            map.put("name", "AMethodFilter A");
            return map;
        }
        return null;
    }
}
