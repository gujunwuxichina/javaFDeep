package com.gujun.IO.NIO;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/8/16 8:38
 * @Version 1.0
 **/
public class Basic01 {

    //之前的输入输出处理方式都是阻塞的，而且都是通过字节来处理的，一次只能处理一个字节，效率并不高；
    //NIO概述：
    //NIO采用了内存映射文件的方式来处理输入输出；将文件或文件的一部分映射到内存中，就可以像访问内存一样来访问文件了；
    //Channel和Buffer：
    //1.Channel(通道)是对传统的输入输出系统的模拟，在NIO中所有的数据都需要通过通道传输；
    //相比传统的InputStream/OutputStream提供了一个map(),该方法可以将一块数据映射到内存中；传统IO是面向流的处理，NIO是面向块的处理；
    //2.Buffer可以理解为一个容器，本质是个数组，发送到Channel中的所有数据必须先放在Buffer中，从Channel中读取的数据也必须先放到Buffer中；

    //Buffer是一个数组，可以保存多个类型相同的数据；Buffer是一个抽象类，最常用子类ByteBuffer，可以在底层字节数组上进行操作；
    //此外，基本类型除了boolean都有对应的Buffer子类，如：CharBuffer，ShortBuffer等；
    //Buffer没有构造器，通过如下方法来获取Buffer实例：
    //XXXBuffer allocate(int capacity)创建一个容量为capacity的XXXBuffer实例；
    //实际中使用最多的是ByteBuffer和CharBuffer,其中ByteBuffer还有个子类MappedByteBuffer,用于表示Channel将文件的部分或全部映射到内存中后得到的结果；
    //Buffer中的三个概念：
    //1.capacity容量，表示该Buffer的最大数据容量，创建后不能改变；
    //2.limit界限，第一个不应该被读出或写入的缓冲区索引位置；
    //3.position位置，指明下一个可以读出或写入数据的缓冲区索引位置；
    //当使用Buffer从Channel中读取数据时，position值等于读取了多少数据；当刚刚创建一个Buffer，其position值为0；
    //此外Buffer中还有一个可选的标记mark,允许直接将position定位到mark处：0<=mark<=position<=limit<=capacity；
    //方法：
    //flip(),先将limit设为此时position的位置，再将position设为0，即为放入数据后做好输出数据的准备；
    //clear(),该方法不是情况Buffer中的数据，而是将position设为0，limit设为capacity,即为再次向Buffer放入数据做好准备；
    //capacity(),limit(),position(),hasRemaining()判断当前位置position和limit之间是否还有元素可供处理；
    //Buffer limit(int),重新设置界限limit值，返回一个具有新limit的Buffer;
    //Buffer mark(),设置Buffer的mark位置，mark只能在0和position之间；
    //Buffer position(int),int remaining()返回当前位置position和limit之间的元素个数；
    //Buffer reset(),将position设为mark的位置；
    //Buffer rewind(),将position设为0，并取消设置的mark;
    //put()/get(),既支持对单个数据的操作，也支持批量数据操作（以数组为参数）；
        //put/get操作分为相对和绝对：
        //相对，从position位置开始读取或放入数据，然后将position相应的增加；
        //绝对，直接根据索引来访问数据，并不会影响position的改变；

    @Test
    public void test01(){
        CharBuffer charBuffer=CharBuffer.allocate(10);
        System.out.println("刚刚创建buffer时");
        System.out.println("capacity:"+charBuffer.capacity());
        System.out.println("position:"+charBuffer.position());
        System.out.println("limit:"+charBuffer.limit());
        charBuffer.put(new char[]{'g','u','j','u','n'});
        System.out.println("向buffer中放入数据后");
        System.out.println("capacity:"+charBuffer.capacity());
        System.out.println("position:"+charBuffer.position());
        System.out.println("limit:"+charBuffer.limit());
        charBuffer.flip();
        System.out.println("调用flip(),即为放入数据后做好输出数据的准备");
        System.out.println("capacity:"+charBuffer.capacity());
        System.out.println("position:"+charBuffer.position());
        System.out.println("limit:"+charBuffer.limit());
        char[] name=new char[charBuffer.limit()];
        charBuffer.get(name);
        System.out.println(new String(name));
        System.out.println("通过get()读取数据后");
        System.out.println("capacity:"+charBuffer.capacity());
        System.out.println("position:"+charBuffer.position());
        System.out.println("limit:"+charBuffer.limit());
        charBuffer.clear();
        System.out.println("调用clear(),再次向Buffer放入数据做好准备");
        System.out.println("capacity:"+charBuffer.capacity());
        System.out.println("position:"+charBuffer.position());
        System.out.println("limit:"+charBuffer.limit());
    }

    //通过allocate()创建的Buffer是普通Buffer;ByteBuffer提供了allocateDirect()来创建直接Buffer,直接Buffer创建成本高，但效率好；
    //只有ByteBuffer()才有allocateDirect(),若其它类型需要，则将ByteBuffer创建的直接Buffer转换成其它类型；

    //Channel:
    //类似于传统的流对象，但有两个主要区别：
    //1.Channel可以将文件的部分或全部映射成Buffer;
    //2.程序不能直接访问Channel中的数据，Channel只能与Buffer交互，读写都必须通过Buffer;
    //所有的Channel实例都不是通过构造器获取的，而是通过传统的节点的getChannel()来获取；不同的节点流返回的Channel不同；
    //方法：
    //MappedByteBuffer map(FileChannel.MapMode,long,long),第一个参数执行映射的模式：只读，读写等；
    //read()/write(),都有一系列重载方法，用于从Buffer中读取/写入数据；
    @Test
    public void test02(){
        try(
            FileChannel inChannel=new FileInputStream(new File("nio-in.txt")).getChannel();
            FileChannel outChannel=new FileOutputStream(new File("nio-out.txt")).getChannel();
        ) {
            MappedByteBuffer buffer=inChannel.map(FileChannel.MapMode.READ_ONLY,0,new File("nio-in.txt").length());
            outChannel.write(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //不仅InputStream，OutputStream包含getChannel(),RandomAccessFile也包含getChannel();
    //至于RandomAccessFile的getChannel()返回的是读写还是只读，取决于RandomAccessFile打开文件的模式；
    @Test
    public void test03(){
        try(
            RandomAccessFile randomAccessFile=new RandomAccessFile(new File("nio-in.txt"),"rw");
            FileChannel fileChannel=randomAccessFile.getChannel();
        ) {
            MappedByteBuffer buffer=fileChannel.map(FileChannel.MapMode.READ_ONLY,0,new File("nio-in.txt").length());
            fileChannel.position(new File("nio-in.txt").length());  //将指针移到文件内容最后
            fileChannel.write(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //如果担心Channel对应的文件太大，map()一次性将全部文件内容映射到内存中导致性能下降；
    //想使用传统IO中的“竹筒多次盛水”，也是可以的；
    @Test
    public void test04(){
        try(
           FileChannel fileChannel=new FileInputStream(new File("nio-in.txt")).getChannel();
        ) {
           ByteBuffer byteBuffer=ByteBuffer.allocate(256);
           int i=0;
           while (fileChannel.read(byteBuffer)!=-1){
               i++;
               byteBuffer.flip();//为读取数据准备
               Charset charset=Charset.forName("UTF-8");
               CharsetDecoder decoder=charset.newDecoder();
               CharBuffer charBuffer=decoder.decode(byteBuffer);
               System.out.println(charBuffer);
               byteBuffer.clear();//为再次写入数据准备
           }
            System.out.println("总共读取了："+i+"次");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
