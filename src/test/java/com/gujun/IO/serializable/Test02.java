package com.gujun.IO.serializable;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/8/11 9:03
 * @Version 1.0
 **/
public class Test02 {

    //自定义序列化：
    //正常序列化时，系统会对所有实例变量依次序列化，若实例变量引用到一个对象，也会对该对象进行序列化，以此类推；
    //可以在实例变量前加transient修饰符，指定序列化时无需理会该成员；
    //此外，Java提供自定义序列化机制，通过该机制可以控制程序如何序列化实例变量，也可以不序列化实例变量；
    //HHH

}
