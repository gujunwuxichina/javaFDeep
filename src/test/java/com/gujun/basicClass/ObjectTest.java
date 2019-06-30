package com.gujun.basicClass;

import org.junit.Test;

import java.util.Objects;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/6/30 7:56
 * @Version 1.0
 **/
public class ObjectTest {

    //Object
    //equals(obj)，未被重写，效果和==一样；
    //finalize()，当系统中没有引用变量引用该对象时，垃圾回收器调用此方法来清理该对象的资源；
    //getClass()，返回对象的运行时类；
    //int hashCode()，返回对象的hashCode值，根据对象的内存地址来计算得出的，很多类重写该方法；
    //toString()，返回对象的字符串表示，默认为运行时类名@十六进制hashCode值；
    //clone()，用于对象的自我克隆：
    //自定义类实现了Clonealbe接口，标记性接口，接口里没有定义方法；
    //实现clone()，通过super.clone()来获取对象的副本；
    //只是简单的浅克隆，若对象的成员变量为引用类型，则需要递归克隆；
    @Test
    public void test01() throws CloneNotSupportedException {
        Person p1=new Person("gujun");
        Person p2=p1.clone();
        System.out.println(System.identityHashCode(p1));
        System.out.println(System.identityHashCode(p2));
    }

    //Ojbects
    //工具类,提供了一些方法来操作对象，大多是空指针安全的，若对象为null则返回null字符串；
    @Test
    public void test02(){
        String s=null;
        System.out.println(Objects.hashCode(s));    //0
        System.out.println(Objects.toString(s));    //"null"
        try {
            System.out.println(Objects.requireNonNull(s));  //当参数不为null，返回参数对象本身，为null则引发运行时空指针异常；
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
