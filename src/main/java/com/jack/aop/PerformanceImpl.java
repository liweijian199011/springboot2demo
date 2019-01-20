package com.jack.aop;

import org.springframework.stereotype.Component;

/**
 * Description
 * <p>
 * </p>
 * DATE 2018/3/12.
 *
 * @author liweijian.
 */
@Component
public class PerformanceImpl implements Performance {

    @Override
    public void perform() {
        System.out.println("this is performance");
    }

    @Override
    public void perform(String name) {
        System.out.println("this is performance for " + name);
    }

    @Override
    public void perform(String name, Integer age) {
        System.out.println("this is performance for " + name + ", age is " + age);
    }
}
