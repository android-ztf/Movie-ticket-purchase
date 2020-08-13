package com.bw.movie.model.bean.cinema_bean;

import java.util.List;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-6
 * INTRODUCE：$
 */
public class FindDateBean {

    /**
     * result : ["07-06","07-07","07-08","07-09","07-10","07-11","07-12"]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<String> result;

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

    public List<String> getResult() {
        return result;
    }

    public void setResult(List<String> result) {
        this.result = result;
    }
}
