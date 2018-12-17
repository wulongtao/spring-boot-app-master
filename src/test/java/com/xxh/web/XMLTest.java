package com.xxh.web;

import com.xxh.web.filter.DefaultFilterChain;
import com.xxh.web.filter.MethodFilter;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author wulongtao
 */
public class XMLTest {
    @Test
    public void test2() throws Exception {
        DefaultFilterChain filterChain = new DefaultFilterChain.Builder().xml("D:\\Project\\JavaProject\\spring-boot-app-master\\src\\main\\java\\com\\xxh\\web\\filter\\filter-config.xml").build();
        System.out.println(filterChain.doFilter("A", 1));
    }

    @Test
    public void testReadXml() throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("D:\\Project\\JavaProject\\spring-boot-app-master\\src\\main\\java\\com\\xxh\\web\\filter\\filter-config.xml"));

        Element rootNode = document.getRootElement();
        String methodName = rootNode.attributeValue("method");
        String resultType = rootNode.attributeValue("result-type");
        String paramsType = rootNode.attributeValue("params-type");
        String[] classNameArr = paramsType.split(",");
        Class[] classes = new Class[classNameArr.length];
        int index = 0;
        for (String className: classNameArr) {
            classes[index++] = Class.forName(className);
        }
        Class resultClass = Class.forName(resultType);
        List<String> filterClassList = new ArrayList<>();
        List<Element> subNodeList = rootNode.elements("filter");
        for (Element item: subNodeList) {
            filterClassList.add(item.getStringValue());
        }

        for (String className : filterClassList) {
            Class clazz = Class.forName(className);
            Object obj = clazz.newInstance();


            Method method = clazz.getMethod(methodName, classes);
            Object result = method.invoke(obj, "B", 1);
            if (Objects.isNull(result)) {
                continue;
            }

            result = resultClass.cast(result);

            System.out.println("result = " + result);
            break;
        }

    }

}
