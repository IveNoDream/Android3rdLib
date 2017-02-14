package com.wafe.android3rdlib.recyclerview.android3rdlib.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.wafe.android3rdlib.R;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private MainRecyclerAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.main_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,false));
        mAdapter = new MainRecyclerAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListner(new MainRecyclerAdapter.OnItemClickListner() {
            @Override
            public void onItemClick(View view, int position) {
                DataModel dataModel= DataFactory.RV_DATAS.get(position);
                Intent intent = new Intent(MainActivity.this,dataModel.getActivity());
                startActivity(intent);
                Toast.makeText(MainActivity.this,"LL Click",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(MainActivity.this,"LL Long Click",Toast.LENGTH_SHORT).show();
            }
        });
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
        //init data turn to MainRVDataFactory
    }
}
