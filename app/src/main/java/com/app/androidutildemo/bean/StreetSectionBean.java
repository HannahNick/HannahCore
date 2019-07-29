package com.app.androidutildemo.bean;

import com.app.androidutildemo.bean.StreetBean.DataBean;
import com.app.androidutildemo.bean.StreetBean.DataBean.SubBean;
import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * Created by Nick on 2019-04-25.
 */
public class StreetSectionBean extends SectionEntity<StreetBean.DataBean.SubBean> {

    private StreetBean.DataBean dataBean;

    public StreetSectionBean(boolean isHeader, String header,StreetBean.DataBean dataBean) {
        super(isHeader, header);
        this.dataBean = dataBean;
    }

    public StreetSectionBean(SubBean dataBean) {
        super(dataBean);
    }

    public DataBean getDataBean() {
        return dataBean;
    }

    public void setDataBean(DataBean dataBean) {
        this.dataBean = dataBean;
    }
}
