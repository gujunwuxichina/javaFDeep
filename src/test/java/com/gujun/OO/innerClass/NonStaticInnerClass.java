package com.gujun.OO.innerClass;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/6/26 20:40
 * @Version 1.0
 **/
public class NonStaticInnerClass {

    //非静态内部类
    //非静态内部类里可以直接访问其外部类的private成员；这是因为非静态内部类对象里，保持了一个
    //他所寄生的外部类对象的引用；
    //如果外部类成员变量、内部类成员变量、内部类方法的局部变量重名，则可以通过this,外部类类名.this来作区分；
    //反过来外部类不能访问非静态内部类的成员，如果外部类要访问，则需要显示创建非静态内部类的实例来访问；
    //外部类的静态方法，静态代码块不能访问非静态内部类及其任何成员；
    //非静态内部类不能有静态成员(方法，变量，代码块)；

}
