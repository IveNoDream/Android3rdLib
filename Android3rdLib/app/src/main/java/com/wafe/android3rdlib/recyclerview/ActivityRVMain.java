package com.wafe.android3rdlib.recyclerview;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

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

        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) view.getLayoutParams();
                int spanSize = layoutParams.getSpanSize();
                int spanIndex = layoutParams.getSpanIndex();
                outRect.top = 20;
                if (spanSize != gridLayoutManager.getSpanCount()) {
                    if (1 == spanIndex) {
                        outRect.left = 10;
                    } else {
                        outRect.right = 10;
                    }
                }
            }
        });

        initDatas();
    }

    private void initDatas(){
        List<RVDataModelOne> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            RVDataModelOne model;
            model = new RVDataModelOne(mColor[0],"Title"+i,"Desc"+i,"Time"+i);
            list1.add(model);
        }

        List<RVDataModelTwo> list2 = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            RVDataModelTwo model;
            model = new RVDataModelTwo(mColor[0],"Title"+i,"Desc"+i);
            list2.add(model);
        }

        List<RVDataModelThree> list3 = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            RVDataModelThree model;
            model = new RVDataModelThree(mColor[0],"Title"+i);
            list3.add(model);
        }

        mAdapter.setDatas(list1,list2,list3);
    }
}
