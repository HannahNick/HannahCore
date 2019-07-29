package com.app.hannahcore.manager.network;


import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Nick on 2019-04-28.
 */
public abstract class ObservableWrapper<T> extends Observable<T> {


    public Disposable request(Consumer<? super T> consumer){
        return subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(consumer);
    }

    public Disposable request(Consumer<? super T> consumer, Consumer<? super Throwable> throwable){
        return subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(consumer,throwable);
    }

    public Disposable request(Consumer<? super T> consumer, Consumer<? super Throwable> throwable, Action onComplete){
        return subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(consumer,throwable,onComplete);
    }
}
