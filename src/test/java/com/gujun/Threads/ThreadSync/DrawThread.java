package com.gujun.Threads.ThreadSync;

public class DrawThread extends Thread {

    private Account account;

    private double drawAmount;

    public DrawThread(String name, Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    //同步代码块：
    @Override
    public void run() {
        //此处同步监听器是account;
        //任何时刻只有一个线程可以获得对同步监听器的锁定，当同步代码块执行完后，该线程就会释放对同步监听器的锁定；
        synchronized (account){
            if(account.getBalance()>=drawAmount){
                System.out.println(this.getName()+"取钱成功,取出"+drawAmount);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                account.setBalance(account.getBalance()-drawAmount);
                System.out.println("余额为:"+account.getBalance());
            }else{
                System.out.println(this.getName()+"取钱失败,余额不足!");
            }
        }
    }

}
