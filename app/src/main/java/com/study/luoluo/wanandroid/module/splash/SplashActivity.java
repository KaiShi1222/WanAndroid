package com.study.luoluo.wanandroid.module.splash;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.study.luoluo.wanandroid.R;
import com.study.luoluo.wanandroid.base.BaseActivity;

public class SplashActivity extends BaseActivity<SplashPresenter> implements SplashContract.SplashView {

    private Button goToHomepage;
    private CountDownTimer timer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        presenter = new SplashPresenter(this);
        goToHomepage = findViewById(R.id.btn_goto_homepage);
        goToHomepage.setOnClickListener(v -> presenter.gotoHomePage(this));
        timer = new MyCountDown(5000, 1000);
    }

    @Override
    protected void onResume() {
        super.onResume();
        timer.start();
    }

    @Override
    public void showCountDown(int millisecond) {
        int second = millisecond / 1000;
        goToHomepage.setText(second);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer.cancel();
        }
    }

    private void gotoHomepage() {
        presenter.gotoHomePage(this);
    }

    private class MyCountDown extends CountDownTimer {

        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        MyCountDown(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            long second = millisUntilFinished / 1000;
            String tip = "跳过" + second + "s";
            goToHomepage.setText(tip);
        }

        @Override
        public void onFinish() {
            gotoHomepage();
        }
    }
}
