package com.app.androidutildemo.application;

import com.app.androidutildemo.constants.BaseUrl;
import com.app.androidutildemo.manager.HttpManager;
import com.app.hannahcore.HannahApplication;
import com.app.hannahcore.manager.file.FileDownLoadManager;
import com.app.hannahcore.utils.NotificationUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nick on 2019-04-28.
 */
public class MyApplication extends HannahApplication {
    @Override
    protected void init() {
        HttpManager.getInstance().init(this,BaseUrl.URL);
        FileDownLoadManager.getInstance().init(this);
        NotificationUtil.getInstance().init(this,initChannelList());
    }

    private List<String> initChannelList(){
        List<String> channelIds = new ArrayList<>();
        channelIds.add("升级");
        channelIds.add("下载");
        return channelIds;
    }
}
