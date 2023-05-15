package com.example.mvp_demo.view;

import com.example.mvp_demo.bean.User;

public interface IUserView {
    //view层
    String getUserName();

    String getUserPassword();

    void showProgressDialog();

    void hideProgressDialog();

    void gotoMainView(User mUser);

    void showErrorMessage();

    void clearUserName();

    void clearPassword();
}
