package com.gujun.ultimate.generics;

import com.gujun.App;
import com.gujun.OO.whyNeedInnerClass.A;
import org.junit.Test;

/**
 * @ClassName: Test01
 * @Author GuJun
 * @Description:
 * @Date 2021年07月27日 17:14
 */
public class Test01 {

    //  在定义类、接口、方法时使用类型形参，创建对象、调用方法时动态指定；

    //  泛型接口、类
    private class Apple<T>{
        private T t;
        public Apple() {
        }
        public Apple(T t) {
            this.t = t;
        }
        public T getT() {
            return t;
        }
        public void setT(T t) {
            this.t = t;
        }
    }
    @Test
    public void test01(){
        Apple<String> apple=new Apple<>("红富士");
        System.out.println(apple.getT());
    }

    //  从泛型类派生子类
    //  当创建了带泛型声明的接口、父类之后，可以创建实现类、派生子类，
    //  当使用这些接口，父类不再包含类型形参
    //  class AppleBig extends Apple<String>{...}

    //  在静态方法，静态代码块，静态遍历声明不允许使用类型形参；因为不存在泛型类；



}
