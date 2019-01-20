package com.jack.multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Description
 * <p>
 * </p>
 * DATE 2019/1/13.
 *
 * @author liweijian.
 */
public class CountDowLatchTest {

    volatile List<String> lists = new ArrayList<>();

    public void add(String s) {
        lists.add(s);
    }

    public int size() {
        return lists.size();
    }

    public static void main(String[] args) {
        CountDowLatchTest test = new CountDowLatchTest();

        CountDownLatch latch = new CountDownLatch(1);

        new Thread(() -> {
            System.out.println("thread2 start");
            try {
                latch.await();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            System.out.println("thread2 ends");
        }, "thread2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        new Thread(() -> {
            System.out.println("thread1 start");
            for (int i = 0; i < 100; i++) {
                test.add("" + i);

                System.out.println("add " + i);
                if (test.size() == 5) {
                    latch.countDown();
                }

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }, "thread1").start();
    }
}
