package com.gujun.Threads.ThreadComm;

import java.util.Objects;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountCondition {

    private final Lock lock=new ReentrantLock();

    private final Condition condition=lock.newCondition();

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

    public AccountCondition() {
    }

    public AccountCondition(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountCondition that = (AccountCondition) o;
        return Objects.equals(accountNo, that.accountNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNo);
    }

    public void draw(double amount){
        lock.lock();
        try {
            if(!hasMoney){
                condition.await();
            }else{
                System.out.println(Thread.currentThread().getName()+"取钱成功,取出"+amount);
                balance-=amount;
                System.out.println("余额为:"+balance);
                hasMoney=false;
                condition.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void deposit(double amount){
        lock.lock();
        try {
            if(hasMoney){
                condition.await();
            }else{
                System.out.println(Thread.currentThread().getName()+"存入"+amount);
                balance+=amount;
                System.out.println("余额为:"+balance);
                hasMoney=true;
                condition.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
