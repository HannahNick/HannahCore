package com.app.androidutildemo.http;

import com.app.androidutildemo.mvp.modle.TmsPoolListBean;
import com.app.androidutildemo.mvp.modle.TmsRequestBean;
import com.app.updateutil.VersionBean;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by Nick on 2019-04-28.
 */
public interface Api {

    /**
     * 获取首页数据
     * @param body
     * @return
     */
    @POST
    Observable<TmsRequestBean> getMainData(@Url String url, @Body RequestBody body);

    /**
     * 获取豆腐块模块商品池数据
     * @param body
     * @return
     */
    @POST
    Observable<TmsPoolListBean> getGroupBuyList(@Url String url, @Body RequestBody body);
    /**
     * 检查版本更新
     * @param body
     * @return
     */
    @POST("VERSIONUPGRADE-HHJ-SERVICE/cs/checkVersion.apec")
    Observable<VersionBean> checkVersion(@Body RequestBody body);
}
