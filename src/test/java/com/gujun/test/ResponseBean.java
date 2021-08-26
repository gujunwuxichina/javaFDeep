package com.gujun.test;



import java.io.Serializable;

import lombok.Data;

public class ResponseBean<T>  implements Serializable {

    private static final long serialVersionUID = 5934507426690847834L;
    /**
     * code : 200
     * message : 请求成功
     * data : cb5e73775d671694cf71d6736b4cc18d
     * success : true
     * timeStamp : 2020-12-15 02:31:30
     */
    private int code;
    private String message;
    private T data;
    private boolean success;
    private String timeStamp;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "ResponseBean{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", success=" + success +
                ", timeStamp='" + timeStamp + '\'' +
                '}';
    }
}
