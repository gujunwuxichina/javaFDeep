package com.gujun.Threads.ThreadSync;

import java.util.Objects;

public class AccountWithSyncMethod {

    private String accountNo;

    private double balance;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    //同步方法：
    //就是使用synchronized关键字修饰方法，则该方法就是同步方法；
    //对于synchronized修饰的实例方法，无需显示指定其同步监听器，因为同步监听器就是this,调用该方法的对象；
    //即对于同一个Account而言，任何时刻只能有一个线程获得对Account的锁定，然后进入draw();
    public synchronized void draw(double drawAmount){
        if(balance>=drawAmount){
            System.out.println(Thread.currentThread().getName()+"取钱成功,取出"+drawAmount);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance-=drawAmount;
            System.out.println("余额为:"+balance);
        }else{
            System.out.println(Thread.currentThread().getName()+"余额不足,取钱失败!");
        }
    }

    public AccountWithSyncMethod() {
    }

    public AccountWithSyncMethod(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountWithSyncMethod that = (AccountWithSyncMethod) o;
        return Objects.equals(accountNo, that.accountNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNo);
    }

}
