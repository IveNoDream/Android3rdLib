package com.wafe.android3rdlib;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wafe on 2017/2/5.
 */

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerViewHolder> {

    private LayoutInflater mInflater;
    private List<String> mDatas = new ArrayList<>();
    private OnItemClickListner mOnItemClickListner;
    public interface OnItemClickListner{
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    public void setOnItemClickListner(OnItemClickListner listner) {
        this.mOnItemClickListner = listner;
    }
    public MainRecyclerAdapter(Context context){
        mInflater = LayoutInflater.from(context);
    }

    public void setData(List<String> list){
        mDatas = list;
    }

    @Override
    public MainRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_main_recycler,parent,false);
        return new MainRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MainRecyclerViewHolder holder, final int position) {
        holder.mTitle.setText(mDatas.get(position).toString());
        if (null != mOnItemClickListner) {
            holder.mTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListner.onItemClick(v,position);
                }
            });

            holder.mTitle.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mOnItemClickListner.onItemLongClick(v,position);
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}
