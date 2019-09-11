package com.gujun.genericity;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/7/24 20:08
 * @Version 1.0
 **/
public class Test02 {

    void f1(List<Object> list){
        System.out.println(list.size());
    }
    @Test
    public void test(){
        List<String> list=new ArrayList<>();
        //f1(list);   //会产生编译错误，即List<String>并不是List<Object>的子类，不能当作List<Object>使用；
    }
    //类型通配符
    //如，A是B的一个子类或子接口，G是具有泛型声明的类或接口，则G<A>并不是G<B>的子类型；
    //但是对于数组是可以的，即A[]是B[]的子类型；

    //使用类型通配符
    //为了表示任何泛型List的"父类",可以使用类型通配符，即？,将一个？作为类型实参；
    //如，List<?>，即元素类型未知，可以是任何泛型List的“父类”；
    //这样上面的例子中，可以传入任何类型的List,且程序可以访问集合中的元素，其类型是Object，因为不管List的实际类型是什么，都是包含Object的；
    //tip:并不能把元素加入其中，因为程序无法确定集合中的元素类型；

    //设置类型通配符上限：
    //如果不希望是任何泛型List的"父类",只希望代表某一类泛型List的“父类”,则可以通过类型通配符上限；List<? extends B>，则此时List<A>可以使用；
    abstract class Game{
        abstract void show();
    }
    class LOL extends Game{
        @Override
        void show() {
            System.out.println("英雄联盟");
        }
    }
    class DOTA extends Game{
        @Override
        void show() {
            System.out.println("刀塔");
        }
    }
    void showGames(List<? extends Game> games){
        for(Game game:games){
            game.show();
        }
    }
    @Test
    public void test02(){
        List<Game> games=new ArrayList<>();
        games.add(new LOL());
        games.add(new DOTA());
        showGames(games);
    }

    //设定类型形参上限；
    //Java泛型不仅允许在使用类型通配符使用上限，还可以在定义类型形参时设定上限；
    //也可以是设定多个上限，最多一个父类上限，多个接口上限 如<T extends 父类 & 接口..>；

    //泛型方法：
    //有时在定义类、接口时没有使用类型形参，当定义其方法时想定义类型形参，是可以的；
    //类型形参放在修饰符或返回值类型之间;

    //泛型方法和类型通配符的区别：
    //大多数情况都可以使用泛型方法类替代类型通配符；
    //泛型方法允许类型形参被用来表示方法的一个或多个参数之间的依赖关系或返回值与参数之间的依赖关系，如果没有这样的依赖关系就不应该使用泛型方法；
    //也可以同时使用泛型方法和类型通配符；

    //菱形语法和泛型构造器：
    //Java也允许在构造器签名中声明类型形参；
    //一旦定义泛型构造器，不仅可以让Java根据实现参数类型来推断类型形参类型，还可以在调用构造器时显示指定实际类型；
    @Test
    public void test01(){
        new Good("gujun");
        new <Integer> Good(22);
    }
    //菱形语法：
    //H

}
