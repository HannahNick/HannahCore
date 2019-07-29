package com.app.androidutildemo.mvp.view;

import com.app.androidutildemo.mvp.modle.TmsPoolListBean.DataBeanX.DataBean.RowsBean;

import java.util.List;

/**
 * Created by Nick on 2019-04-29.
 */
public interface RefreshListView {
    void getData(List<RowsBean> bean);
}
