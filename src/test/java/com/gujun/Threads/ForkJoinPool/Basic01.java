package com.gujun.Threads.ForkJoinPool;

import org.junit.Test;

import java.awt.print.Printable;
import java.util.concurrent.*;

public class Basic01 {

    //为了充分挖掘多核CPU的潜力；
    //可以通过ForkJoinPool来将一个任务拆分成多个小任务并行执行；
    //ForkJoinPool是ExecutorService的实现类，是一种特殊的线程池；
    //构造器：
    //ForkJoinPool(int)创建一个包含int个并行线程的ForkJoinPool；
    //ForkJoinPool()以Runtime.availableProcessors()返回值作为int参数来创建ForkJoinPool；
    @Test
    public void test01(){
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        System.out.println(forkJoinPool.getParallelism());
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(ForkJoinPool.getCommonPoolParallelism());
    }
    //方法：
    //static ForkJoinPool commonPool(),返回一个通用池，通用池的运行状态不受shutdown()和shutdownNow()影响；
    //static int getCommonPoolParallelism()，返回通用池的并行级别；

    //创建ForkJoinPool实例后，就可以调用submit(ForkJoinTask)或invoke(ForkJoinTask)来执行指定任务了；
    //ForkJoinTask代表一个可以并行、合并的任务；
    //ForkJoinTask是一个抽象类，有两个抽象子类：
    //RecursiveAction表示无返回值的任务，RecursiveTask表示有返回值的任务；

     class PrintAction extends RecursiveAction{
        private static final int amount=50;
        private int start;
        private int end;
        public PrintAction(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        protected void compute() {
            if(end-start<amount){
                for(int i=start;i<end;i++){
                    System.out.println(Thread.currentThread().getName()+"的i值:"+i);
                }
            }else{
                int middle=(end+start)/2;
                PrintAction printActionLeft=new PrintAction(start,middle);
                PrintAction printActionRight=new PrintAction(middle,end);
                printActionLeft.fork();
                printActionRight.fork();
            }
        }
    }
    @Test
    public void test02() throws InterruptedException {
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        forkJoinPool.submit(new PrintAction(0,300));
        forkJoinPool.awaitTermination(2, TimeUnit.SECONDS);
        forkJoinPool.shutdown();
    }
    class SumTask extends RecursiveTask<Integer>{
        private static final int amount=50;
        private int[] ints;
        private int start;
        private int end;
        public SumTask(int[] ints, int start, int end) {
            this.ints = ints;
            this.start = start;
            this.end = end;
        }
        @Override
        protected Integer compute() {
            int sum=0;
            if(end-start<amount){
                for(int i=start;i<end;i++){
                    sum+=ints[i];
                }
                return sum;
            }else{
                int middle=(start+end)/2;
                SumTask sumTaskLeft=new SumTask(ints,start,middle);
                SumTask sumTaskRight=new SumTask(ints,middle,end);
                sumTaskLeft.fork();
                sumTaskRight.fork();
                return sumTaskLeft.join()+sumTaskRight.join();
            }
        }
    }
    @Test
    public void test03() throws ExecutionException, InterruptedException {
        int[] ints=new int[100];
        for(int i=0,j=ints.length;i<j;i++){
            ints[i]=i+1;
        }
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        Future<Integer> future=forkJoinPool.submit(new SumTask(ints,0,ints.length));
        System.out.println(future.get());
        forkJoinPool.shutdown();
    }
}
