package com.ukrinmash.ukraine.domain;

/**
 * Created by admssa on 14.12.2015.
 */
public class VoteStatus {

    private String status;
    private String msg;

    public VoteStatus() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
