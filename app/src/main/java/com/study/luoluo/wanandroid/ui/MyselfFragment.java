package com.study.luoluo.wanandroid.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.study.luoluo.wanandroid.R;
import com.study.luoluo.wanandroid.base.fragment.BaseFragment;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyselfFragment extends BaseFragment {

    @Override
    public void onViewCreated(@Nullable View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("luoluo", "MyselfFragment run ~~~~~");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_myself;
    }

    @Override
    public void hideLoading() {

    }
}
