package com.app.androidutildemo.ui.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.app.androidutildemo.R;
import com.app.androidutildemo.SimpleBaseActivity;
import com.app.androidutildemo.adapter.GoodsListAdapter;
import com.app.androidutildemo.decoration.ListViewDecoration;
import com.app.androidutildemo.mvp.modle.TmsPoolListBean.DataBeanX.DataBean.RowsBean;
import com.app.androidutildemo.mvp.presenters.RefreshListPresenter;
import com.app.androidutildemo.mvp.view.RefreshListView;
import com.app.hannahcore.utils.ListAdapterUtil;

import java.util.ArrayList;
import java.util.List;

public class RefreshListActivity extends SimpleBaseActivity implements RefreshListView {

    private RefreshListPresenter mPresenter;
    private RecyclerView mRv_list;
    private SwipeRefreshLayout mSrl_refresh;
    private GoodsListAdapter mAdapter;
    private View mEmptyView;

    @Override
    protected int contentView() {
        return R.layout.activity_refresh_list;
    }

    @Override
    protected void init() {
        findView();
        initRecyclerView();
        mPresenter = new RefreshListPresenter(this);
        mPresenter.refresh();
    }

    private void findView(){
        mRv_list = findViewById(R.id.rv_list);
        mSrl_refresh = findViewById(R.id.srl_refresh);
        mEmptyView = LayoutInflater.from(this).inflate(R.layout.layout_nodata, null);
    }

    private void initRecyclerView(){
        mRv_list.setLayoutManager(new LinearLayoutManager(this));
        mRv_list.addItemDecoration(new ListViewDecoration(this));
        mAdapter = new GoodsListAdapter();
        mRv_list.setAdapter(mAdapter);
        mAdapter.setOnLoadMoreListener(() -> {
            mPresenter.loadMore();
        },mRv_list);
        mSrl_refresh.setRefreshing(true);
        mSrl_refresh.setOnRefreshListener(() -> mPresenter.refresh());
    }


    @Override
    public void getData(List<RowsBean> bean) {
        ListAdapterUtil.setUpData(mSrl_refresh,mAdapter,new ArrayList<>(),mEmptyView);
    }
}
