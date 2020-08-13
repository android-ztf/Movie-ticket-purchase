package com.bw.movie.model.bean;

import java.util.List;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-6-29
 * INTRODUCE：$
 */
public class DetailMovieBean {

    /**
     * result : {"commentNum":78,"duration":"135分钟","imageUrl":"http://mobile.bwstudent.com/images/movie/stills/sndn/sndn1.jpg","movieActor":[{"name":"周冬雨","photo":"http://mobile.bwstudent.com/images/movie/actor/sndn/zhoudongyu.jpg","role":"陈念"},{"name":"易烊千玺","photo":"http://mobile.bwstudent.com/images/movie/actor/sndn/yiyangqianxi.jpg","role":"小北"},{"name":"尹昉","photo":"http://mobile.bwstudent.com/images/movie/actor/sndn/yinfang.jpg","role":"郑易"},{"name":"吴越","photo":"http://mobile.bwstudent.com/images/movie/actor/sndn/wuyue.jpg","role":"周蕾"},{"name":"周也","photo":"http://mobile.bwstudent.com/images/movie/actor/sndn/zhouye.jpg","role":"魏莱"},{"name":"张耀","photo":"http://mobile.bwstudent.com/images/movie/actor/sndn/zhangyao.jpg","role":"李想"}],"movieDirector":[{"name":"曾国祥","photo":"http://mobile.bwstudent.com/images/movie/director/sndn/1.jpg"}],"movieId":22,"movieType":"","name":"少年的你","placeOrigin":"中国大陆","posterList":["http://mobile.bwstudent.com/images/movie/stills/sndn/sndn6.jpg","http://mobile.bwstudent.com/images/movie/stills/sndn/sndn5.jpg","http://mobile.bwstudent.com/images/movie/stills/sndn/sndn4.jpg","http://mobile.bwstudent.com/images/movie/stills/sndn/sndn3.jpg","http://mobile.bwstudent.com/images/movie/stills/sndn/sndn2.jpg","http://mobile.bwstudent.com/images/movie/stills/sndn/sndn1.jpg"],"releaseTime":1571932800000,"score":9.5,"shortFilmList":[{"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/sndn/sndn4.jpg","videoUrl":"http://mobile.bwstudent.com/video/movie/sndn/sndn1.mp4"},{"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/sndn/sndn5.jpg","videoUrl":"http://mobile.bwstudent.com/video/movie/sndn/sndn2.mp4"},{"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/sndn/sndn3.jpg","videoUrl":"http://mobile.bwstudent.com/video/movie/sndn/sndn3.mp4"}],"summary":"一场高考前夕的校园意外，改变了两个少年的命运。 陈念（周冬雨 饰）性格内向，是学校里的优等生，努力复习、考上好大学是高三的她唯一的念头。同班同学的意外坠楼牵扯出一连串不为人知的故事，陈念也被一点点卷入其中\u2026\u2026在她最孤独的时刻，一个叫\u201c小北\u201d（易烊千玺 饰）的少年闯入了她的世界\u2026\u2026大多数人的18岁都是明媚、快乐的，而他们却在18岁这个夏天提前尝到了成人世界的漠然。一场秘而不宣的\u201c战斗\u201d正在上演，他们将一起守护少年的尊严。","whetherFollow":2}
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
         * commentNum : 78
         * duration : 135分钟
         * imageUrl : http://mobile.bwstudent.com/images/movie/stills/sndn/sndn1.jpg
         * movieActor : [{"name":"周冬雨","photo":"http://mobile.bwstudent.com/images/movie/actor/sndn/zhoudongyu.jpg","role":"陈念"},{"name":"易烊千玺","photo":"http://mobile.bwstudent.com/images/movie/actor/sndn/yiyangqianxi.jpg","role":"小北"},{"name":"尹昉","photo":"http://mobile.bwstudent.com/images/movie/actor/sndn/yinfang.jpg","role":"郑易"},{"name":"吴越","photo":"http://mobile.bwstudent.com/images/movie/actor/sndn/wuyue.jpg","role":"周蕾"},{"name":"周也","photo":"http://mobile.bwstudent.com/images/movie/actor/sndn/zhouye.jpg","role":"魏莱"},{"name":"张耀","photo":"http://mobile.bwstudent.com/images/movie/actor/sndn/zhangyao.jpg","role":"李想"}]
         * movieDirector : [{"name":"曾国祥","photo":"http://mobile.bwstudent.com/images/movie/director/sndn/1.jpg"}]
         * movieId : 22
         * movieType :
         * name : 少年的你
         * placeOrigin : 中国大陆
         * posterList : ["http://mobile.bwstudent.com/images/movie/stills/sndn/sndn6.jpg","http://mobile.bwstudent.com/images/movie/stills/sndn/sndn5.jpg","http://mobile.bwstudent.com/images/movie/stills/sndn/sndn4.jpg","http://mobile.bwstudent.com/images/movie/stills/sndn/sndn3.jpg","http://mobile.bwstudent.com/images/movie/stills/sndn/sndn2.jpg","http://mobile.bwstudent.com/images/movie/stills/sndn/sndn1.jpg"]
         * releaseTime : 1571932800000
         * score : 9.5
         * shortFilmList : [{"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/sndn/sndn4.jpg","videoUrl":"http://mobile.bwstudent.com/video/movie/sndn/sndn1.mp4"},{"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/sndn/sndn5.jpg","videoUrl":"http://mobile.bwstudent.com/video/movie/sndn/sndn2.mp4"},{"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/sndn/sndn3.jpg","videoUrl":"http://mobile.bwstudent.com/video/movie/sndn/sndn3.mp4"}]
         * summary : 一场高考前夕的校园意外，改变了两个少年的命运。 陈念（周冬雨 饰）性格内向，是学校里的优等生，努力复习、考上好大学是高三的她唯一的念头。同班同学的意外坠楼牵扯出一连串不为人知的故事，陈念也被一点点卷入其中……在她最孤独的时刻，一个叫“小北”（易烊千玺 饰）的少年闯入了她的世界……大多数人的18岁都是明媚、快乐的，而他们却在18岁这个夏天提前尝到了成人世界的漠然。一场秘而不宣的“战斗”正在上演，他们将一起守护少年的尊严。
         * whetherFollow : 2
         */

