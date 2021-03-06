package com.example.recyclerviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private SwipeCardRecyclerView mRecyclerView;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (SwipeCardRecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new SwipeCardLayoutManager());
        final List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }
        mAdapter = new MyAdapter(this, list);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setRemovedListener(new ItemRemovedListener() {
            @Override
            public void onRightRemoved() {  //右划响应逻辑
//                Toast.makeText(MainActivity.this, list.get(list.size() - 1) + " was right removed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLeftRemoved() {  //左划响应逻辑
//                Toast.makeText(MainActivity.this, list.get(list.size() - 1) + " was left removed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}