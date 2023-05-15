package com.example.mvp_demo.model;

import com.example.mvp_demo.bean.User;

public class IUserImp implements IUserModel {
    @Override
    public void login(String userName, String userPassword, OnLoginListener onLoginListener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                if ("jack".equals(userName) && "123".equals(userPassword)) {
                    User user = new User();
                    user.setUserName(userName);
                    user.setUserPassword(userPassword);
                    onLoginListener.loginSuccess(user);
                } else {
                    onLoginListener.loginFailed();
                }
            }
        }).start();

    }
}
