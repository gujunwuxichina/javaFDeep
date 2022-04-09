package com.gujun.effectivejava.chapter1;

import org.junit.Test;

import java.util.WeakHashMap;

/**
 * @ClassName: Test01
 * @Author GuJun
 * @Description:
 * @Date 2022年04月09日 15:43
 */
public class Test01 {

    @Test
    public void test01(){
        String key="key";
        WeakHashMap<String,String> weakHashMap=new WeakHashMap<>();
        weakHashMap.put(new String("name"),"gujun");    //  弱引用
        weakHashMap.put(new String("age"),"22");
        weakHashMap.put(key,"强引用");
        System.out.println(weakHashMap.size()); //  3
        System.gc();
        System.runFinalization();
        System.out.println(weakHashMap.size()); //  1
    }

}
