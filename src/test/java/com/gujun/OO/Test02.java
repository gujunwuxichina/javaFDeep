package com.gujun.OO;

import org.junit.Test;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/6/24 9:53
 * @Version 1.0
 **/
public class Test02 {

    //包装类
    //8种基本类型分别定义了相应的引用类型；（int->Integer,char->Character,其他都是首字母大写）；
    //包装类实现了基本类型和字符串之间的转换；两种方式：
    //1.利用包装类提供的parseXXX(..)静态方法（除了Character其他包装类都由该方法）；
    //2.利用包装类的构造器XXX(String)；
    //String类提供了多个重载的valueOf()，用于将基本类型转化为字符串；
    //把基本类型转化为字符串，最简便的方法就是+"";
    //虽然包装类型变量是引用类型，但是其实例可以直接和数值类型的值进行比较，这种比较是直接取出包装实例的值进行比较；
    //两个包装类实例进行比较就有些复杂，因为是引用类型必须指向同一对象才会相等；
    @Test
    public void test01(){

        Integer i1=new Integer("10");
        Integer i2=new Integer("10");
        System.out.println(i1==i2); //false

        Integer i3=10;
        Integer i4=10;
        System.out.println(i3==i4); //true

        Integer i5=-128;
        Integer i6=-128;
        System.out.println(i5==i6); //true,补码负数多一个

        //下面是false,因为Integer源码中将-128到127的数自动装箱成Integer实例并放入一个数组中缓存；超出该范围就是创建一个新实例；
        Integer i7=128;
        Integer i8=128;
        System.out.println(i7==i8); //false,超出-128 127的范围；

        //所有的包装类都由静态方法compare(v1,v2),可以比较基本类型的大小，v1>v2返回true;

        //无符号运算的方法；HH

    }

    //==和equal
    //==对于基本类型数值，只要值相等，不一定必须类型相同，就相等；
    //==对于引用类型必须指向同一对象；
    @Test
    public void test02(){
        int i=22;
        float f=22.0f;
        System.out.println(i==f);   //true
        char c='A';
        System.out.println(c==65);  //true
    }
    //"hello"和new String("hello")的区别：
    //使用"hello"，JVM会使用常量池来管理这些字符串；new String("hello")，JVM会先使用常量池来管理，再在堆内存中创建一个String对象，即new String("hello")一共产生两个String对象；
    //常量池是专门用于管理编译阶段被确定保存在class文件中的一些数据，包括类、方法、接口中的常量，还包括字符串常量；
    @Test
    public void test03(){
        String s1="gujun";
        String s2="gu";
        String s3="jun";
        System.out.println(s1=="gu"+"jun"); //true
        System.out.println(s1==s2+s3);  //false
        System.out.println(s1==new String("gujun")); //false
    }
    //equals(),来自Object的实例方法，和==没有区别（即没有重写过），String的equals()重写了，当字符序列相同就返回true;
    //重写equals()方法简单模板，见Person类；
}
