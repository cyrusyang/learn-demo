package com.moda.dutyChain;

public class ClassAdviser extends Leader{
    @Override
    public void handleRequest(int leaveDays) {
        if (leaveDays <= 2) {
            System.out.println("班主任批准请假"+ leaveDays +"填");
        }else{
            System.out.println("班主任无权批准");
            Leader next = getNext();
            if (next != null) {
                next.handleRequest(leaveDays);
            }else{
                System.out.println("请假天数过多，无人审批");
            }
        }
    }
}
