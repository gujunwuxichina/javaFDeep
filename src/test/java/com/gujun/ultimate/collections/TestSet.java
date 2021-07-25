package com.gujun.ultimate.collections;

/**
 * @ClassName: TestSet
 * @Author GuJun
 * @Description:
 * @Date 2021年07月24日 20:26
 */
public class TestSet {

    //  不允许包含相同的元素；

    //  HashSet
    //  按hash算法来存储集合中的元素；
    //  不能保证元素的顺序；不是同步的；元素可以是null;
    //  当向HashSet中存入一个元素时，会调用该对象的hashCode()来得到hashCode值，根据该值来决定其在HashSet中的存储位置；
    //  若两个对象的equals()返回true,但hashCode值不同，依然会存储成功；
    //  HashSet判断元素相等标准是equals()相等，且hashCode()也相等；

    //  LinkedHashSet
    //  HashSet的子类，也是根据hashCode值来决定存储位置的，同时使用链表维护元素顺序，即顺序是按照插入顺序；
    //  因为需要维护元素的插入顺序，性能略低于HashSet,但在迭代访问有很好的性能，因为以链表维护顺序；

    //  TreeSet
    //  SortedSet接口的实现类，可以确保集合里元素处于有序状态；
    //  TreeSet采用红黑树的数据结构来存储集合元素；
    //  自然排序：
    //  会调用元素的compareTo(obj)来比较元素大小关系，然后将元素按升序排序；
    //  Comparable接口里的compareTo(obj)；一些常用类都实现了该接口；
    //  对此，判断两个对象相等依据是，两个对象通过compareTo()是否返回0,若相等则新对象无法添加；
    //  compareTo()应与equals()保持一致；
    //  定制排序：
    //  通过Comparator接口，是函数式接口，该接口包含一个int compare(o1,o2);
    //  在创建TreeSet时，传入一个Comparator对象，由其负责元素排序；

    //  EnumSet
    //  其中的所有元素必须是指定枚举类的枚举值；
    //  枚举类型在创建EnumSet显示或隐式指定，元素顺序是枚举类中定义的顺序；
    //  EnumSet内部以位向量的形式存储，非常紧凑高效；
    //  不允许包含null;

    //  各Set实现类的性能分析
    //  HashSet和TreeSet,HashSet性能好，当需要排序时使用TreeSet;
    //  EnumSet是性能最好的；

}



