package com.jason.retrofitdemo.util;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/**
 * @author zjh
 * @date 2016/9/2
 */
public class InterceptorUtils {
    private static final Charset UTF8 = Charset.forName("UTF-8");

    public static String getRspData(ResponseBody responseBody) throws Exception {
        long contentLength = responseBody.contentLength();
        BufferedSource source = responseBody.source();
        source.request(Long.MAX_VALUE); // Buffer the entire body.
        Buffer buffer = source.buffer();
        Charset charset = UTF8;
        MediaType contentType = responseBody.contentType();
        if (contentType != null) {
            try {
                charset = contentType.charset(UTF8);
            } catch (UnsupportedCharsetException e) {
                return null;
            }
        }
        if (contentLength != 0) {
            return new JSONObject(buffer.clone().readString(charset)).toString();  //because response content contain quotation mark
        }
        return null;
    }

    public static String getReqData(RequestBody requestBody) throws IOException {
        Buffer buffer = new Buffer();
        requestBody.writeTo(buffer);
        return buffer.readString(UTF8);
    }

    public static Response changeRspData(Response response, String rspData) {
        MediaType contentType = response.body().contentType();
        ResponseBody body = ResponseBody.create(contentType,rspData);
        return response.newBuilder().body(body).build();
    }
}
