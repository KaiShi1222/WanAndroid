package com.study.luoluo.wanandroid.module.splash;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.study.luoluo.wanandroid.R;
import com.study.luoluo.wanandroid.base.BaseActivity;
import com.study.luoluo.wanandroid.base.presenter.IPresenter;

public class SplashActivity extends BaseActivity implements SplashContract.SplashView{


    private Button goToHomepage;

    @Override
    public void setPresenter(IPresenter presenter) {
        super.setPresenter(presenter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        goToHomepage = findViewById(R.id.btn_goto_homepage);
    }

    @Override
    public void showCountDown(int millisecond) {

    }
}
