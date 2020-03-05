package com.study.luoluo.wanandroid.module.homepage.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.study.luoluo.wanandroid.R;
import com.study.luoluo.wanandroid.base.fragment.BaseFragment;
import com.study.luoluo.wanandroid.module.homepage.BannerImageLoader;
import com.study.luoluo.wanandroid.module.homepage.bean.BannerItemData;
import com.study.luoluo.wanandroid.module.homepage.bean.TopArticleItem;
import com.study.luoluo.wanandroid.module.homepage.bean.HomepageArticles;
import com.study.luoluo.wanandroid.module.homepage.contract.HomeContract;
import com.study.luoluo.wanandroid.module.homepage.presenter.HomepagePresenter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeFragment extends BaseFragment<HomepagePresenter> implements HomeContract.IHomeView {

    private View root;
    private HomeAdapter homeAdapter;
    private Banner header;
    private int pageNumber = 0;

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = super.onCreateView(inflater, container, savedInstanceState);
        presenter = new HomepagePresenter(this);
        setPresenter(presenter);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        presenter.getHomepageData();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    private void initView() {
        RecyclerView recyclerView = root.findViewById(R.id.rv_home);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        List<TopArticleItem> data = new ArrayList<>();
        homeAdapter = new HomeAdapter(R.layout.homepage_article, data);
        LinearLayout bannerRoot = (LinearLayout) getLayoutInflater().inflate(R.layout.header_banner, null);
        header = bannerRoot.findViewById(R.id.header_banner);
        bannerRoot.removeView(header);
        // BaseQuickAdapter do it
        homeAdapter.setHeaderView(header);
        recyclerView.setAdapter(homeAdapter);
        SmartRefreshLayout smartRefreshLayout = root.findViewById(R.id.srl_home);
        smartRefreshLayout.setOnRefreshListener(refreshLayout -> {
            presenter.getHomepageData();
            refreshLayout.finishRefresh(2000);
        });
        smartRefreshLayout.setOnLoadMoreListener(refreshLayout -> {
            pageNumber++;
            presenter.getArticle(pageNumber);
            refreshLayout.finishLoadMore(2000);
        });
    }

    @Override
    public void showBannerData(List<BannerItemData> bannerItemData) {
        // error it only show
        // presenter.getBannerData();
        List<String> bannerTitle = new ArrayList<>();
        List<String> imagePath = new ArrayList<>();
        for (BannerItemData data : bannerItemData) {
            bannerTitle.add(data.getTitle());
            imagePath.add(data.getImagePath());
        }
        header.setBannerStyle(BannerConfig.NUM_INDICATOR);
        header.setImageLoader(new BannerImageLoader());
        header.setIndicatorGravity(BannerConfig.CENTER);
        header.setBannerTitles(bannerTitle);
        header.setImages(imagePath);
        header.setBannerAnimation(Transformer.Accordion);
        header.start();
    }

    @Override
    public void showArticles(HomepageArticles homepageArticles, boolean isRefresh) {
        if (isRefresh) {
            homeAdapter.replaceData(homepageArticles.getDatas());
        } else {
            homeAdapter.addData(homepageArticles.getDatas());
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void hideLoading() {

    }
}
