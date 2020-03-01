package com.study.luoluo.wanandroid.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.study.luoluo.wanandroid.R;
import com.study.luoluo.wanandroid.base.fragment.BaseFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProjectsFragment extends BaseFragment {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("luoluo", "ProjectsFragment run ~~~~~");
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
