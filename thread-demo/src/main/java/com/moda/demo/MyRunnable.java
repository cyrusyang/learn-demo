package com.moda.demo;

public class MyRunnable implements Runnable{
    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(name+"运行, i="+ i);
        }
    }
}
