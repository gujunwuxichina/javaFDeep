package com.gujun.OO;

import org.junit.Test;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/6/24 16:22
 * @Version 1.0
 **/
public class ImmutableTest {

    //不可变类
    //不可变类就是创建该类的实例后，其实例变量不可以改变；8个包装类和String都是不可变类；
    //创建自定义不可变类规则：
    //1.使用private final 修饰该类的成员变量（非静态）；
    //2.提供带参数构造器来初始化成员变量；
    //3.为成员变量仅提供getter方法；
    //4.重写equals()和hashCode()，保证两者同时相等；
    //如果成员变量是引用类型，该变量虽然不能被重新赋值，但是其引用的对象是可以改变的；此时创建的不可变类是失败的；
    //对此必须让程序无法访问到其引用类型的变量，也就无法通过改变该变量引用的对象来改变原本的不可变类的对象了；见People类；

    //缓存实例的不可变类
    //不可变类的实例变量不可改变，可以被多个对象所共享；如果程序经常使用相同的不可变类实例，则应该缓存该实例；
    @Test
    public void test01(){
        CacheImmutable cacheImmutable1=CacheImmutable.valueOf("gujun");
        CacheImmutable cacheImmutable2=CacheImmutable.valueOf("gujun");
        System.out.println(cacheImmutable1==cacheImmutable2);   //true
        CacheImmutable cacheImmutable3=new CacheImmutable("gujun");
        System.out.println(cacheImmutable1==cacheImmutable3);   //false
    }


}
