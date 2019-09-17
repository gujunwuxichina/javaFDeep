package com.gujun.networkProgramming;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownUtil {

    private String path;

    private String target;

    private int threadNum;

    private DownThread[] threads;

    private int fileSize;

    public DownUtil(String path, String target, int threadNum) {
        this.path = path;
        this.target = target;
        this.threadNum = threadNum;
        this.threads = new DownThread[threadNum];
    }

    public double getCompleteRate(){
        int sumSize=0;
        for(int i=0;i<threadNum;i++){
            sumSize+=threads[i].hasDown;
        }
        return sumSize*1.0/fileSize;
    }

    public void downLoad() throws IOException {
        URL url=new URL(path);
        HttpURLConnection connection= (HttpURLConnection) url.openConnection();
        fileSize=connection.getContentLength();
        connection.disconnect();
        int partSize=fileSize/threadNum+1;  //每个线程下载的大小
        RandomAccessFile file= new RandomAccessFile(target,"rw");
        file.setLength(fileSize);
        file.close();
        for(int i=0;i<threadNum;i++){
            int startPos=partSize*i;
            RandomAccessFile randomAccessFile=new RandomAccessFile(target,"rw");
            randomAccessFile.seek(startPos);
            threads[i]=new DownThread(path,startPos,partSize,randomAccessFile);
            threads[i].start();
        }
    }

}
