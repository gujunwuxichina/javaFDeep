package com.gujun.Threads.ThreadSync;

public class Basic01 {

    //释放同步监听器的锁定：
    //任何线程进入同步代码块、同步方法之前，必须先获得对同步监听器的锁定；何时释放同步监听器？
    //程序无须显示释放对同步监听器的锁定，如下情况会释放对其的锁定：
    //1.当前线程的同步代码块、同步方法执行结束，当前线程释放；
    //2.当前线程在同步代码块、同步方法中遇到break、return终止了该代码块、方法的继续执行，当前线程释放；
    //3.当前线程在同步代码块、同步方法中遇到未处理的异常，导致异常结束，当前线程释放；
    //4.当前线程执行同步代码块、同步方法时，程序执行了同步监听器对象的wait(),则当前线程暂停，并发释放；
    //如下情况，线程不会释放对同步监听器的锁定：
    //1.线程在执行同步代码块同步方法时，调用了Thread.sleep()/yield()来暂停当前线程的执行，当前线程不会释放锁定；
    //2.线程在执行同步代码块同步方法时，其它线程调用了该线程的suspend()将该线程挂起，该线程不释放锁定；？


    //同步锁(Lock)：
    //通过显示定义同步锁对象来实现同步，此时锁就是Lock对象；
    //Lock提供了比同步代码块/方法更广泛的锁定操作；
    //Lock是控制多个线程对共享资源进行访问的工具；锁提供了对共享资源的独占访问，每次只能有一个线程对Lock对象加锁，
    //线程访问共享资源之前先获得Lock对象；
    //某些锁允许对共享资源并发访问，如ReadWriteLock读写锁，Lock、ReadWriteLock是两个根接口；
    //ReadWriteLock的实现类ReentrantReadWriteLock，提供三种锁模式：Writing,ReadingOptimistic,Reading;
    //新增的StampedLock类，在大多数情况下可以替代ReentrantReadWriteLock;
    //在实际的线程安全控制中，比较常用的是ReentrantLock可重入锁，
    public static void main(String[] args) {
        AccountWithLock account=new AccountWithLock("100001",1800);
        new DrawThreadByLock("甲",account,900).start();
        new DrawThreadByLock("乙",account,1000).start();
    }
    //使用Lock与同步方法有些类似,

    //死锁：
    //当两个线程相互等待对方释放同步监听器时就会发生死锁；

}
