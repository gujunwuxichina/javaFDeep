package com.gujun.ultimate.oo;

/**
 * @ClassName: Test7Enum
 * @Author GuJun
 * @Description:
 * @Date 2021年07月19日 20:37
 */
public class Test7GC {

    //  对象与垃圾回收
    //  当程序创建对象、数组等引用类型时，会在堆内存中分配一块内存，当该块内存不再被引用变量引用时，就会变成垃圾等待垃圾回收；
    //  1.垃圾回收机制只负责回收堆内存中的，不会回收任何物理资源；
    //  2.程序无法控制垃圾回收的运行，只会在合适的时候运行；当对象永远的失去引用后，系统就会在合适时候回收它；
    //  3.在回收之前，总会先调用finalize(),该方法可以使用对象重新获取新的引用，从而导致垃圾回收取消；

    //  对象在内存的状态，根据引用变量引用的状态，分下三种：
    //  1.可达状态，有一个以上的变量引用它；
    //  2.可恢复状态，不再有变量引用，finalize()执行之前；
    //  3.finalize()之后；

    //  强制回收
    //  System.gc()/Runtime.getRuntime().gc();

    //  finalize()
    //  见原


}
