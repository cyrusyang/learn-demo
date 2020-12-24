package com.moda.dutyChain;

import lombok.Data;

@Data
public abstract class Leader {
    private Leader next;

    public abstract void handleRequest(int leaveDays);

    public Leader appendNext(Leader leader) {
        this.next = leader;
        return this;
    }
}
