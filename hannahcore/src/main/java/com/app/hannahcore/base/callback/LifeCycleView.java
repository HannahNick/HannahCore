package com.app.hannahcore.base.callback;

import com.trello.rxlifecycle2.LifecycleTransformer;

/**
 * Created by Nick on 2019-10-31.
 * 生命周期绑定
 */
public interface LifeCycleView {
    <T> LifecycleTransformer<T> bindToLife();
}
