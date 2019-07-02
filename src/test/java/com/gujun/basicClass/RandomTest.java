package com.gujun.basicClass;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/7/2 11:17
 * @Version 1.0
 **/
public class RandomTest {

    //Random类专门用于生成伪随机数，两个构造器，一个使用默认种子即当前时间，另一个显示传入long型整数的种子；
    @Test
    public void testRandom(){
        Random random=new Random(); //默认种子即当前时间
        System.out.println(random.nextBoolean()+"");
        byte[] byts=new byte[10];
        random.nextBytes(byts);
        System.out.println(Arrays.toString(byts));
        System.out.println(random.nextInt()+""); //生成一个处于int范围的伪随机整数；
        System.out.println(random.nextInt(100)+"");  //0到100
    }
    //Random使用一个48位的种子(long型),如果两个Random实例种子相同，且同样的方法调用顺序，则结果会相同；对此可以使用System.currentTimeMillis()作为参数；

    //ThreadLocalRandom是Random的增强版，在并发环境下适合；
    //用法与Random相似，通过静态方法current()来获取ThreadLocalRandom实例；

}
