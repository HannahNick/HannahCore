package com.app.hannahcore.utils;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.DrawableRes;
import android.support.v4.app.NotificationCompat;

import java.util.List;

/**
 * Created by Nick on 2019-05-06.
 */
public class NotificationUtil {

    private NotificationManager mManager;
    private NotificationCompat.Builder mProgressBuilder;
    private static final int NOTIFICATION_COMMON_ID = 8868;
    private static final int NOTIFICATION_PROGRESS_ID = 8878;

    private NotificationUtil(){ }

    public static NotificationUtil getInstance(){
        return Holder.sUtil;
    }

    public void init(Context context, List<String> channelIds){
        mManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            for (String channelId: channelIds) {
                NotificationChannel stub = new NotificationChannel(channelId, channelId, NotificationManager.IMPORTANCE_LOW);
                stub.enableLights(true);
                stub.setLightColor(Color.RED);
                stub.enableVibration(true);
                stub.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
                mManager.createNotificationChannel(stub);
            }
        }
    }

    public void initProgressNotification(Context context,
                                         @DrawableRes int iconRes,
                                         String title,
                                         String channelId,
                                         String content){
        mProgressBuilder= new NotificationCompat.Builder(context,channelId)
                .setSmallIcon(iconRes)
                .setContentTitle(title)
                .setContentText(content)
                .setAutoCancel(true)
                .setWhen(System.currentTimeMillis())
                .setProgress(100,0,false);
    }

    public void updateProgress(int max,int percent,String content){
        mProgressBuilder.setContentText(content);
        mProgressBuilder.setProgress(max,percent,false);
        mManager.notify(NOTIFICATION_PROGRESS_ID,mProgressBuilder.build());
        if (percent==100){
            mManager.cancel(NOTIFICATION_PROGRESS_ID);
        }
    }

    /**
     * 获取普通的推送实例
     * @param context 上下文
     * @param iconRes 小图标
     * @param title 推送标题
     * @param content 推送内容
     * @param channelId 推送通道ID
     * @param intent 跳转意图
     */
    public void getCommonNotification(Context context,
                                      @DrawableRes int iconRes,
                                      String title,
                                      String content,
                                      String channelId,
                                      Intent intent){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,channelId)
                .setSmallIcon(iconRes)
                .setContentTitle(title)
                .setContentText(content)
                .setAutoCancel(true)
                .setWhen(System.currentTimeMillis());

        int flags = PendingIntent.FLAG_UPDATE_CURRENT;
        PendingIntent pi = PendingIntent.getActivity(context, 0, intent, flags);
        builder.setContentIntent(pi);
        mManager.notify(NOTIFICATION_COMMON_ID, builder.build());
    }

    private static class Holder{
        private static final NotificationUtil sUtil = new NotificationUtil();
    }
}
