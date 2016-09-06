package com.jason.retrofitdemo.model;

/**
 * @author zjh
 * @date 2016/8/19
 */
public class WrapperRspEntity<T> {
    private int status;
    private T data;
    private String msg; //errorMSG;


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
