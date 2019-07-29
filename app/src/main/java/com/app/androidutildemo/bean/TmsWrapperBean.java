package com.app.androidutildemo.bean;

import com.app.androidutildemo.mvp.modle.TmsDataBean.ChildrenBean.ConfigBean.GroupsBean;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Nick on 2019-05-10.
 */
public class TmsWrapperBean implements MultiItemEntity {

    public static final int BANNER_TYPE = 0;
    public static final int NEWS_TYPE = 1;
    public static final int LAUNCHER_TYPE = 2;
    public static final int IMAGE_TYPE = 3;
    public static final int TOFU_TYPE = 4;
    public static final int HORIZONTALGOODS_TYPE = 5;

    public static final String BANNER_COMPONENT = "PolyCarousel";
    public static final String NEWS_COMPONENT = "PolyScrollNews";
    public static final String LAUNCHER_COMPONENT = "PolyNavBox";
    public static final String IMAGE_COMPONENT = "PolyHotArea";
    public static final String TOFU_COMPONENT = "PolyCube";
    public static final String HORIZONTALGOODS_COMPONENT = "PolyHorizontalScrollList";

    private String imgUrl;
    private String goodsName;
    private String skuName;
    private BigDecimal goodsPrice;
    private String title;
    private String subTitle;
    private String imgTitle;
    private String bgColor;
    private List<BannerBean> bannerInfo;
    private List<NewsBean> newsInfo;
    private List<GroupsBean> goodsListData;
    private int componentType;
    private boolean isLeftOne;
    private int spanSize;

    public TmsWrapperBean() {
    }

    public TmsWrapperBean(String imgUrl, String goodsName, String skuName, BigDecimal goodsPrice, String title, String imgTitle, List<BannerBean> bannerInfo, List<NewsBean> newsInfo, int componentType, int spanSize) {
        this.imgUrl = imgUrl;
        this.goodsName = goodsName;
        this.skuName = skuName;
        this.goodsPrice = goodsPrice;
        this.title = title;
        this.imgTitle = imgTitle;
        this.bannerInfo = bannerInfo;
        this.newsInfo = newsInfo;
        this.componentType = componentType;
        this.spanSize = spanSize;
    }


    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getImgTitle() {
        return imgTitle;
    }

    public void setImgTitle(String imgTitle) {
        this.imgTitle = imgTitle;
    }

    public List<BannerBean> getBannerInfo() {
        return bannerInfo;
    }

    public void setBannerInfo(List<BannerBean> bannerInfo) {
        this.bannerInfo = bannerInfo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<NewsBean> getNewsInfo() {
        return newsInfo;
    }

    public void setNewsInfo(List<NewsBean> newsInfo) {
        this.newsInfo = newsInfo;
    }

    public int getComponentType() {
        return componentType;
    }

    public void setComponentType(int componentType) {
        this.componentType = componentType;
        switch (componentType) {
            case LAUNCHER_TYPE:
                spanSize = 1;
                break;
            case TOFU_TYPE:
                spanSize = 2;
                break;
            default:
                spanSize = 4;
                break;
        }
    }

    public int getSpanSize() {
        return spanSize;
    }

    public void setSpanSize(int spanSize) {
        this.spanSize = spanSize;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public List<GroupsBean> getGoodsListData() {
        return goodsListData;
    }

    public void setGoodsListData(List<GroupsBean> goodsListData) {
        this.goodsListData = goodsListData;
    }

    public boolean isLeftOne() {
        return isLeftOne;
    }

    public void setLeftOne(boolean leftOne) {
        isLeftOne = leftOne;
    }

    @Override
    public int getItemType() {
        return componentType;
    }

    public static class NewsBean {
        private String title;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public static class BannerBean {
        private String imgUrl;
        private String action;

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }
    }
}
