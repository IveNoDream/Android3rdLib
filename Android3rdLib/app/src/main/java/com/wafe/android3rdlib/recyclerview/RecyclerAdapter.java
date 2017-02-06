package com.wafe.android3rdlib.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.wafe.android3rdlib.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 2/6/17.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private LayoutInflater inflater;
    List<RVDataModel> dataModels = new ArrayList<>();
    public void setDatas(List<RVDataModel> list){
        this.dataModels = list;
    }

    public RecyclerAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case RVDataModel.TYPE_ONE:
                return new RecyclerViewHolderOne(inflater.inflate(R.layout.item_recycler_type1,parent,false));
            case RVDataModel.TYPE_TWO:
                return new RecyclerViewHolderTwo(inflater.inflate(R.layout.item_recycler_type2,parent,false));
            case RVDataModel.TYPE_THREE:
                return new RecyclerViewHolderThree(inflater.inflate(R.layout.item_recycler_type3,parent,false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.bingHolder(dataModels.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        return dataModels.get(position).getmType();
    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }
}
