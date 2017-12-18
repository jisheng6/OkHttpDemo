package com.bawei.okhttpdemo;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Adminjs on 2017/12/18.
 */

public class RetrofitUtils {
    private static IGetService service = null;

    //http://api.tianapi.com/nba/?key=71e58b5b2f930eaf1f937407acde08fe&num=10
    //单例模式
    public static IGetService getInstance(){
        if(service==null){
            synchronized (RetrofitUtils.class){
                if(service==null){
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("http://api.tianapi.com")
                            .addConverterFactory(ScalarsConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .client(OkHttpUtils.getInstance())
                            .build();

                    service = retrofit.create(IGetService.class);
                }
            }
        }
        return service;
    }
}
