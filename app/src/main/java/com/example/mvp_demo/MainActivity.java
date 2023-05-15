package com.example.mvp_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mvp_demo.bean.User;
import com.example.mvp_demo.presenter.UserLoginPresenter;
import com.example.mvp_demo.view.IUserView;

public class MainActivity extends AppCompatActivity implements IUserView{

    private Button mBtnLogin,mBtnReset;
    private EditText mETUserName,mETUserPassword;
    private ProgressBar mPbLoading;

    private UserLoginPresenter mUserLoginPresenter=new UserLoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPresenter.doLogin();
            }
        });

        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPresenter.doReset();
            }
        });
    }

    private void initWidgets() {
        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mBtnReset = (Button) findViewById(R.id.btn_reset);
        mETUserName = (EditText) findViewById(R.id.et_username);
        mETUserPassword = (EditText) findViewById(R.id.et_password);

        mPbLoading =  findViewById(R.id.pg_loading);
    }

    @Override
    public String getUserName() {
        return mETUserName.getText().toString();
    }

    @Override
    public String getUserPassword() {
        return mETUserPassword.getText().toString();
    }

    @Override
    public void showProgressDialog() {
        mPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressDialog() {
        mPbLoading.setVisibility(View.INVISIBLE);
    }

    @Override
    public void gotoMainView(User mUser) {
        Toast.makeText(this, mUser.getUserName() + " login success , to MainActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(this, "login failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearUserName() {
        mETUserName.setText("");
    }

    @Override
    public void clearPassword() {
        mETUserPassword.setText("");
    }
}