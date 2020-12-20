package com.moda.demo;

public class TicketRunnable implements Runnable{

    private int ticket;

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    @Override
    public void run() {
        while (true) {
            if (ticket <= 0) {
                break;
            }
            synchronized (this){
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ticket--;
                    System.out.println(Thread.currentThread().getName()+"售出--当前票数:" + ticket);

                }
            }

        }
    }
}
