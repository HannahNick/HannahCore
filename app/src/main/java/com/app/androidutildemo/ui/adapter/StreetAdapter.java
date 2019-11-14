package com.app.androidutildemo.ui.adapter;

import android.support.annotation.Nullable;

import com.app.androidutildemo.R;
import com.app.androidutildemo.bean.WrapStreetBean;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Nick on 2019-04-24.
 */
public class StreetAdapter extends BaseMultiItemQuickAdapter<WrapStreetBean, BaseViewHolder> {


    public StreetAdapter(@Nullable List<WrapStreetBean> data) {
        super(data);
        addItemType(1,R.layout.item_location);
        addItemType(2,R.layout.item_location_street);
    }

    @Override
    protected void convert(BaseViewHolder helper, WrapStreetBean item) {
        switch (item.getItemType()){
            case 1:
                helper.setText(R.id.tv_location,item.getName());
                break;
            case 2:
                helper.setText(R.id.tv_street_location,item.getName());
                break;
        }
    }
}
