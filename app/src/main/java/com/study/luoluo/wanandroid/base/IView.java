package com.study.luoluo.wanandroid.base;

import com.study.luoluo.wanandroid.base.presenter.IPresenter;

public interface IView<T extends IPresenter> {

    void setPresenter(T presenter);

    void showLoading();

    void hideLoading();

    void showError(String errorMessage);

}
