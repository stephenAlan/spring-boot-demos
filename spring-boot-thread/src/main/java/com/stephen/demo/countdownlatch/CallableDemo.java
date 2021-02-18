package com.stephen.demo.countdownlatch;

import java.util.concurrent.Callable;

/**
 * Created by stephen on 2021-02-18 10:40 .
 * Description:
 */
public class CallableDemo implements Callable {
    @Override
    public Object call() throws Exception {
        // 线程执行的内容
        System.out.println(Thread.currentThread().getName() + " call 方法");
        // return中是返回值,只有用FutureTask的get()方法才能拿到
        return Thread.currentThread().getName() + "callable的call方法的返回结果";
    }


}
