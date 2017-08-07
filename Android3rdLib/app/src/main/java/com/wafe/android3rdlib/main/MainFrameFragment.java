package com.wafe.android3rdlib.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wafe.android3rdlib.R;
import com.wafe.android3rdlib.frame.FrameRVAdapter;

/**
 * Created by root on 2/14/17.
 */
public class MainFrameFragment extends Fragment {

    private RecyclerView mRecycler;
    private View mFragment;
    private FrameRVAdapter mFrameRVAdapter;
    private Context mContext;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mFragment = inflater.inflate(R.layout.main_tab_frame_fragment,container,false);
        mContext = getActivity();

        init();

        return mFragment;
    }

    private void init() {
        mRecycler = (RecyclerView) mFragment.findViewById(R.id.rv_frame_main);
        mRecycler.setLayoutManager(new LinearLayoutManager(mContext,
                LinearLayoutManager.VERTICAL,false));
        mFrameRVAdapter = new FrameRVAdapter(mContext);
        mRecycler.setAdapter(mFrameRVAdapter);
        mFrameRVAdapter.setOnItemClickListner(new FrameRVAdapter.OnItemClickListner() {
            @Override
            public void onItemClick(View view, int position) {
                MainRVDataModel dataModel= MainRVDataFactory.RV_FRAME_DATAS.get(position);
                Intent intent = new Intent(mContext,dataModel.getActivity());
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
        mRecycler.addItemDecoration(new MainDividerItemDecoration(mContext, MainDividerItemDecoration.VERTICAL_LIST));
    }
}
