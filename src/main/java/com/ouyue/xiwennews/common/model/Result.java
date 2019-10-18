package com.ouyue.xiwennews.common.model;


import com.ouyue.xiwennews.common.enums.ServiceCodeEnum;

import java.io.Serializable;

public class Result<T> implements Serializable {

    private boolean success;

    private int errCode;

    private T data;

    private String msg;

    public static Result success(){
        Result br = new Result();
        br.setSuccess(true);
        br.setErrCode(ServiceCodeEnum.SUCCESS.getCode());
        br.setMsg(ServiceCodeEnum.SUCCESS.getRemark());
        return br;
    }

    public static Result error(int code, String msg){
        Result temp = new Result<>();
        temp.setData(null);
        temp.setErrCode(code);
        temp.setSuccess(false);
        temp.setMsg(msg);
        return temp;
    }

    public static Result error(ServiceCodeEnum serviceCodeEnum){
        Result temp = new Result<>();
        temp.setData(null);
        temp.setErrCode(serviceCodeEnum.getCode());
        temp.setSuccess(false);
        temp.setMsg(serviceCodeEnum.getRemark());
        return temp;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", errCode=" + errCode +
                ", data=" + data +
                '}';
    }
}
