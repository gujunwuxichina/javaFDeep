package com.gujun.Threads;

import org.junit.Test;

import java.util.concurrent.*;

public class Basic01 {

    //多线程概述：
    //线程和进程：
    //运行中的任务通常对应的一个进程，即当一个程序进入内存运行时，就变成一个进程；
    //并发和并行：
    //并发：指在用一个时刻只有一条指令执行，但是多个进程指令被快速轮换执行，宏观上表现为多个进程同时执行的效果；
    //并行：指在同一时刻，有多条指令在多个处理器同时执行；
    //多线程扩展了多进程的概念，使得同一个进程可以同时并发处理多个任务；
    //线程被称为轻量级进程，是进程的执行单元，就像操作系统的进程一样；
    //线程在程序中是独立的，并发的执行流，当进程初始化后，主线程就被创建了；
    //总结为，操作系统可以同时执行多个任务，每个任务就是进程；进程可以同时执行多个任务，每个任务就是线程；

    //Java使用Thread类代表线程 ，所有线程对象必须是Thread类或其子类的实例；
    //1.继承Thread来创建线程：
    class Thread01 extends Thread{
        private int i=0;
        public Thread01(String name) {
            super(name);
        }
        public Thread01() {
        }
        @Override
        public void run() { //run()的方法体就是线程执行体；
            for(;i<100;i++){
                System.out.println(getName()+"-"+i);    //getName()返回当前线程的名字；
            }
        }
    }
    @Test
    public void test01(){
        System.out.println(Thread.currentThread().getName());   //获取主线程名字
        //两个线程输出的i是不共享的，因为i是实例变量，每次创建线程都会创建一个新的Thread01实例；
        new Thread01("线程01").start();   //主动指定线程名
        new Thread01().start();
    }

    //2.实现Runnable接口创建线程类：
    class Thread02 implements Runnable{
        private int i=0;
        @Override
        public void run() {
            for(;i<100;i++){
                System.out.println(Thread.currentThread().getName()+'-'+i);
            }
        }
    }
    @Test
    public void test02(){
        Thread02 target=new Thread02(); //Runnable的实现实例作为Thread构造器的参数；也可以通过Lambda来创建Runnable实例；
        //两个线程共享了变量i,因为Runnable实例只是线程的target，多个线程可以共享该target；
        new Thread(target,"线程01").start();
        new Thread(target,"线程02").start();
    }

    //3.使用Callable和Future创建线程：
    //Callable接口，该接口有个call(),可以作为线程执行体；call()可以有返回值，可以声明抛出异常；
    //Callable实例可以作为Thread的target，线程执行体就是call();
    //但是问题来了：Callable接口不是Runnable接口的子接口，且call()不是直接调用的，而是作为线程执行体被调用，其返回值如何获取呢？
    //为此提供了Future接口，其代表call()的返回值，其实现类FutureTask实现类，该实现类也实现了Runnable接口，可以作为target;
    //Future接口里提供了如下方法来控制它关联的Callable任务：
    //boolean cancel(boolean),试图取消该Future里关联的Callable任务；
    //V get(),返回call()返回值，调用该方法会导致程序阻塞，必须等到子线程执行完后才会得到返回值；
    //V get(long,TimeUnit),指定阻塞等待时间，若指定时间后依然没有返回值，则抛出TimeoutException；
    //boolean isCancelled(),如果在任务正常完成前被取消，则返回true;
    //boolean isDone(),若任务已完成，则返回true;
    //tip：Callable接口是带泛型的，泛型类型与call()返回值类型相同；

    @Test
    public void test03(){
        FutureTask<Integer> task=new FutureTask<Integer>(()->{  //Lambda
             int i=0;
             for(;i<100;i++){
                 System.out.println(Thread.currentThread().getName()+"-"+i);
             }
             return i;
        });
        System.out.println(Thread.currentThread().getName());   //主线程名
        new Thread(task,"线程01").start();
        //new Thread(task,"线程02").start();  //？
        try {
            System.out.println(task.get()); //获取线程返回值
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
