package com.gujun.Threads.ThreadComm;

public class Basic02 {

    //使用Condition控制线程通信：
    //如果程序不是synchronized关键字来保证同步，而是直接使用Lock对象来保证同步；则系统中不存在隐式的同步监听器，不能调用wait()、notify()、notifyAll();
    //为此Java提供了Condition类来保持协调，它可以让已经得到Lock对象的线程释放Lock对象，也可以唤醒其它处于等待的线程；
    //Condition实例被绑定在一个Lock对象上，要获得特定Lock实例的Condition实例，调用Lock对象的newCondition();
    //await()，该方法有多个变体；signal();signalAll();

    static class DrawThreadC extends Thread{

        private AccountCondition account;

        private double amount;

        public DrawThreadC(String name, AccountCondition account, double amount) {
            super(name);
            this.account = account;
            this.amount = amount;
        }

        @Override
        public void run() {
            for(int i=0;i<100;i++){
                account.draw(amount);
            }
        }
    }

    static class DepositThreadC extends Thread{

        private AccountCondition account;

        private double amount;

        public DepositThreadC(String name, AccountCondition account, double amount) {
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

    public static void main(String[] args) {
        AccountCondition account=new AccountCondition("200001",0);
        new DrawThreadC("甲",account,800).start();
        new DepositThreadC("乙",account,800).start();
        new DepositThreadC("丙",account,800).start();
        new DepositThreadC("丁",account,800).start();
    }

}
