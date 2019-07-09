package com.gujun.collectionTest.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/7/9 20:12
 * @Version 1.0
 **/
public class Test01 {

    //List是有序集合，在Collection接口的基础上增加了一些根据索引来操作集合元素的方法：
    //void add(index,obj);boolean addAll(index,collection)；
    //remove(index)，删除并返回在index索引处的元素；
    //set(index,obj)，将index索引处的元素替换成obj,并返回内替换的元素；
    @Test
    public void test01(){
        List<String> list=new ArrayList<>();
        list.add(new String("gj"));
        list.add(new String("wx"));
        //List判断两个对象相等只需equal()返回true即可；
        System.out.println(list.indexOf(new String("gj")));
    }

    //sort(comparator)，根据参数对象集合元素排序；
    //replaceAll(UnaryOperator)，根据参数指定的规则重写设置集合的全部元素；
    @Test
    public void test02(){
        List<String> list=new ArrayList<>();
        list.add(new String("gj"));
        list.add(new String("wuxi"));
        System.out.println(list);
        list.sort((s1,s2)->{
            return s2.length()-s1.length();
        });
        System.out.println(list);
        list.replaceAll((s)->{
           return String.valueOf(s.length());
        });
        System.out.println(list);
    }

    //与Set只提供了iterator()不同，List还提供了listIterator()返回一个ListIterator对象，在Iterator的基础上，增加了如下方法：
    //hasPrevious()，previous()，add(obj)；
    //可以看出ListIterator增加了向前迭代和添加元素的功能；
    @Test
    public void test03(){
        String[] strings={"gj","wuxi","java"};
        List<String> list=new ArrayList<>();
        for(int i=0,j=strings.length;i<j;i++){
            list.add(strings[i]);
        }
        System.out.println(list);
        ListIterator<String> listIterator=list.listIterator();
        while (listIterator.hasNext()){
            System.out.println(listIterator.next());
            listIterator.add("----------------------------");
        }
        System.out.println("==========================================");
        while (listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }
    }


}
