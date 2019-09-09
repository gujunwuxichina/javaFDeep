package com.gujun.Threads.ThreadGroup;

import org.junit.Test;

public class Basic01 {

    //线程组和未处理的异常：
    //ThreadGroup代表线程组，可以对一批线程进行分类管理（可以直接对线程组进行控制，相当于同时控制一批线程）；
    //创建的线程都属于指定线程组，若没有指定则属于默认线程组；默认下子线程和创建它的父线程属于同一线程组；
    //一旦某个线程加入了指定线程组，则一直属于该线程组，直到线程死亡；过程中不得改变所属线程组；
    //thread.getThreadGroup();
    //构造器和方法：
    //ThreadGroup(String name)/ThreadGroup（ThreadGroup parent,String name);
    //int activeCount(),返回组中活动线程的数目；
    //interrupt(),中断组中的所有线程；
    //isDaemon(),判断是否是后台线程组；
    //setDaemon(boolean),setMaxPriority(int)；
    @Test
    public void test01(){
        System.out.println(Thread.currentThread().getThreadGroup().getName());
    }
    //ThreadGroup还定义一个方法：void uncaughtException(Thread t,Throwable e),可以处理组中任意现场所抛出的未处理异常；
    //Thread.UncaughtExceptionHandler是Thread的一个静态内部接口，该接口里只有一个方法void uncaughtException(Thread t,Throwable e)；
    //Java增强了线程的异常处理，若线程在执行过程中抛出了未处理异常，会在线程结束之前，查找是否有对应Thread.UncaughtExceptionHandler对象，
    //如果找到该对象，调用其uncaughtException(Thread t,Throwable e)处理异常；
    //Thread两个设置异常处理器的方法：
    //1.static setDefaultUncaughtExceptionHandler(Thread.UncaughtExceptionHandler eh),为该线程类的所有实例设置默认异常处理器；
    //2.setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler eh),未指定线程实例设置默认异常处理器；
    //ThreadGroup实现了Thread.UncaughtExceptionHandler接口，所以每个线程会将其所属线程组作为默认异常处理器；
    //当一个线程抛出异常时，会先查找该线程对应的异常处理器，找不到调用该异常所属线程组的uncaughtException()来处理异常；
    //tip:异常处理器与通过catch来捕获异常是不同的，使用异常处理器处理异常后，异常依然会传播给上一个调用者；

    public static void main(String[] args) {
        Thread.currentThread().setUncaughtExceptionHandler((t,e)->{
            System.out.println(e.getMessage());
        });
        int a=10/0;
        System.out.println("end");  //不会输出,和catch不同；
    }

}
