package com.study.luoluo.wanandroid.core.network;

import com.study.luoluo.wanandroid.core.APIService;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private RetrofitClient() {

    }

    private static class RetrofitSingleton {
        private static final RetrofitClient INSTANCE = new RetrofitClient();
    }

    public static RetrofitClient getInstance() {
        return RetrofitSingleton.INSTANCE;
    }

    public APIService init() {
        Retrofit retrofit  = new Retrofit.Builder()
                .baseUrl(APIService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(new OkHttpClient())
                .build();
        return retrofit.create(APIService.class);
    }

}
