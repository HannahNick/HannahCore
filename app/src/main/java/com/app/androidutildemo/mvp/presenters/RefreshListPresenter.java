package com.app.androidutildemo.mvp.presenters;

import com.app.androidutildemo.constants.BaseUrl;
import com.app.androidutildemo.manager.HttpManager;
import com.app.androidutildemo.mvp.view.RefreshListView;
import com.app.hannahcore.base.BaseListPresenter;
import com.app.hannahcore.manager.network.RequestBodyUtil;
import com.app.hannahcore.utils.ListAdapterUtil;
import com.blankj.utilcode.util.LogUtils;

import java.util.WeakHashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

/**
 * Created by Nick on 2019-04-28.
 */
public class RefreshListPresenter extends BaseListPresenter {

    private Disposable mDisGoodsList;
    private RefreshListView mView;

    public RefreshListPresenter(RefreshListView view){
        mView = view;
    }


    @Override
    public void clear() {
        release(mDisGoodsList);
    }

    @Override
    protected void requestListData() {
        WeakHashMap<String, Object> params = new WeakHashMap<>();
        params.put("id", "1118031766153211904");
        params.put("currentNo", mCurrentNo);
        params.put("pageSize", ListAdapterUtil.PAGE_SIZE);
        RequestBody requestBody = RequestBodyUtil.getInstance().getRequestBody(params);
        mDisGoodsList= HttpManager.getInstance()
                .getApi()
                .getGroupBuyList(BaseUrl.TMS_BASEURL.concat(BaseUrl.TMS_GOODS_LIST),requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(tmsPoolListBean -> {
                    mView.getData(tmsPoolListBean.getData().getData().getRows());
                },throwable -> LogUtils.e(throwable.getMessage()));
    }
}
