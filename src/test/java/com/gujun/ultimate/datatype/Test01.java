package com.gujun.ultimate.datatype;

/**
 * @ClassName: Test01
 * @Author GuJun
 * @Description:    基本数据类型
 * @Date 2021年06月27日 13:17
 */
public class Test01 {

    // 整数
    // byte,8位；shor 16位；int 32位；long 64位；
    // 直接给出整数默认类型是int;
    // 整数的4中表现形式
    // 十进制
    // 二进制，0b或0B开头；
    // 八进制，0开头；
    // 十六进制，0x或0X开头，其中10~15用a~f表示，不区分大小写；
    // 整数在计算机底层中都是以二进制形式存在的；
    // 原码是指一个数值的二进制数；
    // 补码计算规则，正数的补码和原码相同；负数的补码是其反码加1；反码是对原码按位取反，符号位不变；

    // 字符型  char
    // Java使用16位的Unicode字符集作为编码方式，Unicode支持世界上所有的语言字符；
    // 三种表现形式：
    // 1.直接表示‘字符’；
    // 2.通过转义字符表示特殊字符，'\n'
    // 3.用Unicode值表示字符型值，'\uffff'；
    // 由于计算机底层保存字符时是保存其编号，所以char类型的值也可以直接作为整型值来使用，相当于一个16位无符号整数，访问0~2^16-1

    // 浮点型  float double
    // Java浮点类型有固定的表述范围和字段长度，与机器无关； HH
    // 由于使用二进制表示浮点数，所以不能精确表示；建议使用BigDecimal;
    // 默认double类型；
    // Java还提供了三个特殊的浮点数值：
    // 正无穷大，Double/Float.POSITIVE_INFINITY
    // 负无穷大，Double/Float.NEGATIVE_INFINITY
    // 非数，NaN;

    // 基本类型的类型转换
    // 自动类型转换；强制类型转换；

    // 直接量
    // 字符串直接量，当程序第一次使用某个字符串直接量时，Java会使用常量池来缓存该字符串直接量，程序后面用到该字符串直接量时会直接使用常量池中的；
    // 常量池，指的是编译期被确定，并保存在已编译的class文件中的一些数据，包括类、方法、接口中的常量；

}
