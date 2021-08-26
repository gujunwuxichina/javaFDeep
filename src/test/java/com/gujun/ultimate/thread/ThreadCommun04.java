package com.gujun.ultimate.thread;

/**
 * @ClassName: ThreadCommun04
 * @Author GuJun
 * @Description:
 * @Date 2021年08月12日 17:37
 */
public class ThreadCommun04 {

    //  线程通信
    //  当线程在系统内运行时，线程的调度具有透明性，无法准确控制；
    //  为此可以借助于Object的wait(),notify(),notifyAll();必须由同步监视器来调用；
    //  wait()，当前线程暂停，直到其它线程调用notify()/notifyAll()来唤醒该线程；
    //  notify(),唤醒在此同步监视器等待的单个线程；多个的话随机；
    //  notifyAll(),唤醒等待的所有线程；


    //  Condition控制线程通信
    //  若同步线程不是使用同步代码块或同步方法，而是使用Lock；
    //  这样就不存在同步监视器，为此Java提供了Condition来保持协调；
    //  使用Condition可以让那些获取Lock对象无法执行的线程释放Lock对象，也可以唤起其它处于等待的线程；
    //  Condition实例可以绑定在一个Lock对象上，调用Lock对象的newCondition();
    //  Condition实例的方法：await(),signal(),signalAll();

    //  使用阻塞队列控制线程通信
    //  HH


    //  线程组和未处理的异常
    //  ThreadGroup表示线程组；创建的线程属于指定线程组，若没有指定属于默认线程组；子线程和创建它的父线程属于同一线程组；
    //  setThreadGroup()，getThreadGroup()；
    //  uncaughtException(Thread,Throwable),可以处理该线程组内的任意线程所抛出的未处理异常；
    //  HH


}
