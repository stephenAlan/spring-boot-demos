package com.stephen.demo.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by stephen on 2021-02-18 9:52 .
 * Description:
 */
public class Service implements Runnable{

    private CountDownLatch countDownLatch;

    public Service(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public void exec() {
        try {
            System.out.println(Thread.currentThread().getName() + "execute task");
            sleep(2);
            System.out.println(Thread.currentThread().getName() + "finish task");
        } finally {
            countDownLatch.countDown();
        }
    }

    public void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + "execute task");
            sleep(2);
            System.out.println(Thread.currentThread().getName() + "finish task");
        } finally {
            countDownLatch.countDown();
        }
    }
}
