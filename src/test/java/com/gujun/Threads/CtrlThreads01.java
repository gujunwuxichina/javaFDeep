package com.gujun.Threads;

import org.junit.Test;

public class CtrlThreads01 {

    //控制线程：
    //join线程：
    //Thread提供了让一个线程等待另一个线程完成的join();
    //当在某个程序执行流中调用其它线程的join()时，调用线程(当前程序的执行流)将被阻塞，直到被join()加入的线程执行完为止；
    //join()的重载形式：
    //join(),join(long millis)等待最长时间为long毫秒；
    class JoinThread extends Thread{
        public JoinThread(String name) {
            super(name);
        }
        @Override
        public void run() {
            for(int i=0;i<20;i++){
                System.out.println(this.getName()+"-"+i);
            }
        }
    }
    @Test
    public void test01() throws InterruptedException {
        new JoinThread("子线程").start();
        for(int i=0;i<50;i++){
            System.out.println(Thread.currentThread().getName()+"-"+i);
            if(i==20){
                JoinThread joinThread=new JoinThread("被join进来的子进程");
                joinThread.start();
                joinThread.join();  //此时主线程会被阻塞，直到被join的子线程执行完才会恢复；
            }
        }
    }

    //后台线程：
    //后台线程，在后台运行，任务就是为其它线程服务；如：JVM垃圾回收线程；
    //若所有前台线程dou都死亡了，后台线程也就自动死亡了；
    //调用Thread对象的setDaemon(true)可以将指定线程设置成后台线程；必须在start()之前调用；
    //前台线程创建的子线程默认是前台线程，后台线程创建的子线程默认是后台线程；

}
