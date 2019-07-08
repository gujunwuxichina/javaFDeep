package com.gujun.collectionTest;

import org.junit.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/7/4 20:07
 * @Version 1.0
 **/
public class Test01 {

    private static Collection<String> collection=new HashSet<>();

    static {
        collection.add("gujun");
        collection.add("wuxi");
        collection.add("java");
    }


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
        collection.forEach(s-> System.out.println(s));  //lambda写法
        collection.forEach(new Consumer<String>() { //匿名类写法
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }
    //2.使用Iterator遍历集合元素：
    //Iterator接口是Java集合框架的成员；Iterator主要用于遍历集合元素；也被称为迭代器；
    //Iterator必须依附于Collection对象，若有一个Iterator对象，必有一个与之对应的Collection对象；
    //方法：
    //hasNext()，next()，remove()删除集合上一次next()返回的元素；
    //当迭代集合元素时，集合里的元素不能改变，只能通过remove()来删除上一次next()的元素，否则会报错；
    //Iterator采用的快速失败机制，一旦在迭代过程中发现集合已经被修改过（有可能是程序其他线程修改），即立即报错；
    @Test
    public void test02(){
        Iterator<String> iterator=collection.iterator();
        String s=null;
        while (iterator.hasNext()){
            s=iterator.next();
            System.out.println(s);
            if(s.equals("java")){
                collection.remove("wuxi");//报错
            }
        }
        System.out.println(collection);
    }
    //3.Iterator的forEachRemaining(Consumer)：
    @Test
    public void test03(){
        Iterator<String> iterator=collection.iterator();
        iterator.forEachRemaining(s-> System.out.println(s));
    }
    //4.使用foreach循环遍历集合元素
    @Test
    public void test04(){
        for(String s:collection){
            System.out.println(s);
            s="444";  //与Iterator一样迭代的遍历不是集合元素，只是把集合元素的值赋给变量；遍历时也不能改变集合，不然会报错；
        }
        System.out.println(collection);
    }
    //5.Predicate操作集合
    //Predicate是函数式接口；
    //Java8为Collection新增了removeIf(Predicate）,会批量删除符合参数条件的元素；
    @Test
    public void test05(){
        collection.removeIf(s->s.length()>4);
        System.out.println(collection);
    }
    //6.Stream操作集合：
    //Collection调用stream()即可返回该集合对应的Stream;
    //调用Collection的stream()即可返回该集合对应的Stream；
    //HH


}
