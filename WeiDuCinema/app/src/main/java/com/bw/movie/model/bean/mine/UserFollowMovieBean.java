package com.bw.movie.model.bean.mine;

import java.util.List;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-23
 * INTRODUCE：$
 */
public class UserFollowMovieBean {


    /**
     * result : [{"director":"姜文","imageUrl":"http://mobile.bwstudent.com/images/movie/stills/xbyz/xbyz1.jpg","movieId":5,"name":"邪不压正","score":8.8,"starring":"姜文,彭于晏,廖凡,许晴,周韵"}]
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
         * director : 姜文
         * imageUrl : http://mobile.bwstudent.com/images/movie/stills/xbyz/xbyz1.jpg
         * movieId : 5
         * name : 邪不压正
         * score : 8.8
         * starring : 姜文,彭于晏,廖凡,许晴,周韵
         */

        private String director;
        private String imageUrl;
        private int movieId;
        private String name;
        private double score;
        private String starring;

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public int getMovieId() {
            return movieId;
        }

        public void setMovieId(int movieId) {
            this.movieId = movieId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public String getStarring() {
            return starring;
        }

        public void setStarring(String starring) {
            this.starring = starring;
        }
    }
}
