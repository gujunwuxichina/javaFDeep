package com.gujun.IO.serializable;

import org.junit.Test;

import java.io.*;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/8/11 8:21
 * @Version 1.0
 **/
public class Test01 {

    //对象序列化的目标是把对象保存到磁盘中，或允许在网络中直接传输对象；
    //对象徐序列化允许把内存中的java对象，转换成平台无关的二进制流（字节序列）；
    //其他程序一旦获取该二进制流，可以恢复为java对象；

    //为了让某个对象支持序列化，必须让其类是可序列化的；
    //为此可以实现Serializable、Externalizable;

    //序列化
    @Test
    public void test01(){
        try(
                ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(new File("obj.txt")));
        ) {
            Game game=new Game("刀塔",0.0);
            objectOutputStream.writeObject(game);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //反序列化
    //反序列化读取的仅仅java对象数据，而不是java类，因此必须提供所属类的class文件；
    //反序列化无须通过构造器来初始化对象；
    //若序列化时向文件写入多个对象，则反序列化时 必须按照写入的顺序读取；
    @Test
    public void test02(){
        try(
            ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(new File("obj.txt")));
        ) {
            Game game= (Game) objectInputStream.readObject();
            System.out.println(game.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //对象引用的序列化，成员变量如果是引用类型，则必须也是可以序列化的；
    //Java序列化机制：
    //1.所有序列化的对象都有一个序列化编号；
    //2.当序列化一个对象时，会先检查该对象是否被序列化过，只有未被序列化过的才会进行序列化；
    //3.若对象已经序列化过，则只会输出一个序列化编号，不会再次进行序列化；

    //该序列化机制有一个潜在问题：若序列化一个可变对象，序列化一次后，改变对象的实例属性，再次序列化时不会进行；
    @Test
    public void test03(){
        File file=new File("obj.txt");
        try(
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(file));
            ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(file));
        ) {
            Game game=new Game("刀塔",0.0);
            objectOutputStream.writeObject(game);
            game.setName("dota2");
            objectOutputStream.writeObject(game);
            Game g1= (Game) objectInputStream.readObject();
            Game g2= (Game) objectInputStream.readObject();
            System.out.println(g1==g2); //true
            System.out.println(g1.toString());
            System.out.println(g2.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
