package com.gujun.networkProgramming;

import org.junit.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class Basic03 {

    //读取URL引用的资源步骤：
    //1.通过URL对象的openConnection()创建URLConnection对象；
    //2.设置URLConnection的参数和请求属性；
    //3.若是get请求，使用connect()建立和远程资源之间的实际连接即可；
    //post请求，则需要获取URLConnection实例对应的输出流来发送请求参数；
    //4.远程资源变为可用，程序可以访问远程资源的头字段或通过输入流读取远程资源的数据；

    //方法：
    //在建立和远程资源的实际连接之前，可以设置请求头字段：
    //setRequestProperty(key,value)；
    //addRequestProperty(key,value),为该URLConnection的key请求头字段增加value,不会覆盖；
    //当远程资源可用后，可以访问响应头字段和内容：
    //Object getContent(),获取该URLConnection的内容；
    //String getHeaderField(name),获取指定响应头字段的值；
    //getInputStream()/getOutputStream()，返回URLConnection对应的输入/输出流，用于获取URLConnection响应的内容或向URLConnection发送请求参数；
    //tip:若既要使用输入流读取URLConnection响应内容，又要使用输出流发送请求参数，则一定要先使用输出流，再是输入流；

    @Test
    public void testGet(){
        try {
            URL url=new URL("http://127.0.0.1:8099/employee/employee/1");  //访问的Springboot03的；
            URLConnection connection=url.openConnection();
            //建立连接前，设置请求属性
            connection.setRequestProperty("accept","*/*");
            connection.setRequestProperty("connection","Keep-Alive");
            //建立实际连接
            connection.connect();
            //获取所有响应头字段
            Map<String, List<String>> headers=connection.getHeaderFields();
            for(String key:headers.keySet()){
                System.out.println(key+":"+headers.get(key));
            }
            try(
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            ){
                String line="";
                while((line=bufferedReader.readLine())!=null){
                    System.out.println(line);
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPost(){
        try {
            URL url=new URL("http://127.0.0.1:8099/employee/selectById");
            URLConnection connection=url.openConnection();
            connection.setRequestProperty("accept","*/*");
            connection.setRequestProperty("connection","Keep-Alive");
            //发送post请求必须设置如下
            connection.setDoInput(true);
            connection.setDoOutput(true);
            try(
                PrintWriter printWriter=new PrintWriter(connection.getOutputStream());
            ){
                //发送请求参数
                printWriter.print("eId=1");
                printWriter.flush();
            }
            try(
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            ){
                String line="";
                while((line=bufferedReader.readLine())!=null){
                    System.out.println(line);
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
