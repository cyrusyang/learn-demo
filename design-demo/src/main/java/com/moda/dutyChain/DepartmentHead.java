package com.moda.dutyChain;

public class DepartmentHead extends Leader{
    @Override
    public void handleRequest(int leaveDays) {
        if (leaveDays <= 7) {
            System.out.println("系主任批准请假" + leaveDays+ "天");
        }else{
            System.out.println("系主任无权批准");
            Leader next = getNext();
            if (next != null) {
                next.handleRequest(leaveDays);
            }else{
                System.out.println("请假天数过多，无人审批");
            }
        }
    }
}
