package com.gujun.ultimate.generics;

/**
 * @ClassName: Test02
 * @Author GuJun
 * @Description:
 * @Date 2021年07月27日 17:41
 */
public class Test02 {

    //  当使用一个泛型类时（声明变量和创建对象），都应该传入一个实参；若无发出警告；
    //  注意：List<String>并不能当作List<Object>的子类；但数组可以；

    //  类型通配符
    //  如为了表示各种泛型List的父类，可以使用List<?>,即元素未知的List;?即通配符；
    //  但这种通配符的List仅表示是各种泛型List的父类，并不能把元素加到其中，因为不知道具体类型是什么；

    //  设定类型通配符的上限
    //  只希望是某一类泛型List的父类；
    //  List<? extends SuperClass>,表示所有SuperClass泛型List的父类；

    //  设定类型形参上限
    //  class Apple<? extends SuperClass>;
    //  可以顶一个多个上限，一个父类上限，多个接口上限；
    //  class Class<? extends SuperClass & Interface..>

}
