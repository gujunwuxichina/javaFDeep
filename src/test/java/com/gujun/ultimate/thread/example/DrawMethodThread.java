package com.gujun.ultimate.thread.example;

/**
 * @ClassName: DrawMethodThread
 * @Author GuJun
 * @Description:
 * @Date 2021年08月12日 16:45
 */
public class DrawMethodThread extends Thread {

    private Account account;

    private Double drawAmount;

    public DrawMethodThread(String name, Account account, Double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        account.draw(drawAmount);
    }
}
