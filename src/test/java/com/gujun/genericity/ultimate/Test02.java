package com.gujun.genericity.ultimate;

import org.junit.Test;

/**
 * @ClassName: Test02
 * @Author GuJun
 * @Description:
 * @Date 2021年11月10日 20:58
 */
public class Test02 {

    //  泛型方法
    //  有时定义类、接口时没有使用类型形参，定义方法时可以定义类型形参；
    //  定义方法定义一个或多个类型形参：
    //  修饰符 <T,S> 返回类型 方法名（...）{...},T和S可以在方法内当中普通类型使用；
    //  public <T> void move(Collect<? extends T> from,Collect<T> to);
    //  与类，接口中的泛型参数不同，方法中的泛型参数无须显示传入实际类型形参，因为编译器会根据实参推断出来类型形参；

    static <T extends  Country> void showCountry(T t){
        t.show();
    }

    @Test
    public void test01(){
        showCountry(new China());
        showCountry(new America());
    }

}
