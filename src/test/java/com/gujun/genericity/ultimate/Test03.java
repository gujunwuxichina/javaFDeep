package com.gujun.genericity.ultimate;

/**
 * @ClassName: Test03
 * @Author GuJun
 * @Description:
 * @Date 2021年11月19日 10:43
 */
public class Test03 {

    //  泛型方法和类型通配符的区别
    //  多数情况下可以用泛型方法来代替通配符；
    //  泛型方法允许类型形参用来表示方法的一个或多个参数之间的类型依赖关系，或者方法返回值与参数之间的类型依赖关系；若没有就不应该使用泛型方法；

    //  也可以在构造器签名中声明类型形参，即泛型构造器；
    //  一旦定义类泛型构造器，在调用时，不仅可以让编译器来根据实参来推导出类型形参，也可以显示为构造器指定类型形参；
    //  如：public <T> Foo(T t),new Foo("text") , new <String> Foo("text");

    //  设定通配符下限


}
