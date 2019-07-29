package com.app.androidutildemo.manager;

import android.content.Context;

import com.app.androidutildemo.http.Api;
import com.app.hannahcore.manager.network.BaseHttpManager;

/**
 * Created by Nick on 2019-04-28.
 */
public class HttpManager extends BaseHttpManager<Api> {

    private HttpManager(){}

    public static HttpManager getInstance(){
        return Holder.sManager;
    }

    public void init(Context context,String baseUrl){
        super.init(context,baseUrl,Api.class);
    }


    private static class Holder{
        private static final HttpManager sManager = new HttpManager();
    }
}
