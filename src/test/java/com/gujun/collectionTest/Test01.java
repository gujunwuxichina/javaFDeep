package com.gujun.collectionTest;

import org.junit.Test;

import java.util.Collection;
import java.util.HashSet;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/7/4 20:07
 * @Version 1.0
 **/
public class Test01 {

    //Java集合概述
    //集合类是一种特别有用的工具类，一种容器，可以存放多个对象，实际上是对象的引用；
    //编程时常常需要集中存放多个数据，可以用数组，但是长度不可变化，此外数组也无法保存具有映射关系的数据；
    //Java的集合类主要由两个根接口派生而来；

    //Collection接口和Iterator接口：
    //Collection接口是List、Set、Queue接口的父接口，所以Collection接口里的方法List、Set、Queue都可以用；
    //boolean add(obj)，boolean add(collection),clear()，contains(obj),containsAll(collection)，isEmpty()；
    //boolean remove(obj),当集合中包含多个obj时，删除第一个；removeAll(collection)；
    //retainAll(collecion c)，从集合中删除集合C中不包含的原始，即求交集，若该方法改变了调用该方法的集合，则返回true;
    //toArray()，将集合转为数组；iterator()，返回一个Iterator对象，用于遍历集合；

    //便利集合元素的方法：
    //1.使用Lambda遍历:
    //JDK8为Iterable接口新增了一个forEach(Consumer)，该方法参数类型是一个函数式接口，又Iterable接口是Collection接口的父接口；
    //当调用forEach()时，会依次将集合元素传给Consumer的accept(t)；
    @Test
    public void test01(){
        Collection<String> collection=new HashSet<>();
        collection.add("gj");
        collection.add("wx");
        collection.forEach(s-> System.out.println(s));
    }


}
