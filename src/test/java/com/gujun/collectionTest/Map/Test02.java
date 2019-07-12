package com.gujun.collectionTest.Map;

import org.junit.Test;

import java.util.TreeMap;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/7/12 17:11
 * @Version 1.0
 **/
public class Test02 {

    //SortedMap接口和TreeMap实现类；（类比Set的）
    //TreeMap就是一个红黑树数据结构，每个key-value就是一个节点，存储节点时需要根据key节点进行排序；
    //两种排序：自然和定制，参考TreeSet;
    //方法：H
    @Test
    public void test01(){
        TreeMap<String,String> treeMap=new TreeMap<>((s1,s2)->{ //定制排序
           return  s1.length()-s2.length();
        });
        treeMap.put("name","gj");
        treeMap.put("job","it");
        treeMap.put("hobby","tv");
        treeMap.put("country","china");
        System.out.println(treeMap);
    }

    //WeakHashMap实现类
    //用法和HashMap基本相似；
    //区别：HashMap的key保留了对实际对象的强引用，这意味着只要该HashMap对象不被销毁，key所引用的对象就不会被销毁，HashMap不会自动删除这些key所有的对象；
    //而WeakHashMap的key只保留对象的弱引用，则key所引用的对象可能会被垃圾回收掉，WeakHashMap也可能自动删除这样key所引用的对象；
    //当垃圾回收key所引用的对象，WeakHashMap会自动删除key对应的key-value对；

}
