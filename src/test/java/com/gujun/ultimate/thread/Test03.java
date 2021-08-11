package com.gujun.ultimate.thread;

import com.gujun.ultimate.annotation.Test01;
import com.gujun.ultimate.thread.example.Account;
import com.gujun.ultimate.thread.example.DrawThread;
import org.junit.Test;

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
        DrawThread drawThread1=new DrawThread("甲",account,800.0);
        DrawThread drawThread2=new DrawThread("乙",account,800.0);
        drawThread1.start();
        drawThread2.start();
    }

    public static void main(String[] args) {
        testBlock();
    }


}
