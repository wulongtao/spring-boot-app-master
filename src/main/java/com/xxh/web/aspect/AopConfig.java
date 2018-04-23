package com.xxh.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author 小小黑
 */
@Configuration
@Aspect
public class AopConfig {
    @Around("@within(org.springframework.web.bind.annotation.RestController)")
    public Object simpleAop(final ProceedingJoinPoint pjp) throws Throwable {
        try {
            Object[] args = pjp.getArgs();
            System.out.println("args:" + Arrays.asList(args));

            Object o = pjp.proceed();
            System.out.println("return : " + o);
            return o;
        } catch (Throwable e) {
            throw e;
        }
    }
}
