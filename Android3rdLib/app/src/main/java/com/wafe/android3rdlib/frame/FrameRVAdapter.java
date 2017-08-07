package com.wafe.android3rdlib.frame;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wafe.android3rdlib.R;
import com.wafe.android3rdlib.main.MainRVDataFactory;
import com.wafe.android3rdlib.main.MainRVDataModel;
import com.wafe.android3rdlib.main.MainRVHolder;
import com.wafe.android3rdlib.other.OtherRVAdapter;

/**
 * Created by root on 8/7/17.
 */

public class FrameRVAdapter extends RecyclerView.Adapter<MainRVHolder>{
    private LayoutInflater mInflater;
    private FrameRVAdapter.OnItemClickListner mOnItemClickListner;
    public interface OnItemClickListner{
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    public void setOnItemClickListner(FrameRVAdapter.OnItemClickListner listner) {
        this.mOnItemClickListner = listner;
    }

    public FrameRVAdapter(Context context){
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public MainRVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.rv_item_main, parent, false);
        return new MainRVHolder(view);
    }

    @Override
    public void onBindViewHolder(MainRVHolder holder, final int position) {
        MainRVDataModel model = MainRVDataFactory.RV_FRAME_DATAS.get(position);
        int title = model.getTitle();
        int describtion = model.getDescribtion();
        holder.mTitle.setText(title);
        holder.mDescribtion.setText(describtion);
        if (null != mOnItemClickListner) {
            holder.mLL.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListner.onItemClick(v, position);
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
        return MainRVDataFactory.RV_FRAME_DATAS.size();
    }
}
