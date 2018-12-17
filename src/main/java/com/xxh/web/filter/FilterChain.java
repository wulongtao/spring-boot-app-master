package com.xxh.web.filter;

/**
 * @author wulongtao
 */
public interface FilterChain {

    Object doFilter(Object... args);

}
