package com.app.hannahcore.base;

/**
 * Created by Nick on 2019-04-29.
 * 封装下拉刷新和上拉加载
 */
public abstract class BaseListPresenter extends BasePresenter{

    protected int mCurrentNo = 1;

    public void loadMore(){
        mCurrentNo++;
        requestListData();
    }

    public void refresh(){
        mCurrentNo = 1;
        requestListData();
    }

    protected abstract void requestListData();
}
