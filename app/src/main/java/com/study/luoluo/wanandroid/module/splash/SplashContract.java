package com.study.luoluo.wanandroid.module.splash;

import com.study.luoluo.wanandroid.base.IView;
import com.study.luoluo.wanandroid.base.presenter.IPresenter;

public interface SplashContract {

    interface SplashView extends IView {
        void showCountDown(int millisecond);
    }

    interface SplashPresenter extends IPresenter<SplashView> {
        void gotoHomePage();
    }
}
