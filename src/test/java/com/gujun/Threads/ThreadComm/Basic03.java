package com.gujun.Threads.ThreadComm;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Basic03 {

    //使用阻塞队列BlockingQueue控制线程通信：
    //BlockingQueue接口（Queue的子接口）；
    //特征：当生产者线程试图向BlockingQueue放入元素，若该队列已满，则该线程阻塞；
    //当消费者线程试图从BlockingQueue中取出元素，若该队列为空，则该线程阻塞；
    //方法：
    //put(e),向队列尾部中放入元素，若已满，则线程阻塞；
    //take(),尝试从队列头部取出元素，若为空，则线程阻塞；
    //由于BlockingQueue继承了Queue接口，也可以使用Queue的方法：
    //队列尾部插入元素：add(e),offer(e),put(e),当队列满时，这三个方法分别会抛出异常，返回false,阻塞队列；
    //在队列头部删除并返回元素，remove(),poll(),take(),当队列为空时，三个方法分别会抛出异常，返回false，阻塞队列；
    //在队列头部取出但不删除元素，element(),peek(),当队列为空时，分别会抛出异常，返回false;
    //实现类：
    //ArrayBlockingQueue，基于数组实现；
    //LinkedBlockingQueue，基于链表实现；
    //PriorityBlockingQueue,与PriorityQueue类似，该队列取出元素时并不是存在时间最久的元素，而是队列中最小的元素，元素的排序可以时自然和定制；
    //SynchronousQueue，同步队列，对该队列的存取必须交替进行；
    //DelayQueue，底层基于PriorityBlockingQueue实现，不过该队列要求元素都实现Delay接口，该接口只有一个long getDelay(),根据元素的getDelay()
    //返回值来排序；

    static class Producer extends Thread{
        private BlockingQueue<String> blockingDeque;
        public Producer(String name, BlockingQueue<String> blockingDeque) {
            super(name);
            this.blockingDeque = blockingDeque;
        }
        @Override
        public void run() {
            while (true){
                try {
                    System.out.println(getName()+"放入元素");
                    Thread.sleep(2000);
                    blockingDeque.put("1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer extends Thread{
        private BlockingQueue<String> blockingDeque;
        public Consumer(String name, BlockingQueue<String> blockingDeque) {
            super(name);
            this.blockingDeque = blockingDeque;
        }
        @Override
        public void run() {
            while (true){
                try {
                    System.out.println(getName()+"取出元素");
                    Thread.sleep(2000);
                    blockingDeque.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        BlockingQueue<String> blockingDeque=new ArrayBlockingQueue<>(1);
        new Producer("甲",blockingDeque).start();
        new Consumer("乙",blockingDeque).start();
    }

}
