package com.gujun.collectionTest.ThinkInJava;

import org.junit.Test;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/7/14 8:10
 * @Version 1.0
 **/
public class Test01 {

    //Collection和Iterator
    //Collectin是描述所有序列容器的共性的根接口；
    //AbstractCollection类提供了Collection接口的默认实现(Collecion基础Iterable接口的方法没有实现)；
    //C++中，类库中没有容器的公共基类，容器之间的共性是通过迭代器来实现的；
    //Java采用了Collecion和迭代器来实现容器的共性：Collection接口继承Iterable接口，Iterable接口内有iterator();
    //实现Collection
    @Test
    public void test01(){
        String[] strs={"gujun","gj","java","python","javascript"};
        Collection<String> collection=new MyCollection01<>(strs);
        for(String s:collection){
            System.out.println(s);
        }
        Iterator<String> iterator=collection.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    //生成Iterator
    @Test
    public void test02(){
        String[] strs={"gujun","gj","java","python","javascript"};
        StringIterator stringIterator=new StringIterator(strs);
        Iterator<String> iterator=stringIterator.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //Foreach与迭代器
    //Colection接口继承了Iterable接口，该接口包含iterator()，而Iterable接口被foreach用来在序列中移到；
    //因此创建的任何实现Iterable，都可以用于foreach语句；Iterable接口理由foreach()默认方法；
    //for() 类似于 foreach(consumer);
    @Test
    public void test03(){
        String[] strs={"gj","wuxi","java","javascript"};
        Iterable<String> iterable=new MyIterable<>(strs);
        iterable.forEach(s-> System.out.println(s));
        for(String s:iterable){
            System.out.println(s);
        }
    }

    //适配器方法惯用法
    //如果在现有Iterable类，想要在foreach使用中添加多种遍历方法；
    //添加一个产生Iterable的新方法；
    @Test
    public void test04(){
        String[] strs={"gj","wuxi","java","javascript"};
        ReversibleArrayList<String> reversibleArrayList=new ReversibleArrayList<>(Arrays.asList(strs));
        reversibleArrayList.forEach(s-> System.out.println(s));
        System.out.println("=====================================");
        for(String s:reversibleArrayList){
            System.out.println(s);
        }
        System.out.println("=====================================");
        for(String s:reversibleArrayList.reversedIterable()){
            System.out.println(s);
        }
    }

}
