package com.bw.movie.model.bean.mine;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-27
 * INTRODUCE：$
 * 订单详情
 */
public class BuyTicketBean {

    /**
     * result : {"amount":1,"beginTime":"19:20:00","cinemaName":"大观楼电影院","createTime":1595836428000,"endTime":"21:18:00","id":3245,"movieName":"西虹市首富","orderId":"20200727155348378","price":0.07,"screeningHall":"9厅","seat":"10-10","status":1,"userId":14044}
     * message : 查询成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
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

    public static class ResultBean {
        /**
         * amount : 1
         * beginTime : 19:20:00
         * cinemaName : 大观楼电影院
         * createTime : 1595836428000
         * endTime : 21:18:00
         * id : 3245
         * movieName : 西虹市首富
         * orderId : 20200727155348378
         * price : 0.07
         * screeningHall : 9厅
         * seat : 10-10
         * status : 1
         * userId : 14044
         */

        private int amount;
        private String beginTime;
        private String cinemaName;
        private long createTime;
        private String endTime;
        private int id;
        private String movieName;
        private String orderId;
        private double price;
        private String screeningHall;
        private String seat;
        private int status;
        private int userId;
        private String imageUrl;

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(String beginTime) {
            this.beginTime = beginTime;
        }

        public String getCinemaName() {
            return cinemaName;
        }

        public void setCinemaName(String cinemaName) {
            this.cinemaName = cinemaName;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMovieName() {
            return movieName;
        }

        public void setMovieName(String movieName) {
            this.movieName = movieName;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getScreeningHall() {
            return screeningHall;
        }

        public void setScreeningHall(String screeningHall) {
            this.screeningHall = screeningHall;
        }

        public String getSeat() {
            return seat;
        }

        public void setSeat(String seat) {
            this.seat = seat;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }
}
