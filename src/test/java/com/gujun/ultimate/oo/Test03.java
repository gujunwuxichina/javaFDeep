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
    //  final局部变量，

}
