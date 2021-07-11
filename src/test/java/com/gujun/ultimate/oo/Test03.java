package com.gujun.ultimate.oo;

import org.junit.Test;

/**
 * @ClassName: Test03
 * @Author GuJun
 * @Description:
 * @Date 2021年06月30日 10:09
 */
public class Test03 {

    //  包装类
    //  Integer里定义了一个长度256的Integer[],把-128~127的整数缓存了；
    //  new Integer(xx)返回新的实例，valueOf()会缓存创建的对象；
    @Test
    public void test01(){
        Integer i1=128;
        Integer i2=128;
        System.out.println(i1.compareTo(i2));   // 0
        System.out.println(i1==i2); // false
        System.out.println(i1.equals(i2));  // true
        Integer i3=Integer.valueOf(127);
        Integer i4=Integer.valueOf(127);
        System.out.println(i3==i4); // true
        Integer i5=new Integer(127);
        Integer i6=new Integer(127);
        System.out.println(i5==i6); // false
    }

    //  常量池
    //  专门用于管理在编译阶段被确定并保存在已编译的class文件中的一些数据，包括类、方法、接口中的常量；
    //  常量池保证相同的字符串直接量只有一个；
    //  对于new String("xxx"),JVM会先使用常量池来管理xxx直接量，在调用String构造器创建一个String对象，该对象在堆内存；

    //  类成员
    //  类成员属于类，当第一次使用某个类时，系统会为类变量分配内存空间，直到该类被卸载，类变量所占用的内存才会被垃圾回收器回收；

    //  final修饰符
    //  可以修饰类、变量、方法；
    //  final成员变量，final修饰的成员变量必须由程序员显示初始化，系统不会对其初始化；可以在声明时、代码块、构造器里初始化；
    //  final局部变量，因为系统不会对局部变量进行初始化，局部变量必须由程序员显示初始化，因此使用final修饰局部变量时，即可以在声明时指定默认值或在后面指定默认值/也可以不指定；
    //  可执行宏替换的final变量：
    //  对于final修饰的成员变量、局部变量，满足三个条件就是直接量：
    //  1.final修饰；2.定义时就指定了初始值；3.初始值可以在编译阶段确定；
    //  final方法：
    //  final修饰的方法不可以被重写；但可以被重载；
    //  final类：
    //  final修饰的类不可以有子类；

    //  不可变类：
    //  不可变类就是创建该类实例后，该实例的实例变量不可改变；
    //  定义不可变类原则：
    //  1.使用private,final修饰类的成员变量；
    //  2.提供带参数的构造器，来初始化成员变量；
    //  3.提供getter()，不通过setter();
    //  4.重写hashCode(),equals(),两者保持一致；

}
