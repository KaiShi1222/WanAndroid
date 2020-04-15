package com.study.luoluo.wanandroid.module.login;

import android.widget.Button;
import android.widget.EditText;

public class LoginPresenter implements LoginContract.LoginPresenter, LoginContract.UserInfoCheck {

    private LoginContract.LoginView view;
    private Button listener;

    public LoginPresenter(LoginContract.LoginView view) {
        this.view = view;
    }

    @Override
    public void login(String username, String password) {
        if (allTextHasValue(listener, username, password)) {
            view.loginSuccess();
        } else {
            view.loginFailed();
        }
    }

    @Override
    public void signIn(String username, String password, String repeatPassword) {

    }

    @Override
    public boolean allTextHasValue(Button listener, String userName, String password) {
        return false;
    }

    public void setListener(Button button, EditText ... editTexts) {
        listener = button;
    }
}
