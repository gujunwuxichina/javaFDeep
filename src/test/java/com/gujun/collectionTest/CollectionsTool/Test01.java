package com.gujun.collectionTest.CollectionsTool;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/7/14 7:28
 * @Version 1.0
 **/
public class Test01 {

    //操作Set、List、Map的工具类；
    //排序操作：
    //reverse(list),反转；shuffle(list)，洗牌；
    //sort(list),根据元素的自然顺序排序；sort(list,comparator)定制排序；
    //swap(list,int i,int j)将i处和j处元素交换；
    //rotate(list,int i)，i为正数时，将后i个元素移到前面，i为负数时将前i个元素移到后面；
    @Test
    public void test01(){
        List<String> list=new ArrayList<>();
        list.add("java");
        list.add("gj");
        list.add("wuxi");
        list.add("javascript");
        System.out.println(list);
        Collections.sort(list,(s1,s2)->{
            return  s1.length()-s2.length();
        });
        System.out.println(list);
    }

    //查找、替换操作
    //int binarySearch(list,key),使用二分搜索法搜索list集合，获取指定对象在集合中的索引；必须先保证list中的元素处于有序状态；
    //max(collecion)，根据元素自然顺序，返回指定集合中最大元素；
    //max(collection,comparator)定制排序；
    //min两个方法类上；
    //fill(list,obj)，使用指定元素obj，替换集合中所有元素；
    //frequency（collection,obj)返回指定集合中指定元素出现的次数；
    //indexOfSubList(list,sublist)/lastIndexOfSubList(list,sublist);
    //boolean replaceAll(list,oldVal,newVal)，使用一个新值替换list中的所有旧值；

    //同步控制
    //Collections提供了多个synchronizedXXX()，来将指定集合包装成线程同步的集合；

    //设置不可变集合
    //emptyXXX()返回一个空的、不可变的集合对象；
    //singletonXXX()，返回一个只包含指定对象的、不可变的集合对象；
    //unmodifiableXXX()，返回指定集合不可变视图；
    @Test
    public void test02(){
        List<String> list=new ArrayList<>();
        list.add("java");
        list.add("gj");
        list.add("wuxi");
        list=Collections.unmodifiableList(list);
        list.add("test");  //不可变集合，不能改变，此处报错
    }

}
