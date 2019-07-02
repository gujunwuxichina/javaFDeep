package com.gujun.basicClass;

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
    //

}
