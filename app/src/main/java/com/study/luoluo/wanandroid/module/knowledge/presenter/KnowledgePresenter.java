package com.study.luoluo.wanandroid.module.knowledge.presenter;

import com.study.luoluo.wanandroid.base.presenter.BasePresenter;
import com.study.luoluo.wanandroid.core.APIService;
import com.study.luoluo.wanandroid.core.network.BaseResponse;
import com.study.luoluo.wanandroid.core.network.RetrofitClient;
import com.study.luoluo.wanandroid.module.knowledge.bean.KnowledgeTreeData;
import com.study.luoluo.wanandroid.module.knowledge.contract.KnowledgeContract;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.ResourceObserver;
import io.reactivex.schedulers.Schedulers;

public class KnowledgePresenter extends BasePresenter<KnowledgeContract.IKnowledgeView> implements KnowledgeContract.IKnowledgePresenter {

    private KnowledgeContract.IKnowledgeView view;

    public KnowledgePresenter(KnowledgeContract.IKnowledgeView view) {
        this.view = view;
    }

    private APIService service = RetrofitClient.getInstance().init();

    @Override
    public void getKnowledgeTreeData(final boolean isRefresh) {
        if (!isRefresh) {
            view.showLoading();
        }
        addDisposable(service.getKnowledgeTreeData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .filter(knowledgeTreeData -> view != null)
                .subscribeWith(new ResourceObserver<BaseResponse<List<KnowledgeTreeData>>>() {
                    @Override
                    public void onNext(BaseResponse<List<KnowledgeTreeData>> listBaseResponse) {
                        view.showKnowledgeTreeData(listBaseResponse.getData(), isRefresh);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError("");
                    }

                    @Override
                    public void onComplete() {
                        view.hideLoading();
                    }
                }));
    }
}
