package com.gujun.ultimate.thread;

import com.gujun.ultimate.annotation.Test01;
import org.junit.Test;

import java.util.concurrent.ForkJoinPool;

/**
 * @ClassName: ThreadPool
 * @Author GuJun
 * @Description:
 * @Date 2021年08月15日 12:23
 */
public class ThreadPool {

    //  线程池
    //  启动新线程成本较高，为此提供了线程池；
    //  Executors工厂类来创建线程池：
    //  HHH

    //  ForkJoinPool
    //  是ExecutorService的实现类
    //  HH
    @Test
    public void test01(){
        System.out.println(ForkJoinPool.getCommonPoolParallelism());
    }

    //  ThreadLocal
    //  代表一个线程局部变量，通过把数据放在ThreadLocal中可以让每个线程创建一个该变量的副本；
    //  ThreadLocal<T>:
    //  get();
    //  remove(),删除此线程局部变量中当前线程副本中的值；
    //  set(T);

}
