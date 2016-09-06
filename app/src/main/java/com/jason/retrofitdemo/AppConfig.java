package com.jason.retrofitdemo;

import java.io.File;

/**
 * @author zjh
 * @date 2016/9/6
 */
public class AppConfig {
    public static final boolean DEBUG = true;

    public static final String BASE_URL = "http://45.78.16.244:8080/parallelworld/rest/v1/";

    public static final String HTTP_CACHE_PAth = DemoApplication.getInstance().getExternalCacheDir() + File.separator + "http_cache";
    public static final long CACHE_SIZE = 1024 * 1024 * 10;

}
