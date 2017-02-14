package com.wafe.android3rdlib.recyclerview.android3rdlib.main;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wafe.android3rdlib.R;

/**
 * Created by wafe on 2017/2/5.
 */

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerViewHolder> {

    private LayoutInflater mInflater;
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

    @Override
    public MainRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_main_recycler,parent,false);
        return new MainRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MainRecyclerViewHolder holder, final int position) {
        DataModel dataModel = DataFactory.RV_DATAS.get(position);
        Class<? extends AppCompatActivity> activity = dataModel.getActivity();
        int title = dataModel.getTitle();
        int describtion = dataModel.getDescribtion();
        holder.mTitle.setText(title);
        holder.mDescribtion.setText(describtion);
        if (null != mOnItemClickListner) {
            holder.mLL.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListner.onItemClick(v,position);
                }
            });

            holder.mLL.setOnLongClickListener(new View.OnLongClickListener() {
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
        return DataFactory.RV_DATAS.size();
    }
}
