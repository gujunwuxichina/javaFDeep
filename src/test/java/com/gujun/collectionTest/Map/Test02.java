package com.gujun.collectionTest.Map;

import com.gujun.collectionTest.set.EnumSet.Season;
import org.junit.Test;

import java.util.EnumMap;
import java.util.IdentityHashMap;
import java.util.Map;
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

    //IdentityHashMap实现类
    //与HashMap基本相似；但在处理key相等时不同，IdentitHashMap仅当key严格相等时才相等；也允许null作为key;
    //不保证key-value对顺序；
    @Test
    public void test02(){
        Map<String,String> map=new IdentityHashMap<>();
        map.put(new String("javascript"),"80");
        map.put(new String("javascript"),"100");
        map.put("java","60");
        map.put("java","70");
        System.out.println(map);
    }

    //EnumMap实现类；
    //EnumMap中所有key都必须是单个枚举类的枚举值；
    //创建EnumMap时必须显示或隐式指定对应的枚举类；
    //不允许null作为key，但null可以作为value;
    @Test
    public void test03(){
        Map<Season,String> map=new EnumMap<>(Season.class);
        map.put(Season.SPRING,"春天");
        map.put(Season.SUMMER,"夏天");
        System.out.println(map);
    }
}

