package com.app.androidutildemo.ui.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;

import com.app.androidutildemo.SimpleBaseActivity;
import com.app.androidutildemo.R;
import com.app.androidutildemo.ui.adapter.StreetAdapter;
import com.app.androidutildemo.ui.adapter.StreetSectionAdapter;
import com.app.androidutildemo.bean.StreetBean;
import com.app.androidutildemo.bean.StreetBean.DataBean;
import com.app.androidutildemo.bean.StreetBean.DataBean.SubBean;
import com.app.androidutildemo.bean.StreetSectionBean;
import com.app.androidutildemo.bean.WrapStreetBean;
import com.app.androidutildemo.decoration.ListViewDecoration;
import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.ResourceUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends SimpleBaseActivity implements BaseQuickAdapter.OnItemClickListener {

    private SwipeRefreshLayout mSrl_refresh;
    private RecyclerView mRv_list;
    private StreetAdapter mAdapter;
    private StreetSectionAdapter mSectionAdapter;
    private List<WrapStreetBean> mData = new ArrayList<>();
    private List<StreetSectionBean> mSectionData = new ArrayList<>();

    @Override
    protected int contentView() {
        return R.layout.activity_list;
    }

    @Override
    protected void init() {
        mSrl_refresh = findViewById(R.id.srl_refresh);
        mRv_list = findViewById(R.id.lv_list);
        initSectionAdapter();
    }

    private void initSectionAdapter(){
        mRv_list.setLayoutManager(new LinearLayoutManager(this));
        mSectionAdapter = new StreetSectionAdapter(R.layout.item_location_street,R.layout.item_location,mSectionData);
        mRv_list.setAdapter(mSectionAdapter);
        mRv_list.addItemDecoration(new ListViewDecoration(this));
        initStreetSectionBean();
        mSectionAdapter.setOnItemClickListener((adapter, view, position) -> {
            StreetSectionBean streetSectionBean = mSectionData.get(position);
            if (streetSectionBean.isHeader){
                ToastUtils.showShort(streetSectionBean.getDataBean().getName());
            }else {
                ToastUtils.showShort(streetSectionBean.t.getName());
            }
        });
    }

    private void initMultipleAdapter(){
        mRv_list.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new StreetAdapter(mData);
        mRv_list.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(this);
        getStreetData();
        ToastUtils.setGravity(Gravity.CENTER,0,0);
    }

    private void getStreetData(){
        new Thread(() -> {
            String json = ResourceUtils.readAssets2String("Street.txt");
            StreetBean streetBean = GsonUtils.fromJson(json, StreetBean.class);
            runOnUiThread(()->{
                List<DataBean> data = streetBean.getData();
                int size = data.size();
                for (int i = 0; i < size; i++) {
                    DataBean dataBean = data.get(i);
                    WrapStreetBean wrapStreetBean = new WrapStreetBean();
                    wrapStreetBean.setType(1);
                    wrapStreetBean.setName(dataBean.getName());
                    mData.add(wrapStreetBean);
                    List<SubBean> sub = dataBean.getSub();
                    if (sub!=null&&sub.size()>0){
                        int subSize = sub.size();
                        for (int j = 0; j < subSize; j++) {
                            WrapStreetBean subWrapStreetBean = new WrapStreetBean();
                            SubBean subBean = sub.get(j);
                            subWrapStreetBean.setType(2);
                            subWrapStreetBean.setName(subBean.getName());
                            mData.add(subWrapStreetBean);
                        }
                    }
                }
                mAdapter.notifyDataSetChanged();
            });
        }).start();
    }

    private void initStreetSectionBean(){
        new Thread(() -> {
            String json = ResourceUtils.readAssets2String("Street.txt");
            StreetBean streetBean = GsonUtils.fromJson(json, StreetBean.class);
            runOnUiThread(()->{
                List<DataBean> data = streetBean.getData();
                int size = data.size();
                for (int i = 0; i < size; i++) {
                    DataBean dataBean = data.get(i);
                    StreetSectionBean ssb = new StreetSectionBean(true,dataBean.getName(),dataBean);
                    mSectionData.add(ssb);
                    List<SubBean> sub = dataBean.getSub();
                    if (sub!=null&&sub.size()>0){
                        int subSize = sub.size();
                        for (int j = 0; j < subSize; j++) {
                            StreetSectionBean subBean = new StreetSectionBean(sub.get(j));
                            mSectionData.add(subBean);
                        }
                    }
                }
                mSectionAdapter.notifyDataSetChanged();
            });
        }).start();
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        ToastUtils.showShort(mData.get(position).getName());
    }
}
