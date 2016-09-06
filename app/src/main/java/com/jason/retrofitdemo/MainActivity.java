package com.jason.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.jason.retrofitdemo.api.LoginApi;
import com.jason.retrofitdemo.model.User;
import com.jason.retrofitdemo.model.WrapperRspEntity;
import com.jason.retrofitdemo.net.RetrofitManager;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.tv);

        RetrofitManager.getInstance().createReq(LoginApi.class).loginReq("test1", "123456").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WrapperRspEntity<User>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mTextView.setText(e.getMessage());
                    }

                    @Override
                    public void onNext(WrapperRspEntity<User> userWrapperRspEntity) {
                        mTextView.setText(userWrapperRspEntity.getData().toString());
                    }
                });
    }
}
