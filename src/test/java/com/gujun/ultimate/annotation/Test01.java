package com.gujun.ultimate.annotation;

/**
 * @ClassName: Test01
 * @Author GuJun
 * @Description:
 * @Date 2021年07月31日 9:02
 */
public class Test01 {

    //  Annotation能被用来为程序元素（类，方法，成员变量）设置元数据；
    //  基本Annotation
    //  @Override @Deprecated
    //  @SuppressWarnings,抑制编译器警告，表明被修饰的元素（元素中的所有子元素），取消显示指定的编译器警告；@SupressWarnings(value="unchecked")
    //  @SafeVarargs,堆污染；H
    //  @FunctionalInterface,函数式接口；

    //  元Annotation
    //  @Retention
    //  只能用于修饰Annotation定义，指定其可以保留多次时间；value的三个值：
    //  1.RetentionPolicy.CLASS,编译器把Annotation记录在class文件中，当运行时，JVM不可获取Annotation信息，默认值；
    //  2.RetentionPolicy.RUNTIME,编译器把Annotation记录在class文件中，当运行时，JVM可以通过反射获取Annotation信息；
    //  3.RetentionPolicy.SOURCE,Annotation信息只保留在源码中，编译器丢弃该Annotation；
    //  @Target
    //  也是修饰Annotation，用于指定该Annotation可以修饰哪些程序单元；
    //  value的值:ElementType.xxx...
    //  @Document
    //  用于指定修饰的Annotation类将被javadoc工具提取成文档；
    //  @Inherited
    //  指定被其修饰的Annotation将具有继承性；

    //  自定义Annotation
    //  使用@interface关键字，public @interface AnnotationName{}
    //  还可以带有成员变量，以无参的方法形式来呈现；即value=key;
    //  也可以指定默认值；
    public @interface Test{
        String name() default "gujun";
    }

    //  提取Annotation信息
    //  Annotation接口代表元素前面的注解，是所有注解的父接口；
    //  AnnotationElement接口，表示程序中可以接受注解的元素；Class,Constructor,Field,Method,Package的父接口;
    //  可以通过反射获取AnnotationElement对象，通过一些方法获取Annotation信息；
    //  

}
