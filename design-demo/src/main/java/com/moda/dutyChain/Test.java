package com.moda.dutyChain;

public class Test {
    public static void main(String[] args) {
        Leader leader = new ClassAdviser().appendNext(new DepartmentHead().appendNext(new Dean()));
        leader.handleRequest(1111);
    }
}
