package com.bw.movie.model.bean.cinema_bean;

import java.util.List;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-5
 * INTRODUCE：$
 */
public class CinemaCommentBean {


    /**
     * result : [{"commentContent":"是的","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2020-07-01/20200701100701.jpg","commentId":589,"commentTime":1590672668000,"commentUserId":14025,"commentUserName":"缪斯123","greatHeadPic":[],"greatNum":1,"hotComment":0,"isGreat":0},{"commentContent":"12","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/bwjy.jpg","commentId":578,"commentTime":1586674241000,"commentUserId":13919,"commentUserName":"甜菜(心里美)","greatHeadPic":[],"greatNum":1,"hotComment":0,"isGreat":0},{"commentContent":"叭叭叭","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/bwjy.jpg","commentId":570,"commentTime":1586495726000,"commentUserId":13831,"commentUserName":"丁美丽","greatHeadPic":[],"greatNum":2,"hotComment":0,"isGreat":0},{"commentContent":"qqq","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2020-07-03/20200703212929.jpg","commentId":550,"commentTime":1586155593000,"commentUserId":13692,"commentUserName":"���С�ɰ�","greatHeadPic":[],"greatNum":1,"hotComment":0,"isGreat":0},{"commentContent":"好看的一批","commentHeadPic":"http://thirdwx.qlogo.cn/mmopen/vi_32/MHQjS55Skf8ppoO4RVAKmpp4Nka6e5dcqUX9OIHx9YZLOEUfTTI0HAFsCwjl3B67R0jX1BLCyWvYd7tpMPdGKg/132","commentId":462,"commentTime":1586091599000,"commentUserId":13869,"commentUserName":"DJ慢羊羊_T8k","greatHeadPic":[],"greatNum":1,"hotComment":0,"isGreat":0},{"commentContent":"qqqq","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2020-04-11/20200411180754.jpg","commentId":446,"commentTime":1585558031000,"commentUserId":13760,"commentUserName":"王黎杨","greatHeadPic":[],"greatNum":0,"hotComment":0,"isGreat":0}]
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
         * commentContent : 是的
         * commentHeadPic : http://mobile.bwstudent.com/images/movie/head_pic/2020-07-01/20200701100701.jpg
         * commentId : 589
         * commentTime : 1590672668000
         * commentUserId : 14025
         * commentUserName : 缪斯123
         * greatHeadPic : []
         * greatNum : 1
         * hotComment : 0
         * isGreat : 0
         */

        private String commentContent;
        private String commentHeadPic;
        private int commentId;
        private long commentTime;
        private int commentUserId;
        private String commentUserName;
        private int greatNum;
        private int hotComment;
        private int isGreat;
        private List<?> greatHeadPic;

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

        public int getHotComment() {
            return hotComment;
        }

        public void setHotComment(int hotComment) {
            this.hotComment = hotComment;
        }

        public int getIsGreat() {
            return isGreat;
        }

        public void setIsGreat(int isGreat) {
            this.isGreat = isGreat;
        }

        public List<?> getGreatHeadPic() {
            return greatHeadPic;
        }

        public void setGreatHeadPic(List<?> greatHeadPic) {
            this.greatHeadPic = greatHeadPic;
        }
    }
}
