package com.gujun.IO;

import org.junit.Test;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/8/1 21:19
 * @Version 1.0
 **/
public class FileTest {

    //File类，代表文件和目录；不管是文件还是目录操作，都可以用File来完成；
    //File能新建、删除、重命名文件和目录，不能访问文件内容，访问文件内容需要输入/输出流；

    //访问文件和目录：
    //File类可以使用文件路径字符串来创建File实例，字符串可以是绝对路径也可以是相对路径；
    //默认情况下，总是根据用户工作路径来解释相对路径，由系统属性user.dir指定，通常也是运行JVM时所在的路径；
    //方法：
    //String getName()返回文件名或路径名，若是路径名则返回最后一级子路径；
    //String getPath()返回此File对象对应的路径名；
    //File/String getAbsoluteFile()/getAbsolutePath()
    //String getParent()返回此File对象对应的目录（最后一级子目录）的父目录名；
    //boolean renameTo(File newName)重命名此File对象对应文件或目录，成功返回true;
    //exists(),canWrite/Read(),isFile()是文件不是目录，IsDirectory(),isAbsolute()文件或目录是否是绝对路径；
    //mkdir(),试图创建一个File对象对应的目录，成功返回true,调用该方法的File对象必须是路径而不是文件；
    //String[] list()返回此File对象的所有子文件名和路径名；
    //File[] listFiles()，同上，返回的是File数组；
    //static File[] listRoots(),返回系统所有根路径；
    @Test
    public void test01() {
        System.out.println(System.getProperty("user.dir"));
    }

}
