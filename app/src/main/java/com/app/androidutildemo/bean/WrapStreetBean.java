package com.app.androidutildemo.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by Nick on 2019-04-24.
 */
public class WrapStreetBean implements MultiItemEntity {

    private String name;
    private int type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setType(int type) {
        this.type = type;
    }

    @Override
    public int getItemType() {
        return type;
    }
}
