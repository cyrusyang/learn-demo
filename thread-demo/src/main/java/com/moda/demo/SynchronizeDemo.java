package com.moda.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizeDemo {
    public static void main(String[] args) {

        //1 线程
//        TicketRunnable ticketRunnable = new TicketRunnable();
//        ticketRunnable.setTicket(1000);
//        Thread thread1 = new Thread(ticketRunnable);
//        Thread thread2 = new Thread(ticketRunnable);
//        Thread thread3 = new Thread(ticketRunnable);
//        thread1.start();
//        thread2.start();
//        thread3.start();
        //2. 线程池
        ExecutorService executorService = new ThreadPoolExecutor(3, 9,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(100));
        Studnet st = new Studnet();
        st.setName("张三");
        AtomicInteger atomicInteger = new AtomicInteger(0);
        st.setAge(atomicInteger.get());
        int num = 0;
        for (int i = 0; i < 100; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    synchronized (this){
//                        System.out.println(st.getAge());
                        st.setAge(atomicInteger.addAndGet(1));
                        System.out.println(atomicInteger.get());
                    }

                }
            });

        }

        executorService.shutdown();
        System.out.println("ddd:"+ st.getAge());
    }

}
