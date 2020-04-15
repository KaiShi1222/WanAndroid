package com.study.luoluo.wanandroid.module.login;

import android.content.Context;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.study.luoluo.wanandroid.R;
import com.study.luoluo.wanandroid.base.BaseActivity;

import java.util.function.ToDoubleBiFunction;

/**
 *
 */
public class LoginActivity extends BaseActivity implements LoginContract.LoginView {

    private EditText user;
    private EditText password;
    private Button login;
    private Button signUp;

    private LoginPresenter loginPresenter;

    private String userName;
    private String userPassword;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        user = findViewById(R.id.et_user_name);
        password = findViewById(R.id.et_password);
        login = findViewById(R.id.btn_login);
        signUp = findViewById(R.id.btn_sign_in);
        login.setOnClickListener(v ->
            loginPresenter.login(userName, userPassword)
        );
        signUp.setOnClickListener(v -> {
            // TODO
        });
        loginPresenter = new LoginPresenter(this);
        loginPresenter.setListener(login, user, password);
    }

    @Override
    protected void onResume() {
        super.onResume();
        InputMethodManager service = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (service != null) {
            user.requestFocus();
            service.showSoftInput(user, 0);
        }
    }

    @Override
    public void loginSuccess() {

    }

    @Override
    public void loginFailed() {

    }

    private void getUserInfo() {
        userName = user.getText().toString().trim();
        userPassword = password.getText().toString().trim();
    }
}
