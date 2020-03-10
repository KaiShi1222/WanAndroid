package com.study.luoluo.wanandroid.module.knowledge.ui;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.study.luoluo.wanandroid.R;
import com.study.luoluo.wanandroid.module.knowledge.bean.KnowledgeTreeData;

import java.util.List;


public class KnowledgeAdapter extends BaseQuickAdapter<KnowledgeTreeData, BaseViewHolder> {

    public KnowledgeAdapter(int layoutResId, @NonNull List<KnowledgeTreeData> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, KnowledgeTreeData item) {
        helper.setText(R.id.tv_knowledge_title, item.getName());
        if (item.getChildren().size() != 0) {
            StringBuilder titles = new StringBuilder();
            for (KnowledgeTreeData child: item.getChildren()) {
                titles.append(child.getName()).append(" ");
            }
            helper.setText(R.id.tv_knowledge_item, titles);
        }
    }
}
