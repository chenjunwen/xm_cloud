package com.xm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class ConfigServerApplicationTests {

    Logger logger = LoggerFactory.getLogger(ConfigServerApplicationTests.class);

    private final int THREAD_NUM = 1000;

    private AtomicInteger ticketCountAtomic = new AtomicInteger(10);

    private CountDownLatch countDownLatch = new CountDownLatch(THREAD_NUM);

    private int ticketCount = 10;

    @Test
    public void contextLoads() throws InterruptedException {
        Ticket target = new Ticket();
        for (int i = 0; i < THREAD_NUM; i++) {
            new Thread(target, "用户" + (i + 1)).start();
            long count = countDownLatch.getCount();
            // 每执行一下减一
            countDownLatch.countDown();
        }

        // 等待子线程执行完
        //Thread.currentThread().join();

    }

    public class Ticket implements Runnable {
        @Override
        public void run() {
            // 让所有的线程等待，只有到countDownLatch的count到0才会执行
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (true) {
                //int ticketCount = ticketCountAtomic.getAndDecrement();
                String name = Thread.currentThread().getName();
                if (ticketCount > 1) {
                    try {
                        //Thread.sleep(10);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    ticketCount--;
                    logger.info(name + "抢到票，剩余" + ticketCount + "张");
                } else {
                    //logger.warn(name+"票卖完了---------->>");
                    break;
                }


            }


        }
    }

}
