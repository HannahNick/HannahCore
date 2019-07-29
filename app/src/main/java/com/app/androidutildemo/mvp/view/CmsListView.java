package com.app.androidutildemo.mvp.view;

import com.app.androidutildemo.bean.TmsWrapperBean;

import java.util.List;

/**
 * Created by Nick on 2019-05-08.
 */
public interface CmsListView {
    void getHomeData(List<TmsWrapperBean> data);
}
