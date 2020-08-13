package com.bw.movie.model.bean.mine;

import java.util.List;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-23
 * INTRODUCE：$
 */
public class UserCommentCinema {

    /**
     * result : [{"address":"中关村广场购物中心津乐汇三层（鼎好一期西侧）","cinemaId":12,"cinemaName":"美嘉欢乐影城中关村店","commentTime":1595504410000,"distance":12229423,"logo":"http://mobile.bwstudent.com/images/movie/logo/mjhlyc.jpg","myCommentContent":"好"}]
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
         * address : 中关村广场购物中心津乐汇三层（鼎好一期西侧）
         * cinemaId : 12
         * cinemaName : 美嘉欢乐影城中关村店
         * commentTime : 1595504410000
         * distance : 12229423
         * logo : http://mobile.bwstudent.com/images/movie/logo/mjhlyc.jpg
         * myCommentContent : 好
         */

        private String address;
        private int cinemaId;
        private String cinemaName;
        private long commentTime;
        private int distance;
        private String logo;
        private String myCommentContent;

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

        public String getCinemaName() {
            return cinemaName;
        }

        public void setCinemaName(String cinemaName) {
            this.cinemaName = cinemaName;
        }

        public long getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(long commentTime) {
            this.commentTime = commentTime;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getMyCommentContent() {
            return myCommentContent;
        }

        public void setMyCommentContent(String myCommentContent) {
            this.myCommentContent = myCommentContent;
        }
    }
}
