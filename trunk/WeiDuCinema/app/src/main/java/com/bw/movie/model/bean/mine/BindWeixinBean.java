package com.bw.movie.model.bean.mine;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-27
 * INTRODUCE：$
 */
public class BindWeixinBean {


    /**
     * message : 绑定成功
     * status : 0000
     * bindStatus : 1
     */

    private String message;
    private String status;
    private int bindStatus;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getBindStatus() {
        return bindStatus;
    }

    public void setBindStatus(int bindStatus) {
        this.bindStatus = bindStatus;
    }
}
