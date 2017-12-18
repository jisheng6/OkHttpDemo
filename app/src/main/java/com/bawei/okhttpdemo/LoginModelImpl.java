package com.bawei.okhttpdemo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Adminjs on 2017/12/18.
 */

//具体的model层
public class LoginModelImpl {
    //model层处理数据,请求网络
    public void getData(final LoginModelCallBack loginModelCallBack) {
//http://api.tianapi.com/nba/?key=71e58b5b2f930eaf1f937407acde08fe&num=10

        Map<String,String> map = new HashMap<>();
        map.put("key","71e58b5b2f930eaf1f937407acde08fe");
        map.put("num","10");

       /* Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.tianapi.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IGetService service = retrofit.create(IGetService.class);

        service.get(map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Bean>() {
                    @Override
                    public void accept(Bean bean) throws Exception {
                        loginModelCallBack.success(bean);
                    }
                });*/

        //------------
        //http://api.tianapi.com/nba/?key=71e58b5b2f930eaf1f937407acde08fe&num=10
        //调用apifactory
        //传参map集合
        APIFactory.getInstance().get1("/nba", map, new AbstractObserver<Bean>() {

            @Override
            public void onSuccess(Bean bean) {
                //  System.out.println("beanget传参 ="+bean.getNewslist().toString());
            }

            @Override
            public void onFailure() {
                // System.out.println("异常了");
            }
        });

        //不传参,直接传路径
        APIFactory.getInstance().get1("/nba/?key=71e58b5b2f930eaf1f937407acde08fe&num=10", new AbstractObserver<Bean>() {

            @Override
            public void onSuccess(Bean bean) {
                // System.out.println("beanget不传参 ="+bean.getNewslist().toString());
            }

            @Override
            public void onFailure() {
                // System.out.println("异常了");
            }
        });

        //不传参直接传路径post
        APIFactory.getInstance().post1("/nba/?key=71e58b5b2f930eaf1f937407acde08fe&num=10", new AbstractObserver<Bean>() {

            @Override
            public void onSuccess(Bean bean) {
                System.out.println("beanpost不带参数 ="+bean.getNewslist().toString());
                loginModelCallBack.success(bean);
            }

            @Override
            public void onFailure() {
                System.out.println("异常了");
            }
        });

       /* //传参 post路径,不好使
        APIFactory.getInstance().post1("/nba", map, new AbstractObserver<Bean>() {

            @Override
            public void onSuccess(Bean bean) {
                 System.out.println("beanpost带参数 ="+bean.getNewslist().toString());
            }

            @Override
            public void onFailure() {
                 System.out.println("异常了");
            }
        });*/


    }
}
