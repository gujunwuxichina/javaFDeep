package com.gujun.Threads;

import org.junit.Test;

public class CtrlThreads02 {

    //线程睡眠sleep:
    //如果需要让正在执行的线程暂停一段时间，并进入阻塞状态，可以调用Thread的静态方法sleep();
    //sleep()重载形式：
    //sleep(long millis);暂停long毫秒，并进入阻塞状态；
    //sleep(long millis,int nanos);很少用到
    //当当前线程调用sleep()进入阻塞状态后，在睡眠时间内，该线程不会得到执行机会，即使系统中没有其它可执行的线程，它也不会执行；

    //线程让步：yield
    //yield()和sleep()一样也是静态方法，可以让当前线程暂停，但是不会进入阻塞状态而是进入就绪状态；
    //yield()只是让当前线程暂停一下，让系统调度器重新调度一下，完全有可能调用了yield()后某个线程暂停一下后有重新执行；
    //sleep()和yield()区别：
    //1.sleep()后是进入阻塞状态，yield()是进入就绪状态；
    //2.sleep()后会给其它线程执行机会，不会理会其它线程的优先级；yield()后只会给优先级相同或更高的线程执行机会；
    //3.sleep()会抛出InterruptedException，yield()没有抛出任何异常；
    //4.sleep()比yield()有更好的移植性，不推荐使用yield()来控制并发线程的执行；

    //改变线程优先级：
    //优先级高的线程获得较多的执行机会，优先级低的线程获得的执行机会就较少；
    //每个线程的优先级都和创建它的父线程相同；默认下，main()拥有普通优先级，则main()创建的子线程也拥有普通优先级；
    //Thread提供了setPriority(int),getPriority()来设置、获取优先级；
    //setPriority()的参数可以是1-10之间，也可以使用Thread的三个静态常量；（推荐用静态常量，这样有更好的移植性）

    class PriorityThread extends Thread{
        public PriorityThread(String name) {
            super(name);
        }
        @Override
        public void run() {
            for(int i=0;i<10;i++){
                System.out.println(this.getName()+",优先级:"+this.getPriority()+"-"+i);
            }
        }
    }

    //多核CPU效果不明显
    @Test
    public void test01(){
        System.out.println("主线程优先级:"+Thread.currentThread().getPriority()); //5
        for(int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"-"+i);
            if(i==20){
                PriorityThread thread1=new PriorityThread("低优先级子线程");
                thread1.start();
                thread1.setPriority(Thread.MIN_PRIORITY);
                PriorityThread thread2=new PriorityThread("高优先级子线程");
                thread2.start();
                thread2.setPriority(Thread.MAX_PRIORITY);
            }
        }
    }

}
