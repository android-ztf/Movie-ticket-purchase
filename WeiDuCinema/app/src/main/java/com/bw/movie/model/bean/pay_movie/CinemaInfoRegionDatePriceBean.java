package com.bw.movie.model.bean.pay_movie;

import java.util.List;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-16
 * INTRODUCE：$
 */
public class CinemaInfoRegionDatePriceBean {

    /**
     * result : [{"address":"十八里店西直河商业中心东融国际影城","cinemaId":21,"logo":"http://172.17.8.100/images/movie/logo/drgjyc.jpg","name":"东融国际影城西直河店","price":0},{"address":"新街口外大街25号","cinemaId":14,"logo":"http://172.17.8.100/images/movie/logo/zygj.jpg","name":"中影国际影城北京小西天店","price":0},{"address":"黄平路19号院龙旗购物中心3层","cinemaId":17,"logo":"http://172.17.8.100/images/movie/logo/blgj.jpg","name":"保利国际影城北京龙旗广场店","price":0}]
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
         * address : 十八里店西直河商业中心东融国际影城
         * cinemaId : 21
         * logo : http://172.17.8.100/images/movie/logo/drgjyc.jpg
         * name : 东融国际影城西直河店
         * price : 0
         */

        private String address;
        private int cinemaId;
        private String logo;
        private String name;
        private int price;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getCinemaId() {
            return cinemaId;
        }

        public void setCinemaId(int cinemaId) {
            this.cinemaId = cinemaId;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }
}
