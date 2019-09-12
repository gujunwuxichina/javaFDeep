package com.gujun.Threads.ThreadAboutClass;

import org.junit.Test;

public class ThreadLocalTest {

    //ThreadLocal类，代表一个线程局部变量，通过把数据放在ThreadLocal中就可以让每个线程创建一个该变量的副本，避免并发访问的线程安全问题；
    //支持泛型；
    //方法：get(),remove(),set(T),获取/删除/设置此线程局部变量当前线程副本中的值；

    class Man{
        private ThreadLocal<String> name=new ThreadLocal<>();
        public String getName(){
            return name.get();
        }
        public void setName(String name){
            this.name.set(name);
        }
        public Man(String name) {
            this.name.set(name);
        }
    }
    class ManThread extends Thread{
        private Man man;
        public ManThread(String name, Man man) {
            super(name);
            this.man = man;
        }
        @Override
        public void run() {
            System.out.println(this.getName()+"线程-"+man.getName());
        }
    }
    @Test
    public void test01(){
        Man man=new Man("gujun");
        System.out.println(Thread.currentThread().getName()+"线程-"+man.getName());
        new ManThread("甲",man).start(); //null
        new ManThread("乙",man).start(); //null
    }

}
