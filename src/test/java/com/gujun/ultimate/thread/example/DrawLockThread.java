package com.gujun.ultimate.thread.example;

/**
 * @ClassName: DrawLockThread
 * @Author GuJun
 * @Description:
 * @Date 2021年08月12日 17:29
 */
public class DrawLockThread extends Thread {

    private Account account;

    private Double drawAmount;

    public DrawLockThread(String name, Account account, Double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        account.drawLock(drawAmount);
    }
}
