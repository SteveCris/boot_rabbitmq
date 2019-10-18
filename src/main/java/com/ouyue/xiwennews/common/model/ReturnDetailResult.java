package com.ouyue.xiwennews.common.model;

import java.io.Serializable;

public class ReturnDetailResult implements Serializable {

    private boolean isSuccess;
    private String errMsg;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return "ReturnDetailResult{" +
                "isSuccess=" + isSuccess +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}
