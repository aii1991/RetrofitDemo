package com.jason.retrofitdemo;

import android.app.Application;

/**
 * @author zjh
 * @date 2016/9/6
 */
public class DemoApplication extends Application{
    private static DemoApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static DemoApplication getInstance() {
        return mInstance;
    }
}
