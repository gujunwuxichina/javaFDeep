package com.gujun.collectionTest.set;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/7/9 16:17
 * @Version 1.0
 **/
public class AllSets {

    //各Set实现类性能分析；
    //HashSet性能总是比TreeSet好，特别是在添加、查询元素时；
    //只要需要保证指定顺序下才使用TreeSet,否则应该使用HashSet；
    //HashSet的子类LinkedHashSet,对于插入、删除操作比HashSet性能低，这是因为链表维护带来的性能开销，也正是如此在遍历上会更快；
    //EnumSet是Set实现类中最好的，但只能保存同一个枚举类的枚举值；

    //三个实现类HashSet、TreeSet、EnumSet都是线程不安全的，必须手动保证其线程安全；
    //可以通过Collections的方法来包装Set;(后有)

}
