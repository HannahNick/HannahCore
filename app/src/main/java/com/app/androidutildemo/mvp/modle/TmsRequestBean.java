package com.app.androidutildemo.mvp.modle;

import java.util.List;

/**
 * Created by Nick on 2018/11/19.
 */
public class TmsRequestBean {

    private DataBean data;
    private String errorCode;
    private String errorMsg;
    private String repeatAct;
    private boolean succeed;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getRepeatAct() {
        return repeatAct;
    }

    public void setRepeatAct(String repeatAct) {
        this.repeatAct = repeatAct;
    }

    public boolean isSucceed() {
        return succeed;
    }

    public void setSucceed(boolean succeed) {
        this.succeed = succeed;
    }

    public static class DataBean {

        private List<PageJsonDataListBean> pageJsonDataList;


        public List<PageJsonDataListBean> getPageJsonDataList() {
            return pageJsonDataList;
        }

        public void setPageJsonDataList(List<PageJsonDataListBean> pageJsonDataList) {
            this.pageJsonDataList = pageJsonDataList;
        }

        public static class PageJsonDataListBean {

            private String jsonData;


            public String getJsonData() {
                return jsonData;
            }

            public void setJsonData(String jsonData) {
                this.jsonData = jsonData;
            }

        }
    }
}
