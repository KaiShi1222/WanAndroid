package com.study.luoluo.wanandroid.core;

import com.study.luoluo.wanandroid.core.network.BaseResponse;
import com.study.luoluo.wanandroid.module.homepage.bean.BannerItemData;
import com.study.luoluo.wanandroid.module.homepage.bean.HomepageArticles;
import com.study.luoluo.wanandroid.module.homepage.bean.TopArticleItem;
import com.study.luoluo.wanandroid.module.knowledge.bean.KnowledgeTreeData;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIService {

    String BASE_URL = "https://www.wanandroid.com";

    /**
     *
     * 首页banner,作为recycleView的Header显示
     */
    @GET("banner/json")
    Observable<BaseResponse<List<BannerItemData>>> getBanner();

    /**
     * 首页文章列表
     * 例: https://www.wanandroid.com/article/list/0/json
     * 页码从零开始,页码作为参数传递
     * @param pageNumber 页码
     */
    @GET("article/list/{pageNumber}/json")
    Observable<BaseResponse<HomepageArticles>> getHomepageArticle(@Path("pageNumber") int pageNumber);

    /**
     * 置顶文章列表，和首页文章列表共同组成文章列表
     */
     @GET("article/top/json")
     Observable<BaseResponse<List<TopArticleItem>>> getTopArticles();

    /**
     *
     * 主要标识的网站内容的体系结构，二级目录
     */
    @GET("tree/json")
    Observable<BaseResponse<List<KnowledgeTreeData>>> getKnowledgeTreeData();

}
