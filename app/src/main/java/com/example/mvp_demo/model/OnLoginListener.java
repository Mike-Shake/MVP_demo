package com.example.mvp_demo.model;

import com.example.mvp_demo.bean.User;

public interface OnLoginListener {
    void loginSuccess(User mUser);
    void loginFailed();
}
