package com.bw.movie.model.bean.mine;

import java.util.List;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-23
 * INTRODUCE：$
 */
public class UserCommentMovie {


    /**
     * result : [{"commentTime":1595338759000,"director":"曾国祥","imageUrl":"http://mobile.bwstudent.com/images/movie/stills/sndn/sndn1.jpg","movieId":22,"movieName":"少年的你","movieScore":0,"myCommentContent":"维度电影好难啊","myCommentScore":8,"starring":"周冬雨,易烊千玺,张耀,周也,尹昉"},{"commentTime":1595338607000,"director":"克里斯托弗·麦奎里","imageUrl":"http://mobile.bwstudent.com/images/movie/stills/dzd6qmwj/dzd6qmwj1.jpg","movieId":16,"movieName":"碟中谍6：全面瓦解","movieScore":0,"myCommentContent":"厉害了","myCommentScore":8,"starring":"汤姆·克鲁斯,亨利·卡维尔,丽贝卡·弗格森,西蒙·佩吉"}]
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
         * commentTime : 1595338759000
         * director : 曾国祥
         * imageUrl : http://mobile.bwstudent.com/images/movie/stills/sndn/sndn1.jpg
         * movieId : 22
         * movieName : 少年的你
         * movieScore : 0
         * myCommentContent : 维度电影好难啊
         * myCommentScore : 8
         * starring : 周冬雨,易烊千玺,张耀,周也,尹昉
         */

        private long commentTime;
        private String director;
        private String imageUrl;
        private int movieId;
        private String movieName;
        private int movieScore;
        private String myCommentContent;
        private int myCommentScore;
        private String starring;

        public long getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(long commentTime) {
            this.commentTime = commentTime;
        }

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

        public String getMovieName() {
            return movieName;
        }

        public void setMovieName(String movieName) {
            this.movieName = movieName;
        }

        public int getMovieScore() {
            return movieScore;
        }

        public void setMovieScore(int movieScore) {
            this.movieScore = movieScore;
        }

        public String getMyCommentContent() {
            return myCommentContent;
        }

        public void setMyCommentContent(String myCommentContent) {
            this.myCommentContent = myCommentContent;
        }

        public int getMyCommentScore() {
            return myCommentScore;
        }

        public void setMyCommentScore(int myCommentScore) {
            this.myCommentScore = myCommentScore;
        }

        public String getStarring() {
            return starring;
        }

        public void setStarring(String starring) {
            this.starring = starring;
        }
    }
}
