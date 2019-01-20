package com.jack.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Description
 * <p>
 * </p>
 * DATE 2018/3/12.
 *
 * @author liweijian.
 */
//@Aspect
@Component
public class Counter {

    private Map<String, Integer> count = new HashMap<>(16);

    @Pointcut("execution(* com.jack.aop.Performance.perform(String)) && args(name)")
    public void count(String name) {}

    @Before("count(name)")
    public void countAccess(String name) {
        int currentCount = getCount(name);
        count.put(name, currentCount++);
        System.out.println("name : " + name + ", count access: " + currentCount++);
    }

    private Integer getCount(String name) {
        return count.getOrDefault(name, 0);
    }
}
