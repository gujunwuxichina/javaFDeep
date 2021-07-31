package com.gujun.ultimate.thread;

/**
 * @ClassName: Test01
 * @Author GuJun
 * @Description:
 * @Date 2021年07月31日 10:47
 */
public class Test01 {

    //  线程概述
    //  每个运行中的程序就是一个进程，每个程序中可能包含多个顺序执行流，每个顺序执行流就是一个线程；
    //  并发，指在同一时刻只能有一条指令执行，但多个进程指令被快速轮换进行，使得好像同时进行；
    //  并行，指同一时刻多个进程指令在多个在多个处理器上同时执行；

    //  线程的创建和启动
    //  Thread类代表线程类，线程对象必须是Thread类或其子类；
    //  实现Runnable接口创建线程
    //  使用Callable和Future创建线程：
    //  Callable接口提供一个call()来作为线程执行体；call()可以有返回值；
    //  Callable接口不是Runnable的子接口，所以不能直接作为Thread的target;
    //  为此提供了Future接口，其代表call()的返回值；Future接口实现类FutureTask实现类，也实现了Runnable接口；
    //  Future接口方法：get()，isCancelled(),idDone()...;



}
