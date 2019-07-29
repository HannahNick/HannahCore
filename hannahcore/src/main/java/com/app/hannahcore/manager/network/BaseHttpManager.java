package com.app.hannahcore.manager.network;

import android.content.Context;

import com.app.hannahcore.BuildConfig;
import com.blankj.utilcode.util.GsonUtils;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Nick on 2017/9/7.
 * 网络请求管理类
 */

public abstract class BaseHttpManager<T> {

    private T t;

    public void init(Context context, String baseUrl, Class<T> api){
        Stetho.initializeWithDefaults(context);
        OkHttpClient client = new OkHttpClient()
                .newBuilder()
                .addInterceptor(new HttpLoggingInterceptor()
                        .setLevel(BuildConfig.DEBUG ?
                                HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE))
                .addNetworkInterceptor(new StethoInterceptor())
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .build();

        Retrofit commonRetrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonUtils.getGson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        t = commonRetrofit.create(api);
    }

    /**
     * 获取网络接口
     */
    public T getApi() {
        return t;
    }

}
