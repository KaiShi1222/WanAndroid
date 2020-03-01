package com.study.luoluo.wanandroid.base.presenter;

import com.study.luoluo.wanandroid.base.IView;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresenter<V extends IView> implements IPresenter<V> {

    private V view;
    private CompositeDisposable compositeDisposable;

    @Override
    public void refresh(boolean forceUpdate) {
        view.showLoading();
    }

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
    }

    public void addDisposable(Disposable d) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
            compositeDisposable.add(d);
        }
    }
}
