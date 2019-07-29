package com.app.androidutildemo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.androidutildemo.R;
import com.app.androidutildemo.bean.TmsWrapperBean;
import com.app.androidutildemo.bean.TmsWrapperBean.BannerBean;
import com.app.androidutildemo.bean.TmsWrapperBean.NewsBean;
import com.app.hannahcore.manager.image.GlideManager;
import com.app.hannahcore.widget.MarqueeView;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nick on 2019-05-08.
 */
public class CmsListAdapter extends BaseMultiItemQuickAdapter<TmsWrapperBean, BaseViewHolder> {

    private final boolean mHasInitBanner = true;

    public CmsListAdapter(List<TmsWrapperBean> data) {
        super(data);
        addItemType(TmsWrapperBean.BANNER_TYPE, R.layout.adapter_home_banner);
        addItemType(TmsWrapperBean.NEWS_TYPE, R.layout.adapter_home_news);
        addItemType(TmsWrapperBean.LAUNCHER_TYPE, R.layout.adapter_home_launcher);
        addItemType(TmsWrapperBean.IMAGE_TYPE, R.layout.view_image);
        addItemType(TmsWrapperBean.TOFU_TYPE, R.layout.adapter_home_groupbuy_frist);
        addItemType(TmsWrapperBean.HORIZONTALGOODS_TYPE, R.layout.adapter_home_brandday);
    }

    @Override
    protected void convert(BaseViewHolder helper, TmsWrapperBean item) {
        int itemType = item.getItemType();
        switch (itemType){
            case TmsWrapperBean.BANNER_TYPE:
                initBanner(helper,item);
                break;
            case TmsWrapperBean.NEWS_TYPE:
                initNews(helper,item);
                break;
            case TmsWrapperBean.LAUNCHER_TYPE:
                initLauncher(helper,item);
                break;
            case TmsWrapperBean.IMAGE_TYPE:
                initImage(helper,item);
                break;
            case TmsWrapperBean.TOFU_TYPE:
                initTofu(helper,item);
                break;
            case TmsWrapperBean.HORIZONTALGOODS_TYPE:
                initHorizontalGoods(helper,item);
                break;
        }


    }

    private void initBanner(BaseViewHolder helper, TmsWrapperBean item){
        MZBannerView<BannerBean> bannerView = helper.getView(R.id.banner);
        if (bannerView.getTag()!=null&&(boolean)bannerView.getTag()){
            return;
        }
        BannerViewHolder bannerViewHolder = new BannerViewHolder();
        bannerView.setPages(item.getBannerInfo(),()->bannerViewHolder);
        bannerView.start();
        bannerView.setTag(mHasInitBanner);
    }

    private void initNews(BaseViewHolder helper, TmsWrapperBean item){
        MarqueeView marqueeView = helper.getView(R.id.mv_news);
        List<NewsBean> data = item.getNewsInfo();
        marqueeView.removeAllViews();
        List<View> newsView = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            NewsBean groupsBean = data.get(i);
            TextView newsContent = (TextView) LayoutInflater.from(mContext).inflate(R.layout.view_textview,marqueeView,false);
            newsContent.setText(groupsBean.getTitle());
            newsView.add(newsContent);
        }
        marqueeView.setViews(newsView);
    }

    private void initLauncher(BaseViewHolder helper, TmsWrapperBean item){
        helper.setText(R.id.tv_text,item.getImgTitle());
        GlideManager.getInstance().loadUrl(mContext,helper.getView(R.id.iv_icon),item.getImgUrl());
    }

    private void initImage(BaseViewHolder helper, TmsWrapperBean item){
        GlideManager.getInstance().loadUrl(mContext,helper.getView(R.id.image),item.getImgUrl());
    }

    private void initTofu(BaseViewHolder helper, TmsWrapperBean item){
        GlideManager.getInstance().loadUrl(mContext,helper.getView(R.id.iv_tofu_first),item.getImgUrl());
        helper.setText(R.id.tv_group_one_first_title,item.getTitle());
        helper.setText(R.id.tv_group_one_second_title,item.getSubTitle());
        helper.setBackgroundColor(R.id.iv_bgimg, Color.parseColor(item.getBgColor()));

        if (item.isLeftOne()){
            helper.getView(R.id.ll_container).setPadding(0,
                    mContext.getResources().getDimensionPixelOffset(R.dimen.tofu_padding),
                    mContext.getResources().getDimensionPixelOffset(R.dimen.tofu_padding),
                    0);
        }else {
            helper.getView(R.id.ll_container).setPadding(mContext.getResources().getDimensionPixelOffset(R.dimen.tofu_padding),
                    mContext.getResources().getDimensionPixelOffset(R.dimen.tofu_padding),
                    0,
                    0);
        }
    }

    private void initHorizontalGoods(BaseViewHolder helper, TmsWrapperBean item){
        GlideManager.getInstance().loadUrl(mContext,helper.getView(R.id.iv_title),item.getImgUrl());
        RecyclerView recyclerView = helper.getView(R.id.rv_brandlist);
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager==null){
            recyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false));
            recyclerView.setAdapter(new HorizontalGoodsAdapter(item.getGoodsListData()));
        }
    }

    static class BannerViewHolder implements MZViewHolder<BannerBean> {
        ImageView iv_default;

        private BannerViewHolder(){
        }
        @Override
        public View createView(Context context) {
            // 返回页面布局
            View view = LayoutInflater.from(context).inflate(R.layout.item_banner,null);
            iv_default = view.findViewById(R.id.iv_default);
            return view;
        }

        @Override
        public void onBind(Context context, int position, BannerBean data) {
            GlideManager.getInstance()
                    .loadUrl(context, iv_default,data.getImgUrl());
            iv_default.setOnClickListener(v -> {
            });

        }
    }
}
