package com.bw.movie.model.bean.detail_movie;

import java.util.List;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-20
 * INTRODUCE：$
 */
public class MovieCommentBean {
    /**
     * result : [{"commentContent":"奥利给","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2020-06-03/20200603153426.jpg","commentId":15279,"commentTime":1592228881000,"commentUserId":13976,"commentUserName":"yuanyuhan","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.5},{"commentContent":"�ÿ�","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/bwjy.jpg","commentId":12230,"commentTime":1588931683000,"commentUserId":13844,"commentUserName":"元","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.5},{"commentContent":"asdf","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/bwjy.jpg","commentId":10707,"commentTime":1588856902000,"commentUserId":13784,"commentUserName":"范红磊","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.5},{"commentContent":"����","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2020-04-23/20200423163913.png","commentId":7834,"commentTime":1586572649000,"commentUserId":13913,"commentUserName":"��dsd��","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.5},{"commentContent":"15","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2020-07-09/20200709163810.png","commentId":6776,"commentTime":1586479937000,"commentUserId":13692,"commentUserName":"���С�ɰ�","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":11}]
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
         * commentContent : 奥利给
         * commentHeadPic : http://mobile.bwstudent.com/images/movie/head_pic/2020-06-03/20200603153426.jpg
         * commentId : 15279
         * commentTime : 1592228881000
         * commentUserId : 13976
         * commentUserName : yuanyuhan
         * greatNum : 0
         * isGreat : 0
         * replyHeadPic : []
         * replyNum : 0
         * score : 4.5
         */

        private String commentContent;
        private String commentHeadPic;
        private int commentId;
        private long commentTime;
        private int commentUserId;
        private String commentUserName;
        private int greatNum;
        private int isGreat;
        private int replyNum;
        private double score;
        private List<?> replyHeadPic;

        public String getCommentContent() {
            return commentContent;
        }

        public void setCommentContent(String commentContent) {
            this.commentContent = commentContent;
        }

        public String getCommentHeadPic() {
            return commentHeadPic;
        }

        public void setCommentHeadPic(String commentHeadPic) {
            this.commentHeadPic = commentHeadPic;
        }

        public int getCommentId() {
            return commentId;
        }

        public void setCommentId(int commentId) {
            this.commentId = commentId;
        }

        public long getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(long commentTime) {
            this.commentTime = commentTime;
        }

        public int getCommentUserId() {
            return commentUserId;
        }

        public void setCommentUserId(int commentUserId) {
            this.commentUserId = commentUserId;
        }

        public String getCommentUserName() {
            return commentUserName;
        }

        public void setCommentUserName(String commentUserName) {
            this.commentUserName = commentUserName;
        }

        public int getGreatNum() {
            return greatNum;
        }

        public void setGreatNum(int greatNum) {
            this.greatNum = greatNum;
        }

        public int getIsGreat() {
            return isGreat;
        }

        public void setIsGreat(int isGreat) {
            this.isGreat = isGreat;
        }

        public int getReplyNum() {
            return replyNum;
        }

        public void setReplyNum(int replyNum) {
            this.replyNum = replyNum;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public List<?> getReplyHeadPic() {
            return replyHeadPic;
        }

        public void setReplyHeadPic(List<?> replyHeadPic) {
            this.replyHeadPic = replyHeadPic;
        }
    }
}
