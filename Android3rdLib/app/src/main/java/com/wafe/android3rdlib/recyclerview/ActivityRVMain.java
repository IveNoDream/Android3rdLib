package com.wafe.android3rdlib.recyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wafe.android3rdlib.DataModel;
import com.wafe.android3rdlib.LogUtils;
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

        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);//pram 2: columes for each line
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {//Occupy columes in a line(GridLayout)
                int type = mRecyclerView.getAdapter().getItemViewType(position);
                if (RVDataModel.TYPE_ONE == type) {
                    return gridLayoutManager.getSpanCount();//colume count
                } else {
                    return 1;
                }
            }
        });
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
            if (i < 10) {
                model = new RVDataModel(1,mColor[0],"Title"+i,"Desc"+i,"Time"+i);
            } else if (10 <= i && 20 > i) {
                model = new RVDataModel(2,mColor[1],"Title"+i,"Desc"+i);
            } else {
                model = new RVDataModel(3,mColor[2],"Title"+i);
            }

            models.add(model);
        }
        mAdapter.setDatas(models);
    }
}
