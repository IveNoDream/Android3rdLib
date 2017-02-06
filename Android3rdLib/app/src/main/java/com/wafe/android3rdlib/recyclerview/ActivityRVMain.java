package com.wafe.android3rdlib.recyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wafe.android3rdlib.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 2/6/17.
 */
public class ActivityRVMain extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private static int[] mColor = {android.R.color.holo_blue_light,android.R.color.holo_green_light,android.R.color.holo_red_light};

    private RecyclerAdapter mAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_main_pro);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);//pram 2: columes for each line
        mRecyclerView.setLayoutManager(gridLayoutManager);
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(this,
        //        LinearLayoutManager.VERTICAL,false));
        mAdapter = new RecyclerAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        initDatas();
    }

    private void initDatas(){
        List<RVDataModel> models = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            RVDataModel model;
            int p = (i + 1) % 5;
            switch (p) {
                case 1:
                case 2:
                    model = new RVDataModel(1,mColor[0],"Title"+i,"Desc"+i,"Time"+i);
                    break;
                case 3:
                    model = new RVDataModel(1,mColor[1],"Title"+i,"Desc"+i);
                    break;
                case 0:
                case 4:
                    model = new RVDataModel(1,mColor[2],"Title"+i);
                    break;
                default:
                    model = new RVDataModel(1,mColor[0],"Title"+i,"Desc"+i,"Time"+i);
                    break;
            }
            models.add(model);
        }
        mAdapter.setDatas(models);
    }
}
