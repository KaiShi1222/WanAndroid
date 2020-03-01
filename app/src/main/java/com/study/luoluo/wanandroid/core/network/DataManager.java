package com.study.luoluo.wanandroid.core.network;

import com.study.luoluo.wanandroid.core.APIService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataManager {

    private static DataManager dataManager = null;

    private DataManager() {

    }
    public static DataManager getInstance() {
        if (dataManager == null) {
            dataManager = new DataManager();
        }
        return dataManager;
    }
}
