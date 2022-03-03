package com.zzl.example.interviewed;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: zhile.zhang
 * @date: 2020/5/22
 * @desc:
 **/
public class Test {


    /**
     * 输出结果：
     * i=0,activeCount=1
     * i=1,activeCount=1
     * i=2,activeCount=2
     * i=3,activeCount=3
     * i=4,activeCount=3
     * 4
     * 【正确】
     * @param args
     */
    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger();
        int corePoolSize = 1;
        int maximumPoolSize = 3;
        long keepAliveTime = 10;
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>(1);
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        RejectedExecutionHandler handler = new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {/*什么也不做
             */
            }
        };
        ThreadPoolExecutor pool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
        for (int i = 0; i < 5; i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count.addAndGet(1);
                }
            });
            System.out.printf("i=%d,activeCount=%d\n", i, pool.getActiveCount());
        }
        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print(count.toString());
    }

    /**
     * 程序的输出结果为SbSaCaCb 【错误】 应该为SbSaCbCaCb
     * @param args
     */
    /*public static void main(String[] args) {
        A a=new A();
        B b=new B();
    }*/

    /**
     * 程序的输出结果为14 【错误】
     * @param args
     */
    /*public static void main(String[] args) {
        int key = 1;
        switch (key) {
            case 1:
                System.out.print(1);
            case 2:
                System.out.print(2);
            case 3:
                System.out.print(3);
                break;
            default:
                System.out.print(4);
        }
    }*/


    /**
     * // 输出结果为:tm 和mt 都有可能  【错误】run 和 start 不一样
     * @param args
     */
   /* public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print("t");
            }
        });
        t.run(); //TODO run he start 不一样
        System.out.print("m");
    }*/
}
