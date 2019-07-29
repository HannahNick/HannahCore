package com.app.androidutildemo.mvp.presenters;

import com.app.androidutildemo.bean.TmsWrapperBean;
import com.app.androidutildemo.bean.TmsWrapperBean.BannerBean;
import com.app.androidutildemo.bean.TmsWrapperBean.NewsBean;
import com.app.androidutildemo.constants.BaseUrl;
import com.app.androidutildemo.manager.HttpManager;
import com.app.androidutildemo.mvp.modle.TmsDataBean;
import com.app.androidutildemo.mvp.modle.TmsDataBean.ChildrenBean;
import com.app.androidutildemo.mvp.modle.TmsDataBean.ChildrenBean.ConfigBean;
import com.app.androidutildemo.mvp.modle.TmsDataBean.ChildrenBean.ConfigBean.GroupsBean;
import com.app.androidutildemo.mvp.modle.TmsRequestBean.DataBean;
import com.app.androidutildemo.mvp.modle.TmsRequestBean.DataBean.PageJsonDataListBean;
import com.app.androidutildemo.mvp.view.CmsListView;
import com.app.hannahcore.base.BasePresenter;
import com.app.hannahcore.manager.network.RequestBodyUtil;
import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.LogUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

/**
 * Created by Nick on 2019-05-08.
 */
public class CmsListPresenter extends BasePresenter {

    private CmsListView mView;
    private Disposable mDisHome;

    public CmsListPresenter(CmsListView view){
        mView = view;
    }

    public void getHomeData(){
        WeakHashMap<String, Object> params = new WeakHashMap<>();
        params.put("active", true);
        params.put("areaFlag", "100");
        params.put("groupId", BaseUrl.GROUP_ID);
        params.put("processTag", true);
        RequestBody requestBody = RequestBodyUtil.getInstance().getRequestBody(params);
        mDisHome = HttpManager.getInstance()
                .getApi()
                .getMainData(BaseUrl.TMS_BASEURL.concat(BaseUrl.TMS_ROUTE),requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(tmsBean -> {
                    if (tmsBean.isSucceed()) {
                        DataBean data = tmsBean.getData();
                        List<PageJsonDataListBean> pageJsonDataList = data.getPageJsonDataList();
                        String jsonData = pageJsonDataList.get(0).getJsonData();
                        TmsDataBean tmsDataBean = GsonUtils.fromJson(jsonData, TmsDataBean.class);
                        List<ChildrenBean> children = tmsDataBean.getChildren();
                        List<TmsWrapperBean> filterData = new ArrayList<>();
                        int size = children.size();
                        for (int i = 0; i < size; i++) {
                            ChildrenBean childrenBean = children.get(i);
                            String componentType = childrenBean.getComponentType();
                            List<GroupsBean> groups = childrenBean.getConfig().getGroups();
                            switch (componentType){
                                case TmsWrapperBean.BANNER_COMPONENT:
                                    List<BannerBean> bannerBeans = new ArrayList<>();
                                    for (int j = 0; j < groups.size(); j++) {
                                        BannerBean bannerBean = new BannerBean();
                                        bannerBean.setImgUrl(groups.get(j).getImgUrl());
                                        bannerBeans.add(bannerBean);
                                    }
                                    TmsWrapperBean bannerWrapperBean = new TmsWrapperBean();
                                    bannerWrapperBean.setBannerInfo(bannerBeans);
                                    bannerWrapperBean.setComponentType(TmsWrapperBean.BANNER_TYPE);
                                    filterData.add(bannerWrapperBean);
                                    break;
                                case TmsWrapperBean.NEWS_COMPONENT:
                                    List<NewsBean> newsBeans = new ArrayList<>();
                                    for (int j = 0; j < groups.size(); j++) {
                                        NewsBean newsBean = new NewsBean();
                                        newsBean.setTitle(groups.get(j).getTitle());
                                        newsBeans.add(newsBean);
                                    }
                                    TmsWrapperBean newsWrapperBean = new TmsWrapperBean();
                                    newsWrapperBean.setNewsInfo(newsBeans);
                                    newsWrapperBean.setComponentType(TmsWrapperBean.NEWS_TYPE);
                                    filterData.add(newsWrapperBean);
                                    break;
                                case TmsWrapperBean.LAUNCHER_COMPONENT:
                                    for (int j = 0; j < groups.size(); j++) {
                                        GroupsBean groupsBean = groups.get(j);
                                        TmsWrapperBean launcherWrapper = new TmsWrapperBean();
                                        launcherWrapper.setImgUrl(groupsBean.getImgUrl());
                                        launcherWrapper.setImgTitle(groupsBean.getImgTitle());
                                        launcherWrapper.setComponentType(TmsWrapperBean.LAUNCHER_TYPE);
                                        filterData.add(launcherWrapper);
                                    }
                                    break;
                                case TmsWrapperBean.IMAGE_COMPONENT:
                                    ConfigBean imgConfig = childrenBean.getConfig();
                                    TmsWrapperBean imageWrapper = new TmsWrapperBean();
                                    imageWrapper.setImgUrl(imgConfig.getImgUrl());
                                    imageWrapper.setComponentType(TmsWrapperBean.IMAGE_TYPE);
                                    filterData.add(imageWrapper);
                                    break;
                                case TmsWrapperBean.TOFU_COMPONENT:
                                    for (int j = 0; j < groups.size(); j++) {
                                        GroupsBean groupsBean = groups.get(j);
                                        TmsWrapperBean tofuWrapper = new TmsWrapperBean();
                                        tofuWrapper.setImgUrl(groupsBean.getImgUrl());
                                        tofuWrapper.setTitle(groupsBean.getTitle());
                                        tofuWrapper.setSubTitle(groupsBean.getSubTitle());
                                        tofuWrapper.setBgColor(groupsBean.getBgColor());
                                        tofuWrapper.setLeftOne(j%2==0);
                                        tofuWrapper.setComponentType(TmsWrapperBean.TOFU_TYPE);
                                        filterData.add(tofuWrapper);
                                    }
                                    break;
                                case TmsWrapperBean.HORIZONTALGOODS_COMPONENT:
                                    TmsWrapperBean horizontalGoodsWrapper = new TmsWrapperBean();
                                    ConfigBean horizontalConfig = childrenBean.getConfig();
                                    horizontalGoodsWrapper.setImgUrl(horizontalConfig.getImgUrl());
                                    horizontalGoodsWrapper.setGoodsListData(groups);
                                    horizontalGoodsWrapper.setComponentType(TmsWrapperBean.HORIZONTALGOODS_TYPE);
                                    filterData.add(horizontalGoodsWrapper);
                                    break;
                            }

                        }
                        mView.getHomeData(filterData);
                    }
                }, throwable -> {
                    LogUtils.e(throwable);
                });
    }


    @Override
    public void clear() {
        release(mDisHome);
    }

}
