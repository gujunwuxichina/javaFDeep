package com.gujun.se;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/5/8 20:22
 * @Version 1.0
 **/
public class ArrayInCrazyJava {

   //Crzay Java
   //Java中的数组具有其特有的特征；
   //数组也是一种数据类型，一种引用类型；
   //Java要求同一数组中，所有数组元素具有相同的数据类型，由于Java是面向对象的，所有会凹槽一个数组里存放多种数据类型的假象；
   //一旦数组初始化完成，其在内存中所占的空间就被确定下来，即数组长度不可改变；即使把数组元素情况，所在内存空间依旧在，长度不变；
   //定义数组type[] arrayName;此处只是定义一个（数组）变量，该变量未指向任何有效的内存，所以定义数组时不能指定数组的长度；
    //数组初始化，Java数组必须先初始化，才可以使用；所谓初始化就是为数组元素分配内存，并赋初始值；
    //1.静态初始化，由程序员指定每个元素初始值，由系统决定其长度；
    //2.动态初始化，程序员指定其长度，系统来分配初始值；
    //深入数组：
    //数组变量和数组元素在内存中是分开存放的；
    //工具类Arrays:
    //binarySearch(type[],type key,...)返回指定元素在数组的索引，没有返还负数，要求数组元素已经按升序排序；
    //copyOf(type[],int lengh),会把原数组复制到一个新数组；
    //equals(int[],int[])如果两个数组长度相同，元素也相同，则返还true;
    //fill(int[],val,...)，将数组的元素全部赋为val;
    //sort(...)，排序
    //toString(type[]),将一个数组转换为字符串，用，和空格隔开；
    //System有个static的arraycopy(Object src,int srcPos,Object dest,int destPos,int length)，将src数组里元素赋给dest数组的元素，

    @Test
    public void test01(){
        int[] array1={1,2,3,4,5};
        System.out.println(Arrays.binarySearch(array1,6)+"");//返还负数，不是-1
        int[] array2={1,2,3,4,5};
        System.out.println(Arrays.equals(array1,array2));   //顺序也必须相同
    }

    //Java8为Arrays增加了一些可以利用多核CPU并行能立的方法；
    //parallelPrefix(type[],op),使用op参数指定的计算公式计算得到的结果作为新的元素，op计算公式包括left,right两个参数，left当前元素前一个索引处的元素，right当前索引的元素；
    //setAll(type[],generator)，使用指定的生成器为所有数组元素设值；
    //parallelSort(type[])，排序用到了CPU并行；
    //stream(type[]),将数组转换为Stream；

    @Test
    public void test02(){
        int[] ints={11,2,22,1,4,123,54,555,32,66,78,9,1234,666};
        Arrays.parallelSort(ints);
        System.out.println(Arrays.toString(ints));
        Arrays.parallelPrefix(ints, new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return left+right;
            }
        });
        System.out.println(Arrays.toString(ints));
        int[] ints1={1,2,3,4,5,6};
        Arrays.setAll(ints1, new IntUnaryOperator() {
            @Override
            public int applyAsInt(int operand) {    //operand代表索引
                return operand*10;
            }
        });
        System.out.println(Arrays.toString(ints1));
    }

    @Test
    public void test03(){
        Integer[] ints=new Integer[5];
        System.out.println(ints[0]);
    }

}
