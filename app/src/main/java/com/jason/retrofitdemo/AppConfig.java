package com.jason.retrofitdemo;

import java.io.File;

/**
 * @author zjh
 * @date 2016/9/6
 */
public class AppConfig {
    public static final boolean DEBUG = true;

    public static final String BASE_URL = "http://127.0.0.1:8080/user/";

    public static final String HTTP_CACHE_PAth = DemoApplication.getInstance().getExternalCacheDir() + File.separator + "http_cache";
    public static final long CACHE_SIZE = 1024 * 1024 * 10;

}
