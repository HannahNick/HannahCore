package com.app.hannahcore.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;

import com.app.hannahcore.utils.NetworkUtil;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.NetworkUtils.NetworkType;

/**
 * Created by Nick on 2019-07-05.
 */
public class NetworkBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
            NetworkType networkType = NetworkUtil.getNetworkType(context);
            if (networkType == NetworkType.NETWORK_WIFI){
                LogUtils.e("网络状态切换成了Wifi");
            }
            // do something
        }
    }
}
