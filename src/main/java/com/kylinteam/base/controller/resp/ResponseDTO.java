package com.kylinteam.base.controller.resp;

import java.io.Serializable;

public class ResponseDTO<T> implements Serializable {

    private static final long serialVersionUID = 1765201206338797986L;

    private String result;
    private String msg;
    private T data;

    public ResponseDTO() {
    }

    public ResponseDTO(String result) {
        this.result = result;
    }

    public ResponseDTO(String result, String msg) {
        this.result = result;
        this.msg = msg;
    }

    public ResponseDTO(String result, String msg, T data) {
        this.result = result;
        this.msg = msg;
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
