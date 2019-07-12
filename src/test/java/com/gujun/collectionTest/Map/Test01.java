package com.gujun.collectionTest.Map;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
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

    //JDK8新增的方法：H

    //HashMap和Hashtable,推荐使用HashMap,Hashtable是个古老的类；
    //类比于ArrayListt和Vector;
    //Hashtable不允许key为null，HashMap的key可以为null;
    //为了成功在HashMap、Hashtable中存储key-value，作为key的对象的实现类必须实现hashCode()和equal(),且两个方法结果一致（参考Set）;
    //HashMap和Hashtable如何判断value相等？只需equal()返回true即可；

    //LinkedHashMap实现类，类似于LinkedHashSet，使用双向链表来维护key-value对的次序（插入的次序），性能低于HashMap，但在迭代上性能不错；

    //Properties读写属性；
    //Properties类是Hashtable的子类，Properties类可以把Map对象和属性文件关联在一起，从而Map中的key-value对写入属性文件中；
    //也可以把属性文件中的 name=value 加载到Map对象中；Properties中的key、value都是字符串类型；
    //方法：
    //getProperty(key)/getProperty(key,defaultValue);
    //setProperty(key,value);
    //load(InputStream),从属性文件中加载key-value对，把加载的key-value对放入Properties里（并不保证次序）；
    //store(OutputStream,String comments),将Properties的key-value对输出到指定的属性文件中；
    @Test
    public void test02() throws IOException {
        Properties propertiesIn=new Properties();
        propertiesIn.load(new FileInputStream(new File("in.ini")));
        System.out.println(propertiesIn);
        Properties propertiesOut=new Properties();
        propertiesOut.setProperty("city","wuxi");
        propertiesOut.setProperty("job","it");
        propertiesOut.store(new FileOutputStream(new File("out.ini")),"test out");
    }

}

