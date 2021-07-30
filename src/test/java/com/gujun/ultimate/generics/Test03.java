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

    //  泛型构造器
    //  如泛型方法允许在方法签名中声明类型形参一样，java也允许在构造器签名中声明类型形参，即泛型构造器；
    //  在调用构造器时，可以让程序根据实参来推断类型形参，也可以显示地为构造器指定类型形参；
    //  new <String> T("xx"),new T("xx");

    //  设定通配符下限
    //  <? super T>,表示必须是T本身或其父类；

    //  泛型和数组
    //  H

}
