package com.jack.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Description
 * <p>
 * </p>
 * DATE 2018/3/12.
 *
 * @author liweijian.
 */
@Aspect
@Component
public class Audience {

    @Pointcut("execution(* com.jack.aop.Performance.perform(..))")
    public void perform() {}



    @Before("perform()")
    @Order(1)
    public void sim() {
        System.out.println("Taking seats");
    }

    @Before("perform()")
    @Order(2)
    public void silenceCellPhones() {
        System.out.println("Silencing cell phones");
    }



    @AfterReturning("perform()")
    public void applause() {
        System.out.println("CLAP CLAP CLAP!");
    }

    @AfterThrowing("perform()")
    public void demanRefund() {
        System.out.println("Demanding a refund");
    }

    @Around("perform()")
    public void watchPerformance(ProceedingJoinPoint jp) {
        try {
            System.out.println("silencing cell phones!!!!!");
            jp.proceed();
        } catch (Throwable e) {
            System.out.println("demanding a refund");
        }
    }
}
