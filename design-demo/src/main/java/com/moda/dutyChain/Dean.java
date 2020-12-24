package com.moda.dutyChain;

public class Dean extends Leader{
    @Override
    public void handleRequest(int leaveDays) {
        System.out.println("院长批准请假");
    }
}
