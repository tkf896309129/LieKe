package com.comexample.lieke.myapplication.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/6/14.
 */
public class MainOrderBean implements Serializable {
    private String ErrMsg;
    private MainOrderReobjBean ReObj;
    private int Success;

    public String getErrMsg() {
        return ErrMsg;
    }

    public void setErrMsg(String errMsg) {
        ErrMsg = errMsg;
    }

    public MainOrderReobjBean getReObj() {
        return ReObj;
    }

    public void setReObj(MainOrderReobjBean reObj) {
        ReObj = reObj;
    }

    public int getSuccess() {
        return Success;
    }

    public void setSuccess(int success) {
        Success = success;
    }
}
