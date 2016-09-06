package com.jason.retrofitdemo.api;




import rx.Observable;
import com.jason.retrofitdemo.model.User;
import com.jason.retrofitdemo.model.WrapperRspEntity;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * @author zjh
 * @date 2016/8/19
 */
public interface LoginApi {
    @FormUrlEncoded
    @POST("user/{userName}")
    Observable<WrapperRspEntity<User>> loginReq(@Path("userName") String userName,@Field("pwd") String pwd);
}
