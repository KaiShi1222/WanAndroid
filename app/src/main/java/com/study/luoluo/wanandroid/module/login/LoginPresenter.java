package com.study.luoluo.wanandroid.module.login;

public class LoginPresenter implements LoginContract.LoginPresenter{

    private LoginContract.LoginView view;

    public LoginPresenter(LoginContract.LoginView view) {
        this.view = view;
    }

    @Override
    public void login(String username, String password) {
        view.loginSuccess();
    }

    @Override
    public void signIn(String username, String password, String repeatPassword) {

    }
}
