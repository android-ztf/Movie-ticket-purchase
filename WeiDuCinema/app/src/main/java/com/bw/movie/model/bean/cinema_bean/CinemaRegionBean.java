package com.bw.movie.model.bean.cinema_bean;

import java.util.List;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-5
 * INTRODUCE：$
 */
public class CinemaRegionBean {


    /**
     * result : [{"id":1,"name":"青春光线电影院"},{"id":2,"name":"大观楼电影院"},{"id":3,"name":"首都电影院"},{"id":4,"name":"魔影国际影城"}]
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
         * id : 1
         * name : 青春光线电影院
         */

        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
