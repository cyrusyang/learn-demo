package com.moda.demo;

public class MyThread extends Thread{
    private String name;

    public MyThread(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(name + "运行，i="+i);
        }
    }
}
