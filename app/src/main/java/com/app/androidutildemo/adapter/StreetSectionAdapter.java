package com.app.androidutildemo.adapter;

import com.app.androidutildemo.R;
import com.app.androidutildemo.bean.StreetSectionBean;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Nick on 2019-04-24.
 */
public class StreetSectionAdapter extends BaseSectionQuickAdapter<StreetSectionBean, BaseViewHolder> {


    public StreetSectionAdapter(int layoutResId, int sectionHeadResId, List<StreetSectionBean> data) {
        super(layoutResId, sectionHeadResId, data);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, StreetSectionBean item) {
        helper.setText(R.id.tv_location,item.getDataBean().getName());
    }

    @Override
    protected void convert(BaseViewHolder helper, StreetSectionBean item) {
        helper.setText(R.id.tv_street_location,item.t.getName());
    }
}
