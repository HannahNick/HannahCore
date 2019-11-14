package com.app.androidutildemo.ui.adapter;

import com.app.androidutildemo.R;
import com.app.androidutildemo.mvp.modle.TmsPoolListBean.DataBeanX.DataBean.RowsBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by Nick on 2019-04-29.
 */
public class GoodsListAdapter extends BaseQuickAdapter<RowsBean, BaseViewHolder> {

    public GoodsListAdapter() {
        super(R.layout.item_location);
    }

    @Override
    protected void convert(BaseViewHolder helper, RowsBean item) {
        helper.setText(R.id.tv_location,item.getGoodsName());
    }
}
