package com.study.luoluo.wanandroid.module.homepage.bean;

import java.util.List;

public class BannerBean {

    private int errorCode;
    private String errorMsg;
    private List<BannerItemData> data;

    public List<BannerItemData> getData() {
        return data;
    }

    public void setData(List<BannerItemData> data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}
