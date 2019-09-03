package com.gujun.Threads.ThreadComm;

import java.util.Objects;

public class AccountComm {

    private String accountNo;

    private double balance;

    private boolean hasMoney=false;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public AccountComm() {
    }

    public AccountComm(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountComm that = (AccountComm) o;
        return Objects.equals(accountNo, that.accountNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNo);
    }

    public synchronized void draw(double amount){
        try {
            if(!hasMoney){  //若没钱，则线程等待，不进行取钱操作
                wait();
            }else{
                System.out.println(Thread.currentThread().getName()+"取钱成功,取出"+amount);
                balance-=amount;
                System.out.println("余额为:"+balance);
                hasMoney=false;
                notifyAll();    //唤醒其它线程
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized  void deposit(double amount){
        try {
            if(hasMoney){   //有钱则线程等待，不进行存钱操作
                wait();
            }else{
                System.out.println(Thread.currentThread().getName()+"存入"+amount);
                balance+=amount;
                System.out.println("余额为:"+balance);
                hasMoney=true;
                notifyAll();    //唤醒其它线程
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
