package com.app.androidutildemo.mvp.modle;

/**
 * Created by Nick on 2019-09-24.
 */
public class AppUpdateBean {
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
