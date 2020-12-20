package com.moda.demo;

public class MyRunnableDemo {
    public static void main(String[] args) {
        MyRunnable runnable1 = new MyRunnable("thread1");
        MyRunnable runnable2 = new MyRunnable("thread2");
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
    }
}
