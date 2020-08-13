package com.bw.movie.model.bean.mine;

import java.util.List;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-27
 * INTRODUCE：$
 */
public class SeenCommentBean {


    /**
     * message : 绑定成功
     * status : 0000
     * bindStatus : 1
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
        private int movieId;
        private int cinameId;
        private String movieName;
        private String cinameName;
        private String movieCommentContent;
        private String cinemaCommentContent;
        private double score;

        public int getMovieId() {
            return movieId;
        }

        public void setMovieId(int movieId) {
            this.movieId = movieId;
        }

        public int getCinameId() {
            return cinameId;
        }

        public void setCinameId(int cinameId) {
            this.cinameId = cinameId;
        }

        public String getMovieName() {
            return movieName;
        }

        public void setMovieName(String movieName) {
            this.movieName = movieName;
        }

        public String getCinameName() {
            return cinameName;
        }

        public void setCinameName(String cinameName) {
            this.cinameName = cinameName;
        }

        public String getMovieCommentContent() {
            return movieCommentContent;
        }

        public void setMovieCommentContent(String movieCommentContent) {
            this.movieCommentContent = movieCommentContent;
        }

        public String getCinemaCommentContent() {
            return cinemaCommentContent;
        }

        public void setCinemaCommentContent(String cinemaCommentContent) {
            this.cinemaCommentContent = cinemaCommentContent;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }
    }
    }
