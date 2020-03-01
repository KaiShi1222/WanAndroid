package com.study.luoluo.wanandroid.core.network;

// all service data like this
public class BaseResponse<T> {

    private T data;

    private  String errorMsg;

    private int errorCode;

    public String getErrorMsg() {
        return errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public T getData() {
        return data;
    }


}
