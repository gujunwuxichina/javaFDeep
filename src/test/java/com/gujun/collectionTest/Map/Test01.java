package com.gujun.collectionTest.Map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/7/11 21:05
 * @Version 1.0
 **/
public class Test01 {

    //Map用于保存具有映射关系的数据；
    //Set和Map之间的关系非常密切；从源码来看Java是先实现了Map，然后通过包装一个所有value都是null的Map就实现了Set集合；
    //方法：
    //clear()，boolean containsKey(key)containsValue(value)；get(key);isEmpty();
    //Set entrySet()，返回Map中包含的key-value对所组成的Set集合，每个集合元素都是Map.Entry内部类对象；
    //Set keySet()，返回所有key组成的Set，Map的key不允许重复；
    //put(key,value);putAll(map);
    //remove(key);boolean remove(key,value)，删除指定key、value所对应的key-value对，若成功删除返回true;
    //size()；Collection values()，返回所有value组成的collection；
    //Map包含一个内部类Entry，该类封装了key-value对；Entry方法：
    //getKey();getValue();setValue(value),返回新设的value;
    @Test
    public void test01(){
        Map<String,String> map=new HashMap<>();
        map.put("name","gujun");
        map.put("age","22");
        Set<Map.Entry<String,String>> set=map.entrySet();
        for(Map.Entry entry:set){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

    }

}

