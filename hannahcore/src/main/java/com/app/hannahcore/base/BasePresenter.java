package com.app.hannahcore.base;

import io.reactivex.disposables.Disposable;

/**
 * Created by Nick on 2017/10/7.
 * P层抽象,主要对网络请求做统一释放
 */

public abstract class BasePresenter {

    /**
     * 释放资源
     * @param d
     */
    protected void release(Disposable... d){
        for (Disposable disposable : d) {
            if (disposable!=null&&!disposable.isDisposed()){
                disposable.dispose();
            }
        }
    }

    public abstract void clear();
}
