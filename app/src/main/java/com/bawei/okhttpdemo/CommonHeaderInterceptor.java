package com.bawei.okhttpdemo;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Adminjs on 2017/12/18.
 */

public class CommonHeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        Request.Builder builder = request.newBuilder();
        builder.addHeader("key","aa");
        builder.addHeader("User-Agent","android");
        return chain.proceed(builder.build());
    }
}
