package com.study.luoluo.wanandroid.module.homepage.presenter;

import android.util.Log;

import com.study.luoluo.wanandroid.base.presenter.BasePresenter;
import com.study.luoluo.wanandroid.core.APIService;
import com.study.luoluo.wanandroid.core.network.BaseResponse;
import com.study.luoluo.wanandroid.core.network.RetrofitClient;
import com.study.luoluo.wanandroid.module.homepage.bean.BannerItemData;
import com.study.luoluo.wanandroid.module.homepage.bean.HomepageArticles;
import com.study.luoluo.wanandroid.module.homepage.bean.TopArticleItem;
import com.study.luoluo.wanandroid.module.homepage.contract.HomeContract;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.ResourceObserver;
import io.reactivex.schedulers.Schedulers;

// get data
public class HomepagePresenter extends BasePresenter<HomeContract.IHomeView> implements HomeContract.IHomePresenter {

    private HomeContract.IHomeView view;

    private int currentArticlePage = 0;

    private static int TOP_ARTICLES_POSITION = 0;

    // it can use dagger instead
    public HomepagePresenter(HomeContract.IHomeView view) {
        this.view = view;
    }

    private APIService service = RetrofitClient.getInstance().init();

    @Override
    public void getBannerData() {
        addDisposable(service.getBanner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(listBaseResponse -> view != null)
                .subscribeWith(new ResourceObserver<BaseResponse<List<BannerItemData>>>() {
                    @Override
                    public void onNext(BaseResponse<List<BannerItemData>> listBaseResponse) {
                        view.showBannerData(listBaseResponse.getData());
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError("banner data error");
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }

    @Override
    public void getTopArticle() {
//        addDisposable(RetrofitClient.getInstance()
//        .init()
//        .getHomepageArticle(currentArticlePage)
//        .subscribeOn(Schedulers.io())
//        .observeOn(AndroidSchedulers.mainThread())
//        .filter(listBaseResponse -> view != null));
    }

    @Override
    public void getArticle(int pageNumber) {

    }

    @Override
    public void getHomepageData() {
        getBannerData();
        // 首页文章由置顶文章和首页文章列表共同组成
        addDisposable(Observable.zip(service.getTopArticles(), service.getHomepageArticle(currentArticlePage),
                (topArticles, homepageArticle) -> {
                    homepageArticle.getData().getDatas().addAll(TOP_ARTICLES_POSITION, topArticles.getData());
                            return homepageArticle;
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .filter(homepageData -> view != null)
                .subscribeWith(new ResourceObserver<BaseResponse<HomepageArticles>>() {
                    @Override
                    public void onNext(BaseResponse<HomepageArticles> homepageArticlesBaseResponse) {
                       view.showArticles(homepageArticlesBaseResponse.getData());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }




















}
