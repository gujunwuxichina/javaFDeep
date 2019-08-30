package com.gujun.Threads.ThreadSync;

import org.junit.Test;

public class SyncCodeBlock {

    //同步代码块:
    public static void main(String[] args) {
        Account account=new Account("A00001",1200);
        new DrawThread("甲",account,800).start();
        new DrawThread("乙",account,100).start();
        new DrawThread("丙",account,400).start();
    }

}
