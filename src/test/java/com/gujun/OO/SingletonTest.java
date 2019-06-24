package com.gujun.OO;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/6/24 13:35
 * @Version 1.0
 **/
public class SingletonTest {

    //单例类 参考：https://www.cnblogs.com/zhaoyan001/p/6365064.html
    //单例模式在多线程的应用场合下必须小心使用。如果当唯一实例尚未创建时，有两个线程同时调用创建方法，
    // 那么它们同时没有检测到唯一实例的存在，从而同时各自创建了一个实例，这样就有两个实例被构造出来，从而违反了单例模式中实例唯一的原则

    //懒汉模式，延迟创建实例；
    //硬汉模式，类一加载实例就创建了；（有线程安全问题，可以用synchronized 修饰静态方法，不过效率低了）

}
