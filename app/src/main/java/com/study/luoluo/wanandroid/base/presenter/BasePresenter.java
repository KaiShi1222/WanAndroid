package com.study.luoluo.wanandroid.base.presenter;

import com.study.luoluo.wanandroid.base.IView;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresenter<V extends IView> implements IPresenter<V> {

    private CompositeDisposable compositeDisposable;

    public void addDisposable(Disposable d) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
            compositeDisposable.add(d);
        }
    }
}
