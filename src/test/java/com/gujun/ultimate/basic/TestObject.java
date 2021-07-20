package com.gujun.ultimate.basic;

/**
 * @ClassName: TestObject
 * @Author GuJun
 * @Description:
 * @Date 2021年07月20日 20:55
 */
public class TestObject {

    //  Object类
    //  是所有类，数组，枚举类的父类；
    //  一些方法：
    //  equals(obj)，和==一样；
    //  finalize(),getClass() 返回运行时类；
    //  int hashCode(),返回对象的hashCode值；默认情况下，根据对象的地址来计算，即与System.identityHashCode(obj)一样；
    //  很多类重写了hashCode()，不再根据地址来计算；
    //  clone()，protected修饰；自定义了实现cloneable接口，标记性接口；只是一种浅克隆；

    //  Objects类
    //  提供了一些方法来操作对象，这些方法都是空指针安全的；
    //  Objects.toString(o)，若o为null，返回“null"；
    //  requireNonNull(o)，若o不为null返回o本身，若为null引发空指针异常；该方法主要用用来对方法参数进行校验；
    //  o=Objects.requireNonNull(o);

    //  String

}
