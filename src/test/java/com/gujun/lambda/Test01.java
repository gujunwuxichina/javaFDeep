package com.gujun.lambda;

import org.junit.Test;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/6/29 22:00
 * @Version 1.0
 **/
public class Test01 {

    private static int[] array={1,2,3};

    //lambda表达式允许将代码块作为方法参数，允许用更简洁的代码来创建只有一个抽象方法的接口实例（函数式接口）；
    //lambda表达式相当于一个匿名方法；
    //匿名内部类方式：
    @Test
    public void test01(){
        ProcessArray pa=new ProcessArray();
        pa.process(array, new Command() {
            @Override
            public void process(int[] array) {
                System.out.println(array.length);
            }
        });
    }
    //lambda方式
    @Test
    public void test02(){
        ProcessArray pa=new ProcessArray();
        pa.process(array,(int[] array)->{
            System.out.println(array.length);
        });
    }
    //lambda由三部分组成：
    //1.形参列表，允许省略形参类型，如果只有一个形参，则连参数的括号也能省略；
    //2.代码块，如果只有一条语句可以省略{},若只有一条return语句，可以省略return关键字，返回该语句的值；

    //HHH

}
