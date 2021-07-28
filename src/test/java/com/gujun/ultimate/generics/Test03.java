package com.gujun.ultimate.generics;

import java.util.Collection;

/**
 * @ClassName: Test03
 * @Author GuJun
 * @Description:
 * @Date 2021年07月28日 21:38
 */
public class Test03 {

    //  泛型方法
    //  在声明方法时定义一个或多个形参：
    private <T> void ArrayToCollection(T[] array, Collection<T> collection){
        for(T t:array){
            collection.add(t);
        }
    }
    private <T> void transfer(Collection<? extends T> from,Collection<T> to){
        from.forEach(t->{
            to.add(t);
        });
    }

    //  泛型方法和类型通配符的区别
    //  大多数都可以使用泛型方法来代替通配符
    public interface Collection1<E>{
        boolean containsAll(Collection<?> c);
        boolean addAll(Collection<? extends E> c);
    }
    public interface Collection2<E>{
        <T> boolean containsAll(Collection<T> c);
        <T extends E> boolean addAll(Collection<T> c);
    }

}
