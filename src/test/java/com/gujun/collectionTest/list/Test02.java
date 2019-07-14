package com.gujun.collectionTest.list;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/7/11 9:03
 * @Version 1.0
 **/
public class Test02 {

    //ArrayList和Vector，都是List的实现类；
    //都是基于数组实现的,所以ArrayList和Vector都封装了一个动态的、允许再分配的数组；
    //两者使用initialCapacity参数来设置数组长度，当元素数量超过数组长度时，initialCapacity会自动增加；
    //可以在创建对象时指定initialCapacity大小，若不指定默认为10；
    //重新分配数组的方法：
    //ensureCapacity(initialCapacity),将数组长度增加大于或等于initialCapacity值；
    //trimToSize()，将数组长度调整为元素的个数，该方法会减少集合的存储空间；

    //ArrayList是线程不安全的；Vector是线程安全的，即便这样还是不推荐使用Vector，它是个很老的类，有很多缺点；
    //可以通过Collections工具类，将ArrayList包装成线程安全的；

    //Vector还有个子类，用于模拟栈这种数据(后进先出，从能从顶部存删数据)；（也不推荐使用该类，推荐ArrayDeque，后有）
    //peek(),返回栈顶第一个元素，不将该元素pop出栈；
    //pop(),返回栈顶第一个元素，并将该元素pop出栈；
    //push(obj),将一个元素进栈；

    //固定长度List
    //Arrays.asList(...)，该方法返回的List集合既不是ArrayList也不是Vector，而是Arrays的内部类ArrayList的实例；
    //Arrays.ArrayList是一个固定长度的List，只能遍历,底层是数组,不能增删，修改可以；
    @Test
    public void test01(){
        List<String> list= Arrays.asList("gujun","java","javascript");
        System.out.println(list instanceof ArrayList);  //false
        System.out.println(list.getClass());   // class java.util.Arrays$ArrayList
        System.out.println(list);
        Collections.swap(list,1,2);
        System.out.println(list);
        Collections.replaceAll(list,"gujun","gj");
        System.out.println(list);
    }

}
