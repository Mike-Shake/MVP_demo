package com.example.mvp_demo.model;

public interface IUserModel {
    //MVP模式中的Model层，用来处理业务逻辑。
    public void login(String userName,String userPassword,OnLoginListener onLoginListener);
}
