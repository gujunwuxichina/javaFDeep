package com.gujun.Threads.ThreadPool;

import java.util.concurrent.Executors;

public class Basic01 {

    //系统启动一个新线程涉及到与系统交互，所以其成本是比较高的；
    //为此可以使用线程池来提高性能；
    //与数据库连接池类似，线程池会在系统启动时创建大量空闲的线程，程序将一个Runnable对象或Callable对象传给线程池，
    //线程池就会启动一个线程来执行其run()或call()，当方法执行完后该线程并不会死亡，而是返回线程池中成为空闲状态，等待下一次执行；

    //Executors工厂类来产生线程池，创建线程池的静态方法：
    //ExecutorService newCachedThreadPool(),创建一个具有缓存功能的线程池，系统根据需要创建线程，这些线程被缓存到线程池中；
    //ExecutorService newFixedThreadPool(int),创建一个可重用，具有固定线程数的线程池；
    //ExecutorService newSingleThreadExecutor(),创建只有一个线程的线程池；
    //ScheduledExecutorService newScheduledThreadPool(int),创建具有指定线程数的线程池，可以在指定延迟后执行线程任务；
    //ScheduledExecutorService newSingleThreadScheduledExecutor(),创建只有一个线程的线程池，可以在指定延迟后执行线程任务；
    //ExecutorService newWorkStealingPool(int),创建持有足够多的线程的线程池支持给定的并行级别，该方法还会使用多个队列来减少竞争；
    //ExecutorService newWorkStealingPool(),根据cpu个数来设置并行级别，即传入的参数；

    //ExecutorService代表尽快执行线程的线程池，方法：
    //Future<?> submit(Runnable),Future代表Runnable的返回值，但是run()并没有返回值，所以Future对象将在run()执行完后返回null,可以调用Future的isDone()、isCancelled()来获得Runnable对象的执行状态；
    //<T> Future<T> submit(Runnable,T),其中T显式指定线程执行结束后的返回值，即所以Future对象将在run()执行完后返回T;

}
