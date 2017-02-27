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
import android.widget.Toast;

import com.wafe.android3rdlib.R;

/**
 * Created by root on 2/14/17.
 */
public class Main3rdLibFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private MainRVAdapter mAdapter;
    private Context mContext;
    private View mFragmentView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mFragmentView = inflater.inflate(R.layout.activity_main,container,false);

        mContext = getActivity();
        init();
        return mFragmentView;
    }

    private void init() {
        mRecyclerView = (RecyclerView) mFragmentView.findViewById(R.id.main_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext,
                LinearLayoutManager.VERTICAL,false));
        mAdapter = new MainRVAdapter(mContext);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListner(new MainRVAdapter.OnItemClickListner() {
            @Override
            public void onItemClick(View view, int position) {
                MainRVDataModel dataModel= MainRVDataFactory.RV_DATAS.get(position);
                Intent intent = new Intent(mContext,dataModel.getActivity());
                startActivity(intent);
                Toast.makeText(mContext,"LL Click",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(mContext,"LL Long Click",Toast.LENGTH_SHORT).show();
            }
        });
        mRecyclerView.addItemDecoration(new MainDividerItemDecoration(mContext, MainDividerItemDecoration.VERTICAL_LIST));
    }

}
