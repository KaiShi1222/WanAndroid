package com.study.luoluo.wanandroid.base.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.study.luoluo.wanandroid.base.presenter.IPresenter;
import com.study.luoluo.wanandroid.base.IView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
/**
 *  All fragments should extend this fragment. It make the view hold the presenter.
 *  And the concrete fragment should accomplish itself layout and logic
 * */
public abstract class BaseFragment<T extends IPresenter> extends Fragment implements IView {

    protected T presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(), container, false);
    }

    public abstract int getLayoutId();


    @Override
    public void setPresenter(IPresenter presenter) {
        this.presenter = (T) presenter;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showError(String errorMessage) {

    }

    @Override
    public void onDestroy() {
        if (presenter != null) {
            presenter = null;
        }
        super.onDestroy();
    }
}
