package com.gujun.basicClass;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/7/2 21:19
 * @Version 1.0
 **/
public class DateTest {

    //Date类，无法实现国际化，历史悠久，大部分构造器、方法已过时，不推荐使用；
    //构造器：
    //Date()，生成一个当前时间的Date对象，该构造器底层调用System.currentTimeMillis()作为参数；
    //Date(long)，单位毫秒；
    //方法：
    //after(date)，before(date)，getTime()返回long，setTime(long)；

    //Calendar是一个抽象类，所有日历类的模板，本身不能实例化，只能创建子类的实例；
    //提供了几个静态getInstance()来创建实例，这些方法通过TimeZone、Locale来获取特定的实例，
    //若不指明则使用默认的TimeZone、Locale；
    //Calendar和Date直接可以相互转换：
    //Date calendar.getTime()，calendar.setTime(date)；
    //方法：
    //add(int field,int amount),给指定字段添加或减去时间量；
    //roll(field,amount)，和add()类似，区别在于超过最大值时不会进位；
    //get(field)，返回指定字段的值；
    //getActualMaximum(field)，返回指定字段可能的最大值；
    //set(field,value)，H
    //上面很多方法都需要一个int类型的field参数，field是Calendar的类变量，如Calendar.YEAR/MONTH;
    //注意Calendar.MONTH的起始值不是1而是0；
    @Test
    public void test01(){
        Calendar calendar=Calendar.getInstance();
        System.out.println(calendar.get(Calendar.YEAR));
    }
    //设置Calendar的容错性；若set()时传入的参数超过规定值，如：
    @Test
    public void test02(){
        Calendar calendar=Calendar.getInstance();
        System.out.println(calendar.getTime());
        calendar.set(Calendar.MONTH,13);    //超过规定值，年加1月变为1即2月
        System.out.println(calendar.getTime());
        calendar.setLenient(false); //关闭容错性
        //calendar.set(Calendar.MONTH,13);    //则运行时异常
    }
    //set()延迟修改，通过set(field，value)修改字段时，字段会立即更改，但是Calendar所代表的时间
    //不会立即修改，直到下次调用get()、getTime()、add()、roll()等才会重新计算时间；
    //采用延迟修改的优势是在多次调用set()不会触发多次不必要的计算，即计算出一个代表时间的long整数；
    //HH

    @Test
    public void test03(){
        Calendar calendar=Calendar.getInstance();
        System.out.println(calendar.getTime());
        System.out.println(calendar.get(Calendar.MINUTE));
    }

    @Test
    public void test04(){
        Calendar calendar=Calendar.getInstance();
        System.out.println(String.valueOf(calendar.get(1)).substring(2));
        System.out.println(String.format("%02d",calendar.get(2)+1 ));
    }

    @Test
    public void test05() throws ParseException {
        Calendar calendar1=Calendar.getInstance();
        System.out.println(calendar1.toString());
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(new Date()));
//        System.out.println(simpleDateFormat.parse("2021-03-06"));
    }

    @Test
    public void test06(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime=LocalDateTime.parse(simpleDateFormat.format(new Date()),formatter);
        System.out.println(localDateTime.toString());
    }

}
