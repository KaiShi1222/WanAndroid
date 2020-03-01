package com.study.luoluo.wanandroid.base;

import android.os.Bundle;


import com.study.luoluo.wanandroid.base.presenter.IPresenter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * All Activities should extend this activity, it make the view hold the presenter
 * @param <T>
 */
public class BaseActivity<T extends IPresenter> extends AppCompatActivity implements IView {

    public T presenter;

    @Override
    public void setPresenter(IPresenter presenter) {
        this.presenter = (T) presenter;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        if (presenter != null) {
            presenter = null;
        }
        super.onDestroy();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String errorMessage) {

    }


}
