package com.bw.movie.model.bean.mine;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-27
 * INTRODUCE：$
 */
public class ExchangeCodeBean {


    /**
     * message : 绑定成功
     * status : 0000
     * bindStatus : 1
     */

    private String message;
    private String status;
    private ResultBean result;

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

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private String exchangeCode;

        public String getExchangeCode() {
            return exchangeCode;
        }

        public void setExchangeCode(String exchangeCode) {
            this.exchangeCode = exchangeCode;
        }
    }

}
