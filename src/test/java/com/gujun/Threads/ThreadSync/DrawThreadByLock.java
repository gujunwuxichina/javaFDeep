package com.gujun.Threads.ThreadSync;

public class DrawThreadByLock extends Thread{

    private AccountWithLock account;

    private double drawAmount;

    public DrawThreadByLock(String name, AccountWithLock account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        account.draw(drawAmount);
    }

}
