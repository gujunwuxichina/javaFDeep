package com.gujun.IO.NIO2;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/8/18 14:03
 * @Version 1.0
 **/
public class Basic01 {

    //JDK7对NIO进行了改进；
    //Path,Paths,Files：
    //之前是通过File类访问文件系统的，但是功能比较有限，性能一般，出错仅返回失败无异常信息；
    //NIO2为此提供了Path接口，Path代表一个平台无关的平台路径；
    //还提供了Files,Paths两个工具类，Files类包含了大量静态的方法来操作文件，
    //Paths,包含了两个返回Path的静态工厂方法；
    @Test
    public void testPath(){
        Path path= Paths.get(".");  //以当前路径创建Path对象；
        System.out.println(path.getNameCount());    //path里包含的路径数量；1
        System.out.println(path.getName(0));    //.
        Path absolurePath=path.toAbsolutePath();    //获取该path的绝对路径
        System.out.println(absolurePath);
        System.out.println(absolurePath.getNameCount());    //3
        System.out.println(absolurePath.getName(0));
        System.out.println(absolurePath.getName(1));
        System.out.println(absolurePath.getName(2));
        //以多个String来构建Path对象
        Path path1=Paths.get("c","reids");
        System.out.println(path1);  //c\reids
        System.out.println(path1.getNameCount());   //2
        System.out.println(path1.getName(0));   //c
    }
    //应该熟练掌握Files，它的工具方法大大简化了文件IO操作；
    @Test
    public void testFiles() throws IOException {
        //判断文件是否是隐藏文件
        System.out.println("gj.txt是否是隐藏文件:"+Files.isHidden(Paths.get("gj.txt")));
        //复制文件内容
        Files.copy(Paths.get("FilesIn.txt"),new FileOutputStream(new File("FilesOut.txt")));
        //读取所有行
        List<String> lines=Files.readAllLines(Paths.get("gj.txt"), Charset.forName("UTF-8"));
        for(String line:lines){
            System.out.println(line);
        }
        //文件大小
        System.out.println(Files.size(Paths.get("gj.txt")));    //字节
        //写入内容,覆盖，添加？
        List<String> list=new ArrayList<>();
        list.addAll(Arrays.asList(new String[]{"gj","gujun"}));
        Files.write(Paths.get("gj.txt"),list,Charset.forName("UTF-8"));
        //列出当前目录下的所有文件和子目录（Stream方式）；
        Files.list(Paths.get(".")).forEach(path-> System.out.println(path));
        //Stream方式读取文件的所有行
        Files.lines(Paths.get("gj.txt"),Charset.forName("UTF-8")).forEach(line-> System.out.println(line));
        //判断C盘空间使用情况：
        FileStore fileStore=Files.getFileStore(Paths.get("C:"));
        System.out.println(fileStore.getTotalSpace());
        System.out.println(fileStore.getUsableSpace()); //可用
    }


}
