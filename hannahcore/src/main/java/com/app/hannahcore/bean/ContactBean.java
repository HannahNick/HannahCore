package com.app.hannahcore.bean;

/**
 * Created by Administrator on 2017/8/8.
 * 手机联系人
 */
public class ContactBean {
    private String name;   //显示的数据
    private String sortLetters;  //显示数据拼音的首字母
    private String phone;//图片位置

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSortLetters() {
        return sortLetters;
    }
    public void setSortLetters(String sortLetters) {
        this.sortLetters = sortLetters;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
