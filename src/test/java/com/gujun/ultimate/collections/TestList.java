package com.gujun.ultimate.collections;

/**
 * @ClassName: TestList
 * @Author GuJun
 * @Description:
 * @Date 2021年07月25日 9:40
 */
public class TestList {

    //  List代表一个元素有序，可重复的集合，每个元素都有对应的顺序索引；默认顺序是元素添加的顺序；
    //  判断两个元素相等，只需equals()返回true即可；
    //  List提供了listIterator()返回ListIterator对象;

    //  ArrayList，Vector
    //  都是基于数组实现的，封装了一个动态的，允许再分配的数组；
    //  使用initialCapacity参数来设置数组的长度，当元素数量超过了数组长度，initialCapacity会自动增加；
    //  若在开始就知道集合元素的个数，可以在创建时指定initialCapacity，若不指定默认为10；
    //  ensureCapacity(int),使数组长度大于或等于int;
    //  trimToSize(),数组长度等于元素个数，会使集合占用内存空间减少；
    //  ArrayList线程不安全的，Vector线程安全的；
    //  固定长度的List
    //  Arrays.asList()转换的List是Arrays的内部类ArrayList；
    //  Arrays.ArrayList是一个固定长度的List集合，只能遍历，不能增加，删除；

}
