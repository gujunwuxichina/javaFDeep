package com.gujun.Threads.ThreadAboutClass;

public class CollectionsTest {

    //包装线程不安全的集合：
    //之前的集合ArrayList,HashSet,HashMap等都是线程不安全的，即多个线程并发访问这些集合会有安全问题；
    //可以通过Collections的类方法将这些集合包装成线程安全的集合；
    //方法：
    //<T> Collection<T> synchronizedCollection(Collection<T> c),将指定的Collection包装成线程安全的Collection;
    //<T> List<T> synchronizedList(List<T>);
    //<K,V> Map<K,V> synchronizedMap<Map<K,V>);
    //<T> Set<T> synchronizedSet(Set<T>);
    //<K,V> SortedMap<K,V> synchronizedSortedMap(SortedMap<K,V>);
    //<T> SortedSet<T> synchronizedSortedSet(SortedSet<T>);
    //如需要包装成线程安全的集合，则应该在创建后立即包装；

    //线程安全的集合类：
    //其实Java也提供了大量支持高并发访问的集合接口和实现类；
    //一些以Concurrent开头的集合类；
    //以CopyOnWrite开头的集合类；
    //HH

}
