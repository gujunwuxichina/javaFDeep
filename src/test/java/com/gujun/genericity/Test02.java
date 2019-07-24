package com.gujun.genericity;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/7/24 20:08
 * @Version 1.0
 **/
public class Test02 {

    //类型通配符
    //如，A是B的一个子类或子接口，G是具有泛型声明的类或接口，则G<A>并不是G<B>的子类型；
    //但是对于数组是可以的，即A[]时B[]的子类型；

    //使用类型通配符
    //如，List<?>，即元素类型未知，可以是任何泛型List的“父类”；
    //如果只希望四某一类泛型List的“父类”,则可以通过类型通配符上限；List<? extends B>，则此时List<A>可以使用；

    //设定类型形参上限；
    //也可以是设定多个上限，最多一个父类上限，多个接口上限 如<T extends 父类 & 接口..>；

    //泛型方法，类型形参放在修饰符或返回值类型之间；

}
