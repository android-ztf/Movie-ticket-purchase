package com.bw.movie.model.bean.mine;

import java.util.List;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-27
 * INTRODUCE：$
 * 购票记录
 */
public class TicketRecordBean {


    /**
     * result : [{"amount":1,"createTime":1595229138000,"id":2852,"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/whwdzg/whwdzg1.jpg","movieName":"我和我的祖国","orderId":"20200720151218726","price":0.01},{"amount":1,"createTime":1595229723000,"id":2853,"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/whwdzg/whwdzg1.jpg","movieName":"我和我的祖国","orderId":"20200720152203383","price":0.01},{"amount":1,"createTime":1595329308000,"id":2855,"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/whwdzg/whwdzg1.jpg","movieName":"我和我的祖国","orderId":"20200721190148955","price":0.01},{"amount":1,"createTime":1595420337000,"id":2859,"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/whwdzg/whwdzg1.jpg","movieName":"我和我的祖国","orderId":"20200722201857280","price":0.01},{"amount":1,"createTime":1595467818000,"id":2861,"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/whwdzg/whwdzg1.jpg","movieName":"我和我的祖国","orderId":"20200723093018506","price":0.01},{"amount":1,"createTime":1595467854000,"id":2862,"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/whwdzg/whwdzg1.jpg","movieName":"我和我的祖国","orderId":"20200723093054341","price":0.01},{"amount":1,"createTime":1595468005000,"id":2863,"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/whwdzg/whwdzg1.jpg","movieName":"我和我的祖国","orderId":"20200723093325619","price":0.01},{"amount":1,"createTime":1595468866000,"id":2864,"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/whwdzg/whwdzg1.jpg","movieName":"我和我的祖国","orderId":"20200723094746124","price":0.01},{"amount":1,"createTime":1595473891000,"id":2865,"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/whwdzg/whwdzg1.jpg","movieName":"我和我的祖国","orderId":"20200723111131865","price":0.01},{"amount":2,"createTime":1595582179000,"id":2872,"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/whwdzg/whwdzg1.jpg","movieName":"我和我的祖国","orderId":"20200724171619618","price":0.01},{"amount":1,"createTime":1595596672000,"id":2899,"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/whwdzg/whwdzg1.jpg","movieName":"我和我的祖国","orderId":"20200724211752632","price":0.01},{"amount":1,"createTime":1595597620000,"id":2909,"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/whwdzg/whwdzg1.jpg","movieName":"我和我的祖国","orderId":"20200724213340008","price":0.01},{"amount":1,"createTime":1595806176000,"id":3017,"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/wbsys/wbsys1.jpg","movieName":"我不是药神","orderId":"20200727072936047","price":0.02},{"amount":1,"createTime":1595806196000,"id":3018,"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/wbsys/wbsys1.jpg","movieName":"我不是药神","orderId":"20200727072956049","price":0.02},{"amount":1,"createTime":1595806219000,"id":3019,"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/wbsys/wbsys1.jpg","movieName":"我不是药神","orderId":"20200727073019242","price":0.02},{"amount":1,"createTime":1595806269000,"id":3020,"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/ychx/ychx1.jpg","movieName":"一出好戏","orderId":"20200727073109002","price":0.06},{"amount":1,"createTime":1595806289000,"id":3021,"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/ychx/ychx1.jpg","movieName":"一出好戏","orderId":"20200727073129651","price":0.06},{"amount":1,"createTime":1595806311000,"id":3022,"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/ychx/ychx1.jpg","movieName":"一出好戏","orderId":"20200727073151411","price":0.06},{"amount":2,"createTime":1595806315000,"id":3023,"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/ychx/ychx1.jpg","movieName":"一出好戏","orderId":"20200727073155610","price":0.06},{"amount":1,"createTime":1595806323000,"id":3024,"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/ychx/ychx1.jpg","movieName":"一出好戏","orderId":"20200727073203567","price":0.06}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * amount : 1
         * createTime : 1595229138000
         * id : 2852
         * imageUrl : http://mobile.bwstudent.com/images/movie/stills/whwdzg/whwdzg1.jpg
         * movieName : 我和我的祖国
         * orderId : 20200720151218726
         * price : 0.01
         */

        private int amount;
        private long createTime;
        private int id;
        private String imageUrl;
        private String movieName;
        private String orderId;
        private double price;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
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
    }
}
