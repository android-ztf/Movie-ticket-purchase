package com.bw.movie.model.bean.pay_movie;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-16
 * INTRODUCE：$
 * 订票下单
 */
public class BuyMovieTicketBean {
    /**
     * orderId : 20180807084055347
     * message : 下单成功
     * status : 0000
     */

    private String orderId;
    private String message;
    private String status;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

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
}
