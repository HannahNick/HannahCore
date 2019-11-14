package com.app.androidutildemo.ui.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.app.androidutildemo.R;
import com.app.androidutildemo.ui.adapter.CmsListAdapter;
import com.app.androidutildemo.bean.TmsWrapperBean;
import com.app.androidutildemo.mvp.presenters.CmsListPresenter;
import com.app.androidutildemo.mvp.view.CmsListView;
import com.app.hannahcore.base.BaseActivity;
import com.app.hannahcore.utils.ListAdapterUtil;

import java.util.ArrayList;
import java.util.List;

public class CmsListActivity extends BaseActivity<CmsListPresenter> implements CmsListView {

    /**
     * data
     */
    private RecyclerView mRv_list;
    private SwipeRefreshLayout mSrl_refresh;

    /**
     * adapter
     */
    private CmsListAdapter mAdapter;


    /**
     * presenter
     */
    private CmsListPresenter mPresenter;

    @Override
    protected int setLayout() {
        return R.layout.activity_cms_list;
    }

    @Override
    protected void findViews() {
        mRv_list = findViewById(R.id.rv_list);
        mSrl_refresh = findViewById(R.id.srl_refresh);
    }

    @Override
    protected void init() {
        mPresenter = new CmsListPresenter(this);
        mRv_list.setLayoutManager(new GridLayoutManager(this,4));
        mAdapter = new CmsListAdapter(new ArrayList<>());
        mAdapter.setSpanSizeLookup((gridLayoutManager, position) -> mAdapter.getData().get(position).getSpanSize());
        mRv_list.setAdapter(mAdapter);
        mSrl_refresh.setRefreshing(true);
        mPresenter.getHomeData();
    }

    @Override
    protected void initListener() {
        mSrl_refresh.setOnRefreshListener(() -> {
            mPresenter.getHomeData();
        });

    }

    @Override
    protected void release() {

    }

    @Override
    protected CmsListPresenter initPresenter() {
        return mPresenter;
    }

    @Override
    public void getHomeData(List<TmsWrapperBean> data) {
        ListAdapterUtil.setUpData(mSrl_refresh,mAdapter,data,null);
    }
}
