package com.app.hannahcore.service;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.app.hannahcore.receiver.NetworkBroadcastReceiver;

/**
 * Created by Nick on 2019-07-05.
 */
public class NetworkService extends Service {

    private NetworkBroadcastReceiver mNetworkListener;

    @Override
    public void onCreate() {
        super.onCreate();

        mNetworkListener = new NetworkBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(mNetworkListener,intentFilter);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (mNetworkListener==null){
            mNetworkListener = new NetworkBroadcastReceiver();
            IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
            registerReceiver(mNetworkListener,intentFilter);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mNetworkListener!=null){
            unregisterReceiver(mNetworkListener);
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
