package com.doth;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static volatile boolean flag = true;
    private static volatile int counter = 0;
    private static AtomicInteger count = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        //volatility();
        //sync();
        multipleThread();
    }

    public static void multipleThread() throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for(int i=0; i < 1000; i++){
            threadPool.submit(()->{
                String now = new Main().getDate();
                System.out.println(now + " "+threadPool.toString());
            });
        }
        Thread.sleep(1000);
    }


    private static void volatility(){

        new Thread(()->{
            while(flag){
                System.out.println("Thread 1");
            }
        }).start();

        new Thread(()->{
            flag = false;
            System.out.println("Thread 2");
        }).start();

    }

    private static void sync(){

        new Thread(()->{
            System.out.println("sync Thread 1 " + count.addAndGet(1));

        }).start();

        new Thread(()->{
            System.out.println("sync Thread 2 " + count.addAndGet(1));
        }).start();

    }

    public static String getDate(){
        Date now = new Date(System.currentTimeMillis());
        SimpleDateFormat df = ThreadSafeFormatter.dateFormatter.get();
        return df.format(now);
    }

}
