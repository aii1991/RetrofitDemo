package com.jason.retrofitdemo.net.interceptor;


import com.jason.retrofitdemo.DemoApplication;
import com.jason.retrofitdemo.util.NetworkUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author zjh
 * @date 2016/9/2
 */
public class RspCacheControllerInterceptor implements Interceptor {
    private final int maxAge = 60 * 60 * 24 *7;
    private final int maxStale = 60 * 60 * 24 * 28; // tolerate 4-weeks stale

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        // Add Cache Control only for GET methods
        if (request.method().equals("GET")) {
            Response originalResponse = chain.proceed(chain.request());
            if (NetworkUtils.isNetworkConnected(DemoApplication.getInstance())) {
                return originalResponse.newBuilder()
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .build();
            } else {

                return originalResponse.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .build();
            }
        }

        Response originalResponse = chain.proceed(request);
        return originalResponse;
    }
}
