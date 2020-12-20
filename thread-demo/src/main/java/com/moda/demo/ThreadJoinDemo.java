package com.moda.demo;


public class ThreadJoinDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable("thread1"));
        thread.start();
        for (int i = 0; i < 50; i++) {
            if (i > 10) {
                thread.join();
            }
            System.out.println("Main线程运行--> :" + i);
        }
    }
}
