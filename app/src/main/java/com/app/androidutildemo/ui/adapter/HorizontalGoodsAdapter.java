package com.app.androidutildemo.ui.adapter;

import android.support.annotation.Nullable;

import com.app.androidutildemo.R;
import com.app.androidutildemo.mvp.modle.TmsDataBean.ChildrenBean.ConfigBean.GroupsBean;
import com.app.hannahcore.manager.image.GlideManager;
import com.app.hannahcore.utils.ZeroCancelUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Nick on 2019-05-13.
 */
public class HorizontalGoodsAdapter extends BaseQuickAdapter<GroupsBean, BaseViewHolder> {


    public HorizontalGoodsAdapter(@Nullable List<GroupsBean> data) {
        super(R.layout.item_home_good_hor, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GroupsBean item) {
        GlideManager.getInstance().loadUrl(mContext,helper.getView(R.id.iv_goods_img),item.getImgUrl());
        helper.setText(R.id.tv_goods_name,item.getSkuName())
                .setText(R.id.tv_goods_discount_price, ZeroCancelUtil.getInstance().formatDouble(item.getPrice()))
                .setGone(R.id.tv_goods_price,false)
                .setGone(R.id.tv_rmb_common,false)
                .setText(R.id.tv_good_spec,item.getSkuName());
    }
}
