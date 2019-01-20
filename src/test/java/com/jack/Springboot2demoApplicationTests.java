package com.jack;

import com.jack.aop.Performance;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.util.collections.ListUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.rest.core.util.MapUtils;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class Springboot2demoApplicationTests {

//    private static final Logger log = LoggerFactory.getLogger(Springboot2demoApplicationTests.class);

    @Autowired
    private Performance performance;

	@Test
	public void contextLoads() {
	}

	@Test
    public void testCountDownLatch() throws Exception{
        CountDownLatch latch = new CountDownLatch(3);
        Thread worker1 = new Thread(new Worker("jack", latch));
        Thread worker2 = new Thread(new Worker("rose", latch));
        Thread worker3 = new Thread(new Worker("json", latch));
        worker1.start();
        worker2.start();
        worker3.start();
        latch.await();
        System.out.println("main thread end");
    }
	@Test
    public void test() {
	    ArrayList<String> stringList = new ArrayList<>();
	    List<String> newStringList = (List<String>) stringList.clone();
	    Byte i = (byte)129;
        System.out.println(i);
	}

	@Test
    public void testStack() {
	    StackTraceElement[] stackTraceElements = new RuntimeException().getStackTrace();
	    System.out.println("-----------stack trace----------");
	    for (StackTraceElement ste: stackTraceElements) {
	        System.out.println(ste.toString());
        }
    }
	@Test
    public void testaop() {
	    performance.perform("jack");

        log.info("info message");
    }

    @Test
    public void testStream() {
        List<String> list = createList();
        long count = list.stream().filter(s -> {
            System.out.println("name: " + s);
            return s.contains("a");
        }).count();
        System.out.println("count: " + count);

        List<String> map = list.stream().map(s -> {
            String S = s.toUpperCase();
            System.out.println(S);
            return S;
        }).collect(Collectors.toList());

    }

    private Map<String, Integer> createMap() {
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        Map<String, Integer> map = stringIntegerHashMap;
	    map.put("aaa", 1);
	    map.put("bbb", 2);
	    map.put("aa", 3);
	    map.put("a", 4);
	    map.put("ccc", 5);
	    return map;
    }

    private List<String> createList() {
	    List<String> list = Stream.of(Arrays.asList("aaa", "aa"), Arrays.asList("bbb", "ccc")).flatMap(ss -> ss.stream()).collect(Collectors.toList());
	    return list;
    }

    @Test
    public void testArrayList() {
	    List<String> list = new ArrayList<>(Arrays.asList("a", "ab", "ac", "d"));
	    String s;
	    Iterator<String> iterator = list.iterator();
	    while (iterator.hasNext()) {
	        s = iterator.next();
	        if (s.contains("a")) {
	            iterator.remove();
            }
        }
        System.out.println(list);

    }

    static class Worker implements Runnable {
        private String workerName;

        private CountDownLatch latch;

        public Worker(String workerName, CountDownLatch latch) {
            this.workerName = workerName;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                System.out.println("Worker: " + workerName + " is begin.");
                Thread.sleep(1000L);
                System.out.println("Worker: " + workerName + " is end.");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            latch.countDown();
        }
    }
}
