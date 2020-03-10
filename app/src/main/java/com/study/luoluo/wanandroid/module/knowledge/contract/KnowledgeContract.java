package com.study.luoluo.wanandroid.module.knowledge.contract;

import com.study.luoluo.wanandroid.base.IView;
import com.study.luoluo.wanandroid.base.presenter.IPresenter;
import com.study.luoluo.wanandroid.module.knowledge.bean.KnowledgeTreeData;

import java.util.List;

public interface KnowledgeContract {

    interface IKnowledgeView extends IView {
        void showKnowledgeTreeData(List<KnowledgeTreeData> data, boolean isRefresh);
    }

    interface IKnowledgePresenter extends IPresenter<IKnowledgeView> {
        void getKnowledgeTreeData(boolean isRefresh);
    }
}
