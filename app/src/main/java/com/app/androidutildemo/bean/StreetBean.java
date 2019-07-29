package com.app.androidutildemo.bean;

import java.util.List;

/**
 * Created by Nick on 2019-04-24.
 */
public class StreetBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {

        private String id;
        private String name;
        private String parentid;
        private List<SubBean> sub;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getParentid() {
            return parentid;
        }

        public void setParentid(String parentid) {
            this.parentid = parentid;
        }

        public List<SubBean> getSub() {
            return sub;
        }

        public void setSub(List<SubBean> sub) {
            this.sub = sub;
        }

        public static class SubBean{
            /**
             * id : 10010
             * name : 园岭街道
             * parentid : 1001
             * sub : []
             */

            private String id;
            private String name;
            private String parentid;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getParentid() {
                return parentid;
            }

            public void setParentid(String parentid) {
                this.parentid = parentid;
            }

        }
    }
}
