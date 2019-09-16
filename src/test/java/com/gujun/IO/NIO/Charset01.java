package com.gujun.IO.NIO;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/8/18 13:01
 * @Version 1.0
 **/
public class Charset01 {

    //字符集和Charset:
    //对于文本文件，之所以看到的是一个个字符，是因为系统将底层的二进制序列转换成字符的缘故；✳
    //涉及到两个概念编码和解码；
    //Java默认使用Unicode字符集，但有些系统则不是使用Unicode字符集，当从这些系统读取数据到Java中时，就有可能出现乱码；
    //可以通过Charset来来处理字节序列和字符序列（字符串）之间的转换关系；Charset类是不可变类；
    @Test
    public void test01(){
        //获取当前JDK所支持的所有字符集；
        //一些常用字符集：GBK简体中文，BIG5繁体中文,ISO-8859-1:ISO拉丁字母表；
        SortedMap<String,Charset> charsetSortedMap=Charset.availableCharsets();
        Set<Map.Entry<String,Charset>> entries=charsetSortedMap.entrySet();
        for(Map.Entry<String,Charset> entry:entries){
            System.out.println(entry.getKey()+"-"+entry.getValue());//打印了所有字符集别名和Charset对象；
        }
        System.out.println("======================================================");
        //获取本地系统文件编码格式：
        System.out.println(System.getProperties().getProperty("file.encoding"));
    }

    //一旦知道了字符集的别名后，就可以调用Charset.forName()来创建对应的Charset对象；
    //JDK7提供了StandardCharsets类，该类包含了UTF-8/16,ISO-8859-1等类变量，代表常用的Charset对象；
    //获取相应的Charset对象后，就可以通过调用newDecoder,newEncoder()分别获取CharsetDecoder和CharsetEncoder
    //分别代表解码器和编码器；
    //调用CharsetDecoder的decode()将ByteBuffer字节序列转换成CharBuffer字符序列；
    //调用CharsetEncoder的encode()将CharBuffer或字符串转换成ByteBuffer;
    @Test
    public void test02() throws CharacterCodingException {
        Charset gbk=Charset.forName("GBK");
        CharsetDecoder decoder=gbk.newDecoder();
        CharsetEncoder encoder=gbk.newEncoder();
        CharBuffer charBuffer=CharBuffer.allocate(2);
        charBuffer.put("顾隽");
        System.out.println(charBuffer.capacity());  //2
        charBuffer.flip();
        ByteBuffer byteBuffer=encoder.encode(charBuffer);
        System.out.println(byteBuffer.capacity());  //4
        for(int i=0,j=byteBuffer.capacity();i<j;i++){
            System.out.println(byteBuffer.get(i));
        }
    }
    //也可以调用Charset对象的decode(ByteBuffer)/encode(Charbuffer/String)来之间转换，无须先创建解码器或编码器；
}
