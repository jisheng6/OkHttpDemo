package com.bawei.okhttpdemo;

/**
 * Created by Adminjs on 2017/12/18.
 */

public class BasePresenter {
    private MaView view;
    private LoginModelImpl moldel;
    public BasePresenter(MaView view) {
        this.view = view;
        this.moldel = new LoginModelImpl();
    }

    public void get(){
       moldel.getData(new LoginModelCallBack() {
           @Override
           public void success(Bean bean) {
               if(view != null){
                   view.success(bean);
               }
           }
       });
    }
}
