package com.study.luoluo.wanandroid.base.presenter;

import com.study.luoluo.wanandroid.base.IView;

public interface IPresenter<V extends IView> {

    void refresh(boolean forceUpdate);

    void attachView(V view);

    void detachView();
}
