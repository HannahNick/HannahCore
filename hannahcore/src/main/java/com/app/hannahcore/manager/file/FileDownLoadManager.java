package com.app.hannahcore.manager.file;

import android.content.Context;

import com.blankj.utilcode.util.LogUtils;
import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadListener;
import com.liulishuo.filedownloader.FileDownloader;

/**
 * Created by Nick on 2019-05-05.
 */
public class FileDownLoadManager {

    private FileDownLoadManager(){}

    public static FileDownLoadManager getInstance(){
        return Holder.sManager;
    }

    public void init(Context context){
        FileDownloader.setup(context);
    }

    public void simpleDownload(String url,String path,SimpleListener listener){
        FileDownloader.getImpl()
                .create(url)
                .setPath(path)
                .setListener(new FileDownloadListener() {

                    @Override
                    protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                        LogUtils.d("pending");
                    }

                    @Override
                    protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                        listener.progress(formatePercent(soFarBytes,totalBytes));
                    }

                    @Override
                    protected void completed(BaseDownloadTask task) {
                        listener.completed(task.getTargetFilePath());
                    }

                    @Override
                    protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                        LogUtils.d("paused");
                    }

                    @Override
                    protected void error(BaseDownloadTask task, Throwable e) {
                        listener.error(e.getMessage());
                    }

                    @Override
                    protected void warn(BaseDownloadTask task) {
                        LogUtils.d("warn");

                    }
                }).start();
    }

    private String formatePercent(int soFarBytes, float totalBytes){
        int round = Math.round((soFarBytes/totalBytes) * 100);
        return String.valueOf(round);
    }

    private static class Holder{
        private static final FileDownLoadManager sManager = new FileDownLoadManager();
    }

    public interface SimpleListener{
        void progress(String percent);
        void completed(String path);
        void error(String msg);
    }
}
