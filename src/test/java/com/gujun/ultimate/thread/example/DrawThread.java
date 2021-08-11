package com.gujun.ultimate.thread.example;

/**
 * @ClassName: DrawThread
 * @Author GuJun
 * @Description:
 * @Date 2021年08月11日 12:51
 */
public class DrawThread extends Thread {

    private Account account;

    private Double drawAmount;

    public DrawThread(String name, Account account, Double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        synchronized (account){
            if(account.getBalance()>=drawAmount){
                System.out.println(Thread.currentThread().getName()+"取钱成功:"+drawAmount);
                try {
                    Thread.sleep(800*1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                account.setBalance(account.getBalance()-drawAmount);
                System.out.println("余额:"+account.getBalance());
            }else{
                System.out.println(Thread.currentThread().getName()+"取钱失败,余额不足");
            }
        }
    }
}
