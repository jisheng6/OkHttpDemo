package com.bawei.okhttpdemo;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by Adminjs on 2017/12/18.
 */

public interface IGetService {

   /* @GET("/nba")
    Observable<Bean> get(@QueryMap Map<String,String> map);*/

    //-----------------------下面用于封装的请求
    //http://api.tianapi.com/nba/?key=71e58b5b2f930eaf1f937407acde08fe&num=10
    //返回string字符串的请求方法,传后面整个url
    @GET
    Observable<String> get1(@Url String url);//重载

    @GET
    Observable<String> get1(@Url String url, @QueryMap Map<String, String> map);

    @FormUrlEncoded
    @POST
    Observable<String> post1(@Url String url, @FieldMap Map<String, String> map);

    @POST
    Observable<String> post1(@Url String url);
}
