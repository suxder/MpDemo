package com.jac.mpdemo.entity;

public class JSONResultBatch {
    private int code;
    private String msg;
    private int successCount;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(int successCount) {
        this.successCount = successCount;
    }

    @Override
    public String toString() {
        return "JSONResultBatch{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", successCount=" + successCount +
                '}';
    }
}
