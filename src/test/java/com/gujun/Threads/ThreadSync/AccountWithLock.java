package com.gujun.Threads.ThreadSync;

import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountWithLock {

    private Lock lock=new ReentrantLock();

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

    public void draw(double drawAmount){
        lock.lock();    //加锁
        try {
            if(balance>=drawAmount){
                System.out.println("取钱成功,取出"+drawAmount);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                balance-=drawAmount;
                System.out.println("余额为:"+balance);
            }else{
                System.out.println(Thread.currentThread().getName()+"取钱失败,余额不足!");
            }
        }finally {
            lock.unlock();  //释放锁
        }
    }

    public AccountWithLock() {
    }

    public AccountWithLock(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountWithLock that = (AccountWithLock) o;
        return Objects.equals(accountNo, that.accountNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNo);
    }



}
