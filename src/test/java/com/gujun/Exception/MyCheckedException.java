package com.gujun.Exception;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/7/28 9:34
 * @Version 1.0
 **/
public class MyCheckedException extends Exception {

    public MyCheckedException() {
    }

    public MyCheckedException(String message, Throwable cause) {
        super(message, cause);
    }
}
