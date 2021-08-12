package com.gujun.ultimate.thread;

import com.gujun.ultimate.thread.example.Account;
import com.gujun.ultimate.thread.example.DrawBlockThread;
import com.gujun.ultimate.thread.example.DrawLockThread;
import com.gujun.ultimate.thread.example.DrawMethodThread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: Test03
 * @Author GuJun
 * @Description:
 * @Date 2021年08月11日 11:19
 */
public class Test03 {

    //  线程同步
    //  Java多线程引入了同步监视器；

    //  同步代码块：
    //  synchronized(obj){..}
    //  obj就是同步监视器，即线程开始执行同步代码块之前，必须先获取对同步监视器的锁定；
    //  任何时刻只有一个线程会获取同步监视器的锁定，当同步代码块执行完后，线程会释放对同步监视器的锁定；
    //  Java允许使用任何对象作为同步监视器，一般使用被并发访问的资源作为同步监视器；
    public static void testBlock(){
        Account account=new Account("001",1000.0);
        DrawBlockThread drawThread1=new DrawBlockThread("甲",account,800.0);
        DrawBlockThread drawThread2=new DrawBlockThread("乙",account,800.0);
        drawThread1.start();
        drawThread2.start();
    }

    //  同步方法
    //  使用synchronized修个方法；对于实例方法，此时无须指定同步监视器，this就是同步监视器；
    public static void testMethod(){
        Account account=new Account("001",1000.0);
        DrawMethodThread drawThread1=new DrawMethodThread("甲",account,800.0);
        DrawMethodThread drawThread2=new DrawMethodThread("乙",account,800.0);
        drawThread1.start();
        drawThread2.start();
    }

    //  释放同步监视器的锁定
    //  线程进入同步代码块、同步方法前必须获取对同步监视器的锁定；
    //  释放同步监视器的时机：
    //  1.同步代码块，同步方法执行完；
    //  2.遇到break,return终止执行；
    //  3.出现了未处理的Error或Exception，终止执行；
    //  4.当线程中执行了同步监视的wait(),当前线程暂停，释放同步监视器；
    //  不会释放时机：
    //  1.线程调用sleep()，yield()来暂停线程，不会释放同步监视器；
    //  2.线程执行时同步地方时，其它线程调用了该线程的suspend()将该线程挂起，该线程不会释放同步监视器；

    //  同步锁
    //  通过显示定义同步锁来实现同步；同步锁是Lock对象；
    //  Lock是控制多个线程对共享资源进行访问的工具；
    //  锁提供了对共享资源的独占访问，每次只能有一个线程对Lock对象加锁，线程开始访问共享资源前应先获取Lock对象；
    //  有些锁允许对共享资源的并发访问;H
    //  ReentrantLock可重入锁，Lock实现类，可以显示加锁、释放锁：
    //    class x {
    //        private final ReentrantLock lock=new ReentrantLock();
    //        public void m(){
    //            lock.lock();
    //            try {
    //
    //            } finally {
    //                lock.unlock();
    //            }
    //        }
    //    }
    public static void testLock(){
        Account account=new Account("001",1000.0);
        DrawLockThread drawThread1=new DrawLockThread("甲",account,800.0);
        DrawLockThread drawThread2=new DrawLockThread("乙",account,800.0);
        drawThread1.start();
        drawThread2.start();
    }


    public static void main(String[] args) {
//        testBlock();
//        testMethod();
        testLock();
    }


}
