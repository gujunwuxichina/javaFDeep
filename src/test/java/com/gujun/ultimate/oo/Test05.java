package com.gujun.ultimate.oo;

/**
 * @ClassName: Test05
 * @Author GuJun
 * @Description:
 * @Date 2021年07月11日 12:54
 */
public class Test05 {

    //  内部类
    //  对于内部类，编译后会生成两个class文件，Outer.class和Outer$Inner.class;

    //  非静态内部类
    //  非静态内部类里访问外部类的private成员，这是因为在非静态内部类对象里保存了一个其外部类的对象的引用；
    //  非静态内部类里不允许定义静态成员：静态方法、静态变量、静态代码块；

    //  静态内部类
    //  属于外部类本身，而不是外部类对象；
    //  静态内部类可以包含静态成员、也可以包含非静态成员；
    //  静态内部类不可以访问外部类的实例成员（即使静态内部类的实例方法里），但可以方法外部类的静态成员；
    //  由于静态内部类属于外部类的类，所以外部类的所有方法、初始化块可以使用静态内部类；
    //  接口里也可以定义内部类，默认使用public static修饰；

    //  使用内部类
    //  在外部类以外使用内部类
    //  OutClass.InnerClass name
    //  非静态内部类  =outerInstance.new InnerClass();
    //  静态内部类   =new OutClass.InnerClass();

    //  局部内部类
    //  如果把一个内部类放在方法里定义，就是局部内部类，仅在方法里有效
    //  很少用到

    //  匿名内部类
    //  适合创建那种只需要一次使用的类；
    //  创建匿名内部类实例时会立即创建一个实例，然后该类定义消失；
    //  new 接口()/类（xx){..}
    //  匿名内部类不能有构造器，当可以有初始化块；
    //  匿名内部类访问的局部变量默认final修饰；

}
