package com.bawei.okhttpdemo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.BaseAdapter;
import android.widget.Toast;

public class MainActivity extends Activity implements MaView{
    private RecyclerView xr;
    private BasePresenter presenter;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xr = findViewById(R.id.recyclerview);
        presenter = new BasePresenter(this);
        presenter.get();
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        xr.setLayoutManager(manager);
        adapter = new MyAdapter(MainActivity.this);
        xr.setAdapter(adapter);
    }

    @Override
    public void success(Bean bean) {
        adapter.addData(bean);
        // Toast.makeText(MainActivity.this,bean.toString(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failure() {

    }
}
