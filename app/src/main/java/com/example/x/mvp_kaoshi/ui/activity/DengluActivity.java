package com.example.x.mvp_kaoshi.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.x.mvp_kaoshi.R;
import com.example.x.mvp_kaoshi.View.IUserLoginViewl;
import com.example.x.mvp_kaoshi.modle.UserBean;
import com.example.x.mvp_kaoshi.presenter.impl.impl.UserLoginPersener;

public class DengluActivity extends AppCompatActivity implements IUserLoginViewl{

    private Button mBtn1,mBtn2;
    private EditText mEt_name,mEt_pass;
    private ProgressBar mPro;
    private UserLoginPersener persener=new UserLoginPersener(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denglu);

        initView();


    }

    private void initView() {
        mBtn1 = (Button) findViewById(R.id.mBt1);
        mBtn2 = (Button) findViewById(R.id.mBt2);
        mEt_name = (EditText) findViewById(R.id.mEt_name);
        mEt_pass = (EditText) findViewById(R.id.mEt_pass);
        mPro = (ProgressBar) findViewById(R.id.mPro);


        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                persener.Login();
            }
        });
        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                persener.clear();
            }
        });
    }

    @Override
    public String getName() {
        return mEt_name.getText().toString();
    }

    @Override
    public String getPassword() {
        return mEt_pass.getText().toString();
    }

    @Override
    public void clearName() {
        mEt_name.setText("");

    }

    @Override
    public void clearPassword() {
        mEt_pass.setText("");

    }

    @Override
    public void showLoading() {
        mPro.setVisibility(View.VISIBLE);

    }

    @Override
    public void hintLoading() {
        mPro.setVisibility(View.GONE);

    }

    @Override
    public void toActivity(UserBean bean) {
        Intent in=new Intent(DengluActivity.this,ZhuyemianActivity.class);
        startActivity(in);

    }

    @Override
    public void loadFailError() {
        Toast.makeText(DengluActivity.this,"账号和密码不能为空",Toast.LENGTH_SHORT).show();

    }
}
