package com.study.luoluo.wanandroid.module.homepage.ui;

import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.study.luoluo.wanandroid.R;
import com.study.luoluo.wanandroid.module.homepage.bean.TopArticleItem;

import java.util.List;

public class HomeAdapter extends BaseQuickAdapter<TopArticleItem, BaseViewHolder> {


    public HomeAdapter(int layoutId, List<TopArticleItem> data) {
        super(layoutId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TopArticleItem item) {
        helper.setText(R.id.tv_author, TextUtils.isEmpty(item.getAuthor()) ? item.getShareUser() : item.getAuthor());
        helper.getView(R.id.tv_top).setVisibility(item.getType() == 1 ? View.VISIBLE : View.GONE);
        helper.setText(R.id.tv_article_title, Html.fromHtml(item.getTitle(), 0));
        // niceDate 数据格式为: 2019-1-12 23:43 / 一天前
        helper.setText(R.id.tv_nice_date, item.getNiceDate().split(" ")[0]);
        helper.setText(R.id.tv_chapter_name, item.getChapterName() + "/" + item.getSuperChapterName());
    }
}
