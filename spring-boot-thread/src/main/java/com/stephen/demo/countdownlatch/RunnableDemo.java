package com.stephen.demo.countdownlatch;

/**
 * Created by stephen on 2021-02-18 10:54 .
 * Description:
 */
public class RunnableDemo implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "Runnable");
    }
}
