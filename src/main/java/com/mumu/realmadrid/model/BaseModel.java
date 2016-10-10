package com.mumu.realmadrid.model;

/**
 * Created by 7mu on 2016/6/30.
 * 基础model
 */
public class BaseModel {
    private int resultType;
    private int resultCode;
    private String detail;
    private Object data;

    public int getResultType() {
        return resultType;
    }

    public void setResultType(int resultType) {
        this.resultType = resultType;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
