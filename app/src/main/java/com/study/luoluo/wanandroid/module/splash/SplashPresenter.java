package com.study.luoluo.wanandroid.module.splash;

import android.content.Context;
import android.content.Intent;

import com.study.luoluo.wanandroid.base.presenter.BasePresenter;
import com.study.luoluo.wanandroid.ui.MainActivity;

public class SplashPresenter extends BasePresenter<SplashContract.SplashView> implements SplashContract.SplashPresenter {

    private SplashContract.SplashView view;

    public SplashPresenter(SplashContract.SplashView view) {
        this.view = view;
    }

    @Override
    public void gotoHomePage(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
        ((SplashActivity)view).finish();
    }
}
