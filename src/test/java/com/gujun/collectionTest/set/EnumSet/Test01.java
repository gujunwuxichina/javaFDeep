package com.gujun.collectionTest.set.EnumSet;

import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/7/9 15:27
 * @Version 1.0
 **/
public class Test01 {

    //EnumSet是一个专为枚举类设计的集合类，集合中的所有元素必须是枚举类型的枚举值，该枚举类型在创建EnumSet时显示或隐式指定；
    //集合中的元素也是有序的，以枚举类中定义的顺序来决定集合中元素的顺序；
    //EnumSet内部是以位向量，该存储方式非常紧凑、高效，因此EnumSet对象占用的内存很小、运行效率好，尤其在进行批量操作；
    //EnumSet不允许添加null，否则会报错；
    //EnumSet没有暴露任何构造器用来创建对象，只能通过类方法来创建：
    //allOf(Class enum)，创建一个包含指定枚举类所有枚举值的实例；
    //complementOf(enumSet)，创建一个元素类型和enumSet类型相同的对象，新的对象包含enumSet中不包含，该枚举类剩下的枚举值；
    //copyOf(collection/enumSet）,通过普通集合/创建一个指定EnumSet相同类型、相同元素的对象；
    //noneOf(Class enum)，创建一个元素类型为指定类型的空对象；
    //of(E e1,E e2....)，创建一个包含一个或多个枚举值的对象，所有枚举值必须是同一类型；
    //range(E from,E to)，创建一个包含从form到to枚举值的对象；
    @Test
    public void test01(){
        Collection<Season> seasons=new HashSet<>();
        Collections.addAll(seasons,Season.SPRING,Season.SUMMER,Season.FALL,Season.WINTER);
        System.out.println(seasons);    //顺序与枚举类中定义的相反；
        EnumSet<Season> enumSet1=EnumSet.copyOf(seasons);
        System.out.println(enumSet1);
        EnumSet<Season> enumSet2=EnumSet.allOf(Season.class);
        System.out.println(enumSet2);
    }

}
