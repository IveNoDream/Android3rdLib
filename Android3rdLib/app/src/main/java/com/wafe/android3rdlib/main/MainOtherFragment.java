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
import com.wafe.android3rdlib.other.OtherRVAdapter;


/**
 * Created by root on 2/14/17.
 */
public class MainOtherFragment extends Fragment {

    private RecyclerView mRecycler;
    private View mFragment;
    private OtherRVAdapter mOtherRVAdapter;
    private Context mContext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mFragment = inflater.inflate(R.layout.main_tab_other_fragment,container,false);
        mContext = getActivity();

        init();

        return mFragment;
    }

    private void init() {
        mRecycler = (RecyclerView) mFragment.findViewById(R.id.rv_other_main);
        mRecycler.setLayoutManager(new LinearLayoutManager(mContext,
                LinearLayoutManager.VERTICAL,false));
        mOtherRVAdapter = new OtherRVAdapter(mContext);
        mRecycler.setAdapter(mOtherRVAdapter);
        mOtherRVAdapter.setOnItemClickListner(new OtherRVAdapter.OnItemClickListner() {
            @Override
            public void onItemClick(View view, int position) {
                MainRVDataModel dataModel= MainRVDataFactory.RV_OTHER_DATAS.get(position);
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
