package com.study.luoluo.wanandroid.module.splash;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.study.luoluo.wanandroid.R;
import com.study.luoluo.wanandroid.base.BaseActivity;

public class SplashActivity extends BaseActivity<SplashPresenter> implements SplashContract.SplashView {

    private Button goToHomepage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        presenter = new SplashPresenter(this);
        goToHomepage = findViewById(R.id.btn_goto_homepage);
        goToHomepage.setOnClickListener(v -> presenter.gotoHomePage());
    }

    @Override
    public void showCountDown(int millisecond) {
        int second = millisecond / 1000;
        goToHomepage.setText("");
    }

}
