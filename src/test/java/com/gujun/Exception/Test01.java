package com.gujun.Exception;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/7/28 7:59
 * @Version 1.0
 **/
public class Test01 {

    //Java异常概述：
    //如果在执行try里的代码出现异常，系统会自动生成一个异常对象，
    //该异常对象被提交给Java运行环境，该过程被称为抛出异常；
    //当Java运行环境收到异常对象后，会寻找能处理该异常对象的catch块，
    //若找到则交由该catch块处理，该过程被称为捕获异常；
    //若Java运行环境找不到捕获异常的catch块，则运行环境终止，Java程序也将退出；
    //catch块中的代码也可以产生异常对象；
    //当异常对象是catch后面的异常类或其子类的实例时，才会交由该catch块处理；
    //当进入对应的catch中，系统会将生成的异常对象传给catch的异常形参；

    //异常类的继承体系：
    //分为Exception和Error，都继承自Throwable；
    //Error一般指与虚拟机相关的问题，这类错误无法恢复、不能捕获，程序无法处理这些；

    //Java7的多异常捕获：
    //1.多种异常类型之间用|隔开；
    //2.异常变量有隐式final修饰；

    //访问异常信息：
    //getMessage()，返回异常的字符串描述；
    //printStackTrace([PrintStream s])，将异常的跟踪栈信息输出或到指定输出流；
    //getStackTrace()返回改异常的跟踪栈信息；

    //finally回收资源；
    //Java7的自动关闭资源的try语句：
    //为了保证try可以关闭资源，这些资源必须实现AutoCloseable或Closeable接口；
    //如：try(资源){}；
    //自动关闭的try语句相当于隐式的finally；

}
