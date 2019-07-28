package com.gujun.genericity;

import java.util.Collection;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/7/28 7:28
 * @Version 1.0
 **/
public class Test03 {

    //设定通配符下限
    //有这么一个需求，实现将集合src的元素复制到dest集合里，并返回最后一个被复制的元素；
    //<? super T>表示它必须是T本身或其父类；

    public static <T> T copy(Collection<? super T> dest,Collection<T> src){
        T last=null;
        for(T t:src){
            last=t;
            dest.add(t);
        }
        return last;
    }

    //泛型和数组
    //Java泛型的一个重要原则：如果一段代码在编译时没有出现未经检查的转换警告，则程序在运行时不会引发ClassCastException；
    //所以数组元素的类型不能包含类型变量或类型形参，
    //HH

}
