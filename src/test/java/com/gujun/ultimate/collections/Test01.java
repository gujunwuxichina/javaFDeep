package com.gujun.ultimate.collections;

import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

/**
 * @ClassName: Test01
 * @Author GuJun
 * @Description:
 * @Date 2021年07月24日 8:48
 */
public class Test01 {

    private Collection<String> collection=new HashSet<>();
    {
        collection.add("java");
        collection.add("javascript");
        collection.add("python");
        collection.add("golang");
    }

    //  集合和数组不一样，数组元素可以是基本类型或对象；集合里只能是对象；其实是对象的引用；

    //  Collection接口，是List，Set，Queue的父接口；很多方法能用；

    //  Lambda遍历集合
    //  Iterable接口新增了forEach(Consumer)默认方法；
    //  Iterable是Collection的父接口；
    //  Consumer是一个函数式接口；
    //  当调用forEach()时，会依次把集合元素传递给Consumer的accept()；

    //  Iterator,是Java集合框架的成员；用于遍历集合元素，即迭代器；
    //  Iterator隐藏了各种Collection实现类的底层细节，提供了遍历集合的统一接口；
    //  next(),hasNext(),remove()删除集合里上一个next()返回的元素；
    //  forEachRemaining(Consumer),可以是Lambda遍历；

    //  Predicate操作集合,Collection有个removeIf(Predicate),将会删除复核条件的元素，Predicate是个函数式接口；
    @Test
    public void test01(){
        collection.removeIf(s ->
           s.equals("golang")
        );
        System.out.println(collection);
    }

    //  Stream
    //  Stream提供了大量的聚集方法:
    //  中间方法，允许流保持打开状态，可以接着调用后续方法；
    //  filter(Predicate)过滤不符合的元素；mapToXXX(ToXXXFunction)；
    //  peek(Consumer)对每个元素进行一些操作，返回的流与之前的含有相同的元素；
    //  distinct(),去重，依据equals()；sorted();limit(long)保证后续对流的操作中允许访问的最大个数；
    //  末端方法，最终操作；
    //  forEach(Consumer),toArray,min(),max(),count();
    //  anyMatch(Predicate)判断是否至少一个元素复核；allMatch(),noneMatch();findFirst(),findAny()返回任意一个;
    //  有状态方法，会给流增加一些新属性；
    //  短路方法，会尽早结束对流的操作，不必检查所有元素；

    @Test
    public void test02(){
        collection.forEach(c->{
            System.out.println(c);
            if(c.equals("python")){
                return;
            }
        });
    }

}
