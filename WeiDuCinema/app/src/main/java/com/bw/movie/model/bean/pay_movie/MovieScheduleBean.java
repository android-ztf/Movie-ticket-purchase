package com.bw.movie.model.bean.pay_movie;

import java.util.List;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-16
 * INTRODUCE：$
 * 根据电影ID和影院ID查询电影排期列表
 */
public class MovieScheduleBean {


    /**
     * result : [{"beginTime":"13:20:00","endTime":"15:02:00","fare":0.01,"hallId":102,"id":576,"screeningHall":"杜比厅"},{"beginTime":"20:50:00","endTime":"22:10:00","fare":0.01,"hallId":106,"id":720,"screeningHall":"9号厅"},{"beginTime":"20:00:00","endTime":"21:48:00","fare":0.01,"hallId":104,"id":724,"screeningHall":"3号厅"},{"beginTime":"22:00:00","endTime":"23:55:00","fare":0.01,"hallId":102,"id":728,"screeningHall":"杜比厅"},{"beginTime":"17:00:00","endTime":"23:55:00","fare":0.01,"hallId":106,"id":732,"screeningHall":"9号厅"},{"beginTime":"19:00:00","endTime":"20:53:00","fare":0.01,"hallId":104,"id":736,"screeningHall":"3号厅"}]
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
         * beginTime : 13:20:00
         * endTime : 15:02:00
         * fare : 0.01
         * hallId : 102
         * id : 576
         * screeningHall : 杜比厅
         */

        private String beginTime;
        private String endTime;
        private double fare;
        private int hallId;
        private int id;
        private String screeningHall;
        private boolean checked;

        public boolean isChecked() {
            return checked;
        }

        public void setChecked(boolean checked) {
            this.checked = checked;
        }

        public String getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(String beginTime) {
            this.beginTime = beginTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public double getFare() {
            return fare;
        }

        public void setFare(double fare) {
            this.fare = fare;
        }

        public int getHallId() {
            return hallId;
        }

        public void setHallId(int hallId) {
            this.hallId = hallId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getScreeningHall() {
            return screeningHall;
        }

        public void setScreeningHall(String screeningHall) {
            this.screeningHall = screeningHall;
        }
    }
}
