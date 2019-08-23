package com.app.hannahcore.base;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

import io.reactivex.disposables.Disposable;

/**
 * Created by Nick on 2017/10/7.
 * P层抽象,主要对网络请求做统一释放
 */

public abstract class BasePresenter<T> {

    protected Reference<T> mView;

    public void attachView(T view){
        mView = new WeakReference<>(view);
    }

    protected T getView(){
        return mView.get();
    }

    public void detachView(){
        if (mView!=null){
            mView.clear();
            mView = null;
        }
    }

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
