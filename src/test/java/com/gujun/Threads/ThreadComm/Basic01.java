package com.gujun.Threads.ThreadComm;

public class Basic01 {

    //线程通信
    //线程的调度具有一定的透明性，程序通常无法准确控制线程的轮换执行，Java提供了一些机制来保证线程的协调运行；
    //传统的线程通信：
    //Object类提供了方法（必须由同步监听器对象来调用）：
    //wait(),导致当前线程等待，直到其它线程调用同步监听器对象的notify()或notifyALl()来唤醒该线程；三种重载形式：
    //无时间参数（一直等待直到其它线程通知），有时间参数/带微妙的（等待指定时间后自动苏醒），调用wait()的当前线程都会释放同步监听器的锁定；
    //notify(),唤醒在此同步监听器上等待的单个线程，如果有多个线程在等待，则随机唤醒一个；
    //notifyAll(),唤醒在此同步监听器上等待的全部线程;

    //以下最终会造成线程阻塞；
    public static void main(String[] args) {
        AccountComm account=new AccountComm("A100001",0);
        new DrawThread("甲",account,800).start();
        new DepositAccount("乙",account,800).start();
        new DepositAccount("丙",account,800).start();
        new DepositAccount("丁",account,800).start();
    }

}
