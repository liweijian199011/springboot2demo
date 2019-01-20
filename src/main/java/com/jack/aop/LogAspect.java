package com.jack.aop;

import org.aspectj.lang.annotation.AfterReturning;
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
 * DATE 2018/3/13.
 *
 * @author liweijian.
 */
@Aspect
@Component
public class LogAspect {

    @Before("execution(* com.jack.service.UserService.listUser(..))")
    public void logBefore() {
        System.out.println("Before: ");
    }
    @AfterReturning("execution(* com.jack.service.UserService.listUser(..)) && args(object)")
    public void insertLog(Object object) {
        System.out.println(object);
    }

    Map<String, Integer> map = new HashMap<>();
}
