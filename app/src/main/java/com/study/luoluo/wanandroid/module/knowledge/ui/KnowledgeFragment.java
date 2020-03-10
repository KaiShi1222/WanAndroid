package com.study.luoluo.wanandroid.module.knowledge.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.study.luoluo.wanandroid.R;
import com.study.luoluo.wanandroid.base.fragment.BaseFragment;
import com.study.luoluo.wanandroid.module.knowledge.bean.KnowledgeTreeData;
import com.study.luoluo.wanandroid.module.knowledge.contract.KnowledgeContract;
import com.study.luoluo.wanandroid.module.knowledge.presenter.KnowledgePresenter;

import java.util.ArrayList;
import java.util.List;

public class KnowledgeFragment extends BaseFragment<KnowledgePresenter> implements KnowledgeContract.IKnowledgeView {

    private View root;
    private KnowledgeAdapter knowledgeAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = super.onCreateView(inflater, container, savedInstanceState);
        presenter = new KnowledgePresenter(this);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        presenter.getKnowledgeTreeData(false);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_knowledge;
    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showKnowledgeTreeData(List<KnowledgeTreeData> data, boolean isRefresh) {
        if (isRefresh) {
            knowledgeAdapter.replaceData(data);
        } else {
            knowledgeAdapter.addData(data);
        }
    }

    private void initView() {
        SmartRefreshLayout smartRefreshLayout = root.findViewById(R.id.srl_knowledge);
        smartRefreshLayout.setOnRefreshListener(refreshLayout -> {
            presenter.getKnowledgeTreeData(true);
            refreshLayout.finishRefresh(2000);
        });
        RecyclerView recyclerView = root.findViewById(R.id.rv_knowledge);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        List<KnowledgeTreeData> knowledgeTreeData = new ArrayList<>();
        knowledgeAdapter = new KnowledgeAdapter(R.layout.knowledge_item, knowledgeTreeData);
        recyclerView.setAdapter(knowledgeAdapter);
    }
}
