package com.bawei.okhttpdemo;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Adminjs on 2017/12/18.
 */

public class LoggingInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        long t1 = System.nanoTime();

        Response response = chain.proceed(request);

        long t2 = System.nanoTime();

        System.out.println(" this request  url  "+response.request().url()+" "+(t2-t1)/1000000);
        return response;
    }
}
