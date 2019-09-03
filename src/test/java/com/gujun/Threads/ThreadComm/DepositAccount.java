package com.gujun.Threads.ThreadComm;

public class DepositAccount extends Thread {

    private AccountComm account;

    private double amount;

    public DepositAccount(String name, AccountComm account, double amount) {
        super(name);
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            account.deposit(amount);
        }
    }
}
