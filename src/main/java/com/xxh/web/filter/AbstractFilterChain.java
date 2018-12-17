package com.xxh.web.filter;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author wulongtao
 */
public abstract class AbstractFilterChain implements FilterChain {
    protected String xml = "filter-config.xml";
    protected String paramsType;
    protected String resultType;
    protected String methodName;
    protected List<String> filterList = new ArrayList<>();

    protected void loadConfig() {
        try {
            SAXReader reader = new SAXReader();
            Document document = reader.read(new File(xml));

            Element rootNode = document.getRootElement();
            this.methodName = rootNode.attributeValue("method");
            this.resultType = rootNode.attributeValue("result-type");
            this.paramsType = rootNode.attributeValue("params-type");
            filterList.clear();
            List<Element> subNodeList = rootNode.elements("filter");
            for (Element item: subNodeList) {
                filterList.add(item.getStringValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object doFilter(Object... args) {
        try {
            String[] classNameArr = paramsType.split(",");
            Class resultClass = Class.forName(resultType);
            Class[] classes = new Class[classNameArr.length];
            int index = 0;
            for (String className: classNameArr) {
                classes[index++] = Class.forName(className);
            }
            for (String className : filterList) {
                Class clazz = Class.forName(className);
                Object obj = clazz.newInstance();


                Method method = clazz.getMethod(methodName, classes);
                Object result = method.invoke(obj, args);

                if (Objects.isNull(result)) {
                    continue;
                }

                return resultClass.cast(result);
            }

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
