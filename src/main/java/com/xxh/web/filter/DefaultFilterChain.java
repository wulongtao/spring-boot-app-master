package com.xxh.web.filter;

/**
 * @author wulongtao
 */
public class DefaultFilterChain extends AbstractFilterChain {

    private DefaultFilterChain() {

    }

    @Override
    public Object doFilter(Object... args) {
        return super.doFilter(args);
    }

    public static class Builder {
        private DefaultFilterChain target;

        public Builder() {
            target = new DefaultFilterChain();
        }

        public Builder xml(String xml) {
            target.xml = xml;
            return this;
        }

        public DefaultFilterChain build() {
            target.loadConfig();
            return target;
        }
    }
}
