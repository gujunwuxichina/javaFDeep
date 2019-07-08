package com.gujun.collectionTest.set.TreeSet;

import org.junit.Test;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/7/8 20:11
 * @Version 1.0
 **/
public class Test01 {

    //TreeSet是SortedSet接口实现类，可以确保元素处于排序状态；
    //TreeSet采用红黑树的数据结构来存储集合元素；
    //方法：
    //comparator()，如果采用了定制排序，则返回排序所使用Comparator,若是自然排序则返回null;
    //lower(obj)，返回位于指定元素之前的元素，obj可以不是TreeSet中的元素；higher(obj);

    //TreeSet支持两种排序：
    //1.自然排序：
    //TreeSet会调用集合元素的compareTo(obj)来比较元素之间的大小，然后将集合元素按升序排列；
    //此时向TreeSet中添加对象，该对象的类必须实现Comparable接口；若没有，添加第一个元素没有问题，
    // ，当从添加第二个元素开始，就会调用对象的compareTo(obj)与集合中其他元素比较，此时就会报错；
    //如果希望TreeSet运行正常，则只能添加同一类型的对象；
    //添加对象时，如果两个对象通过compareTo()相等，则新对象无法添加到TreeSet中；
    @Test
    public void test01(){
        SortedSet<Integer> sortedSet=new TreeSet<>();
        sortedSet.add(1);sortedSet.add(2);
        System.out.println(sortedSet.add(2));   //false，添加失败
    }
    //对于添加到TreeSet中的对象的类，要满足其equal()和compareTo()一致，即equal()返回true时，compareTo()返回0;
    //2.定制排序

}
