package com.stephen.demo.countdownlatch;

import java.util.concurrent.*;

/**
 * Created by stephen on 2021-02-18 9:51 .
 * Description:
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        Service service = new Service(countDownLatch);
        Runnable task = () -> service.exec();
        // // Runnable task = service.exec();
        // for (int i = 0; i < 5; i++) {
        //     Thread thread = new Thread(service);
        //     thread.start();
        // }
        // System.out.println("main thread await ");
        // countDownLatch.await();
        // System.out.println("main thread finish await");

        // new Thread(() -> {
        //     System.out.println("aaaa");
        // }).start();
        Callable<Integer> integerCallable = () -> 5;
        Integer call = integerCallable.call();
        System.out.println(call);

        Runnable runnable = () -> System.out.println("Hello lambda Runnable");
        Thread thread1 = new Thread(() -> {
            System.out.println("Hello lambda Thread");
        });

        // Thread thread = new Thread(new Runnable() {
        //     @Override
        //     public void run() {
        //         System.out.println("hello old Runnable");
        //     }
        // });

        // FutureTask<Object> futureTask = new FutureTask<Object>(new CallableDemo());
        // new Thread(futureTask).start(); // 启动线程
        // Object obj = futureTask.get(); // 获取线程返回值
        // System.out.println(obj);

        // 线程池启动线程
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new RunnableDemo());
        executorService.submit(new RunnableDemo());
        Future future = executorService.submit(new CallableDemo());
        System.out.println(future.get());
        executorService.shutdown();

    }

}
