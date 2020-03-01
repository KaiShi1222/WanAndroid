package com.study.luoluo.wanandroid.module.homepage.contract;

import com.study.luoluo.wanandroid.base.presenter.IPresenter;
import com.study.luoluo.wanandroid.base.IView;
import com.study.luoluo.wanandroid.module.homepage.bean.BannerItemData;
import com.study.luoluo.wanandroid.module.homepage.bean.HomepageArticles;
import com.study.luoluo.wanandroid.module.homepage.bean.TopArticleItem;

import java.util.List;

public interface HomeContract {

    interface IHomeView extends IView {
        void showBannerData(List<BannerItemData> bannerItemData);
        void showArticles(HomepageArticles homepageArticles);
    }

    // 需要写明 <V extends IView> and <V>  ???????????
    interface IHomePresenter extends IPresenter<IHomeView> {
        void getBannerData();
        void getTopArticle();
        void getArticle(int pageNumber);
        void getHomepageData();
    }
}
