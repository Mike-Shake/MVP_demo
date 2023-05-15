package com.example.mvp_demo.presenter;

import android.os.Handler;

import com.example.mvp_demo.bean.User;
import com.example.mvp_demo.model.IUserImp;
import com.example.mvp_demo.model.IUserModel;
import com.example.mvp_demo.model.OnLoginListener;
import com.example.mvp_demo.view.IUserView;


public class UserLoginPresenter {
    private IUserModel iUserModel;
    private IUserView iUserView;
    private Handler handler = new Handler();

    public UserLoginPresenter(IUserView iUserView) {
        this.iUserView = iUserView;
        iUserModel = new IUserImp();
    }

    public void doLogin() {
        iUserView.showProgressDialog();
        iUserModel.login(iUserView.getUserName(), iUserView.getUserPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User mUser) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iUserView.gotoMainView(mUser);
                        iUserView.hideProgressDialog();
                    }
                });
            }

            @Override
            public void loginFailed() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iUserView.showErrorMessage();
                        iUserView.hideProgressDialog();
                    }
                });
            }
        });
    }

    public void doReset() {
        iUserView.clearUserName();
        iUserView.clearPassword();
    }
}
