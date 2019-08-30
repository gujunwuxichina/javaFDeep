package com.gujun.Threads.ThreadSync;

public class DrawThreadByMethod extends Thread {

    private AccountWithSyncMethod account;

    private double drawAmount;

    public DrawThreadByMethod(String name, AccountWithSyncMethod account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        account.draw(drawAmount);
    }
}
