package com.bw.movie.model.bean.cinema_bean;

/**
 * AUTHOR: MR.Zhang
 * DATE:2020-7-3
 * INTRODUCE：$
 */
public class CinemaInfoBean {


    /**
     * result : {"address":"上地南口华联商厦4F","businessHoursContent":"星期一 至 星期日   早09:30:00 - 晚24:00:00","commentTotal":0,"distance":0,"followCinema":2,"id":18,"label":"儿童优惠,3D眼镜,4K厅","logo":"http://mobile.bwstudent.com/images/movie/logo/ctjh.jpg","name":"橙天嘉禾影城北京上地店","phone":"010-62667799","vehicleRoute":"365；393；432；656；664；681；717；963；982；运通105；运通118；运通205;上地南口站"}
     * message : 查询成功
     * status : 0000
     * 影院详情bean类
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
         * address : 上地南口华联商厦4F
         * businessHoursContent : 星期一 至 星期日   早09:30:00 - 晚24:00:00
         * commentTotal : 0
         * distance : 0
         * followCinema : 2
         * id : 18
         * label : 儿童优惠,3D眼镜,4K厅
         * logo : http://mobile.bwstudent.com/images/movie/logo/ctjh.jpg
         * name : 橙天嘉禾影城北京上地店
         * phone : 010-62667799
         * vehicleRoute : 365；393；432；656；664；681；717；963；982；运通105；运通118；运通205;上地南口站
         */

        private String address;
        private String businessHoursContent;
        private int commentTotal;
        private int distance;
        private int followCinema;
        private int id;
        private String label;
        private String logo;
        private String name;
        private String phone;
        private String vehicleRoute;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getBusinessHoursContent() {
            return businessHoursContent;
        }

        public void setBusinessHoursContent(String businessHoursContent) {
            this.businessHoursContent = businessHoursContent;
        }

        public int getCommentTotal() {
            return commentTotal;
        }

        public void setCommentTotal(int commentTotal) {
            this.commentTotal = commentTotal;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public int getFollowCinema() {
            return followCinema;
        }

        public void setFollowCinema(int followCinema) {
            this.followCinema = followCinema;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
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

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getVehicleRoute() {
            return vehicleRoute;
        }

        public void setVehicleRoute(String vehicleRoute) {
            this.vehicleRoute = vehicleRoute;
        }
    }
}
