package com.kylinteam.base.controller.resp;

import java.io.Serializable;
import java.util.List;

public class ResponseListDTO<T> implements Serializable {

    private static final long serialVersionUID = -3808464482006475097L;

    private String result;
    private String msg;
    private List<T> data;

    public ResponseListDTO() {
    }

    public ResponseListDTO(String result) {
        this.result = result;
    }

    public ResponseListDTO(String result, String msg) {
        this.result = result;
        this.msg = msg;
    }

    public ResponseListDTO(String result, String msg, List<T> data) {
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

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
