package com.gujun.collectionTest.Queue;

import org.junit.Test;

import java.util.*;


/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/7/11 9:32
 * @Version 1.0
 **/
public class Test01 {

    //Queue用于模拟队列数据结构（先进先出）；
    //方法：
    //add(obj),boolean offer(obj)将元素添加到尾部，当使用有容量限制的队列时，该方法比add()好；？
    //element()获取头部元素，不删除；
    //remove()获取头部元素，并删除；
    //peek()获取头部元素，不删除，若队列为空则返回null;
    //poll()获取头部元素，并删除，若队列为空则返回null;

    //PriorityQueue实现类，保存队列元素时，不是按添加顺序，而是按元素的大小进行重新排序；
    //这么看来PriorityQueue已经违反了队列先进先出的规则；
    //PriorityQueue不允许插入null,需要对元素进行排序，两种排序自然和定制（参考TreeSet）

    @Test
    public void test01(){
        Queue<String> queue=new PriorityQueue<>((s1, s2)->{  //定制排序，传入lambda表达式的Comparator实现类实例；也可以采用自然排序下，String类实现了Comparable接口；
            return  s1.length()-s2.length();
        });
        List<String> list= Arrays.asList("javascript","gujun","gj","java");
        System.out.println(list);   //[javascript, gujun, gj, java]
        queue.addAll(list);
        System.out.println(queue);//[gj, java, gujun, javascript]
    }

    //Deque接口和ArrayDeque实现类
    //Deque接口是Queue接口的子接口，代表一个双端队列，允许从两端来操作队列的元素；
    //方法：
    //addFirst(obj)/addLast(obj);getFirst()/getLast()获取但不删除；boolean offerFirst(obj)/offerLast(obj);
    //peekFirst/peekLast()获取不删除，若队列为空返回null;pollFirst/pollLast()获取并删除，若队列为空返回null;
    //栈方法，pop()获取并删除栈顶元素；push(obj),将一个元素放入栈顶；
    //removeFirst()获取并删除第一个元素（相当于pop()）;reomveLast()获取并删除最后一个元素；
    //removeFirstOccurrence(obj),获取并删除队列中第一次出现的obj元素；removeLastOccurrence(obj)获取并删除队列中最后一次出现的obj元素；
    //Iterator descendingIterator(),返回该双端队列对于的迭代器，该迭代器将以逆向顺序迭代队列中的元素；
    //ArrayDeque实现类，是基于数组实现的；创建时可以指定int参数来指定数组长度，若不指定则默认为16；
    @Test
    public void test02(){
        Deque<String> deque=new ArrayDeque<>(3);
        deque.offerFirst("gj");
        deque.offerFirst("java");
        deque.offerFirst("javascript");
        System.out.println(deque);
        Iterator<String> iterator=deque.descendingIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //LinkedList实现类，是List接口实现类，可以根据索引来随机访问；
    //还实现了Deque接口，可以被当成双端队列使用；
    //LinkedList内部是以链表形式来保存集合的元素的,内部链表实现的集合遍历用Iterator迭代好,因此在随机访问上性能较差，但在插入删除上出色（因为只需改变指针所指地址即可）；

    //所有内部是基于数组实现的集合，遍历时随机访问要比Iterator迭代性能好，因为随机访问被映射成对数组元素的访问；


}
