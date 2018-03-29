package com.base.baselibrary.utils.okgo;

import android.text.TextUtils;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Desc:    想header中添加token
 * Version:
 */

public class RequestTokenInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request newRequest;
        Request.Builder builder = request.newBuilder();
//        String token = TokenUtil.getToken();
//        if (!TextUtils.isEmpty(token)) {
//            builder.addHeader("token", token);
//        }
        newRequest = builder.build();
        return chain.proceed(newRequest);
    }
}
