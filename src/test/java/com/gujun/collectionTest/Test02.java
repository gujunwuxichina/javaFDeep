package com.gujun.collectionTest;

import com.gujun.OO.whyNeedInnerClass.A;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/7/8 20:54
 * @Version 1.0
 **/
public class Test02 {

    //Think in Java
    //Arrats和Collections中包含了很多方法，可以在Collection添加一组元素；
    //Arrays.asList()接受一个数组或是一个用逗号隔开的元素列表（可变参数），将其转为List对象；
    //Collections.addAll()，接受一个Collection对象，以及一个数组或用逗号隔开的元素列表，将其添加到Collection对象中；

    @Test
    public void testStream01(){
        List<Map<String,String>> list=new ArrayList<>();
        for(Map<String,String> map:list){
            System.out.println(map);
        }
    }

}
