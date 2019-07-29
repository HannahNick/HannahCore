package com.app.updateutil;

/**
 * Created by Nick on 2019-05-06.
 */
public class VersionBean {
    /**
     * data : {"reviewVersion":null,"haveNewVersion":true,"forceUpgrade":true,"deviceSystemVersion":"1.0.070","fileURL":"http://js.ap88.com/js/appsoft/android/js_v1.0.070_2017-12-27_dev.apk","title":"666","content":"666"}
     * errorCode :
     * errorMsg :
     * repeatAct : f3e61839-11a2-4317-b607-13f06b5d6b9e
     * succeed : true
     */

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
        /**
         * reviewVersion : null
         * haveNewVersion : true
         * forceUpgrade : true
         * deviceSystemVersion : 1.0.070
         * fileURL : http://js.ap88.com/js/appsoft/android/js_v1.0.070_2017-12-27_dev.apk
         * title : 666
         * content : 666
         */

        private Object reviewVersion;
        private boolean haveNewVersion;
        private boolean forceUpgrade;
        private String deviceSystemVersion;
        private String fileURL;
        private String title;
        private String content;

        public Object getReviewVersion() {
            return reviewVersion;
        }

        public void setReviewVersion(Object reviewVersion) {
            this.reviewVersion = reviewVersion;
        }

        public boolean isHaveNewVersion() {
            return haveNewVersion;
        }

        public void setHaveNewVersion(boolean haveNewVersion) {
            this.haveNewVersion = haveNewVersion;
        }

        public boolean isForceUpgrade() {
            return forceUpgrade;
        }

        public void setForceUpgrade(boolean forceUpgrade) {
            this.forceUpgrade = forceUpgrade;
        }

        public String getDeviceSystemVersion() {
            return deviceSystemVersion;
        }

        public void setDeviceSystemVersion(String deviceSystemVersion) {
            this.deviceSystemVersion = deviceSystemVersion;
        }

        public String getFileURL() {
            return fileURL;
        }

        public void setFileURL(String fileURL) {
            this.fileURL = fileURL;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