        private int commentNum;
        private String duration;
        private String imageUrl;
        private int movieId;
        private String movieType;
        private String name;
        private String placeOrigin;
        private long releaseTime;
        private double score;
        private String summary;
        private int whetherFollow;
        private List<MovieActorBean> movieActor;
        private List<MovieDirectorBean> movieDirector;
        private List<String> posterList;
        private List<ShortFilmListBean> shortFilmList;

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
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

        public String getMovieType() {
            return movieType;
        }

        public void setMovieType(String movieType) {
            this.movieType = movieType;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPlaceOrigin() {
            return placeOrigin;
        }

        public void setPlaceOrigin(String placeOrigin) {
            this.placeOrigin = placeOrigin;
        }

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public int getWhetherFollow() {
            return whetherFollow;
        }

        public void setWhetherFollow(int whetherFollow) {
            this.whetherFollow = whetherFollow;
        }

        public List<MovieActorBean> getMovieActor() {
            return movieActor;
        }

        public void setMovieActor(List<MovieActorBean> movieActor) {
            this.movieActor = movieActor;
        }

        public List<MovieDirectorBean> getMovieDirector() {
            return movieDirector;
        }

        public void setMovieDirector(List<MovieDirectorBean> movieDirector) {
            this.movieDirector = movieDirector;
        }

        public List<String> getPosterList() {
            return posterList;
        }

        public void setPosterList(List<String> posterList) {
            this.posterList = posterList;
        }

        public List<ShortFilmListBean> getShortFilmList() {
            return shortFilmList;
        }

        public void setShortFilmList(List<ShortFilmListBean> shortFilmList) {
            this.shortFilmList = shortFilmList;
        }

        public static class MovieActorBean {
            /**
             * name : 周冬雨
             * photo : http://mobile.bwstudent.com/images/movie/actor/sndn/zhoudongyu.jpg
             * role : 陈念
             */

            private String name;
            private String photo;
            private String role;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }
        }

        public static class MovieDirectorBean {
            /**
             * name : 曾国祥
             * photo : http://mobile.bwstudent.com/images/movie/director/sndn/1.jpg
             */

            private String name;
            private String photo;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }
        }

        public static class ShortFilmListBean {
            /**
             * imageUrl : http://mobile.bwstudent.com/images/movie/stills/sndn/sndn4.jpg
             * videoUrl : http://mobile.bwstudent.com/video/movie/sndn/sndn1.mp4
             */

            private String imageUrl;
            private String videoUrl;

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getVideoUrl() {
                return videoUrl;
            }

            public void setVideoUrl(String videoUrl) {
                this.videoUrl = videoUrl;
            }
        }
    }
}
