package com.study.luoluo.wanandroid.module.login;

import android.widget.Button;

import com.study.luoluo.wanandroid.base.IView;
import com.study.luoluo.wanandroid.base.presenter.IPresenter;

public interface LoginContract {

    interface LoginView extends IView {

        void loginSuccess();

        void loginFailed();
    }

    interface LoginPresenter extends IPresenter<LoginView> {

        void login(String username, String password);

        void signIn(String username, String password, String repeatPassword);

    }

    interface UserInfoCheck extends LoginPresenter {
        boolean allTextHasValue(Button listener, String userName, String password);
    }
}
