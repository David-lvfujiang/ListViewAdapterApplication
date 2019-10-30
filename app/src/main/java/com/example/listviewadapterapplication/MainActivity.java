package com.example.listviewadapterapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements  SwipeRefreshLayout.OnRefreshListener {
    ListView mListView;
    List<String> mDatas;
    private SwipeRefreshLayout swipeRefreshLayout;
    CommonAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.id_lv_main);
        mDatas = new ArrayList<String>();
        mDatas.add("哈哈哈哈哈");
        mDatas.add("哈哈哈哈哈");
        mDatas.add("哈哈哈哈哈");
        mDatas.add("哈哈哈哈哈");
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.sr1);
        //设置刷新圈的颜色
        swipeRefreshLayout.setColorSchemeColors(Color.GREEN);
        //设置监听
        swipeRefreshLayout.setOnRefreshListener(this);
        adapter =  new CommonAdapter<String>(
                this, mDatas, R.layout.list_item) {
            @Override
            public void convert(ViewHolder c, String item) {
                TextView view = c.getView(R.id.text);
                ImageView imageView = c.getView(R.id.img);
                imageView.setImageResource(R.mipmap.ic_launcher);
                view.setText(item);
            }
        };
        //设置适配器
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,""+i,Toast.LENGTH_SHORT).show();
            }
        });

    }
    /**
     * 下拉时刷新的方法
     */
    @Override
    public void onRefresh() {

                swipeRefreshLayout.setRefreshing(false);
                mDatas.add("哈哈哈哈");
                //适配器刷新
                adapter.notifyDataSetChanged();
    }


}
