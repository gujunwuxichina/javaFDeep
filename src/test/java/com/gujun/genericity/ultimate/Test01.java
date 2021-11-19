package com.gujun.genericity.ultimate;

import com.gujun.OO.whyNeedInnerClass.A;
import org.junit.Test;

/**
 * @ClassName: Test01
 * @Author GuJun
 * @Description:
 * @Date 2021年11月09日 19:23
 */
public class Test01 {

    //  深入泛型
    //  泛型即在定义类、接口、方法时使用类型形参，该类型形参将在声明变、创建对象、调用方法时动态传入实际的类型参数；

    @Test
    public void test01(){
        Apple<String> apple=new Apple<>("苹果");
        System.out.println(apple);
    }

    //  从泛型类派生子类
    //  当创建了带泛型的接口、父类之后，可以为该接口创建实现类，为该父类派生子类；
    //  当使用这写接口、父类时不能再包含类型形参；
    //  与调用方法不同，调用接口/父类时也可以不为类型形参传入实际的类型形参,以下都是准确的：
    /*
     *  public class A extends Apple    //  这个会发出警告
     *  public class B extends Apple<String>
     */
    //  不存在泛型类，不管为泛型的类型形参传入哪种实参，都会被当成同一类处理，在内存中占用同一块内存；
    //  因此在静态方法，静态初始化块，静态变量声明/初始化中不允许使用类型形参；
    //  instanceof运算符后面也不能使用泛型；

    //  类型通配符
    //  tip:List<String>并不是List<Object>的子类；（数组可以）
    //  为了表示各种泛型List的父类，可以使用类型通配符(?)，List<?>，即元素未知的List;
    //  但只表示各种泛型的父类，并不能把元素加入其中，因为无法确定集合中的元素类型；
    //  设定类型通配符上限
    //  为了表示某一类泛型的父类，List<? extends Super>,但是任然无法知道确切的类型；

    //  设定类型形参上限
    //  可以在定义类型形参时设定上限，表示传给该类型形参的实际类型要么是该上限或该上限子类；
    //  也可以设定多个上限：<T extends Super & Interface>，表示是上限或其子类并实现该接口；

}
