package com.gujun.networkProgramming.TCP;

public class Basic02 {

    //半关闭的Socket
    //一个问题：Socket的输出流如何表示数据已经结束？
    //在IO中，表示输出已经结束，可以通过关闭输出流来实现；
    //但在网络通信中，则不可以通过关闭输出流来实现，因为关闭了输出流，该输出流对应的Socket也将随之关闭；
    //为此Socket提供了半关闭的方法，只关闭Socket的输入流或输出流：
    //shutdownInput()，只关闭Socket的输入流，还可以通过Socket的输出流输出数据；
    //shutdownOutput(),只关闭Socket的输出流，还可以通过Socket的输入流读取数据；
    //当调用了shutdownInput()/shutdownOutput()后，Socket处理半关闭状态，可以通过isInputShutdown()/isOutputShutdown()判断
    //Socket是否处于半读或半写状态；
    //当调用了shutdownInput()/shutdownOutput()后，Socket无法再次打开输入流/输出流；
    //符合一站式通信协议，如Http协议——客户端连接到服务器，发送请求，发送完成后无须再次发送数据，只需等待服务器响应数据，
    //当读取响应数据完成后，该Socket连接也就关闭了；

}
