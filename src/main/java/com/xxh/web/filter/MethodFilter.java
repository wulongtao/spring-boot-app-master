package com.xxh.web.filter;

import java.util.Map;

/**
 * @author wulongtao
 */
public interface MethodFilter {

    Map<String, String> makeAction(String key, Integer index);

}
