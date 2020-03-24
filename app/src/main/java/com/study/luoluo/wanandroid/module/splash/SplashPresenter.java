package com.study.luoluo.wanandroid.module.splash;

import com.study.luoluo.wanandroid.base.presenter.BasePresenter;

public class SplashPresenter extends BasePresenter<SplashContract.SplashView> implements SplashContract.SplashPresenter {

    private SplashContract.SplashView view;

    public SplashPresenter(SplashContract.SplashView view) {
        this.view = view;
    }

    @Override
    public void gotoHomePage() {

    }
}
