package com.wafe.android3rdlib.recyclerview.android3rdlib.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wafe.android3rdlib.R;

/**
 * Created by wafe on 2017/2/5.
 */

public class MainRecyclerViewHolder extends RecyclerView.ViewHolder {
    public LinearLayout mLL;
    public TextView mTitle;
    public TextView mDescribtion;
    public MainRecyclerViewHolder(View itemView) {
        super(itemView);
        mLL = (LinearLayout) itemView.findViewById(R.id.ll_main_rv);
        mTitle = (TextView) itemView.findViewById(R.id.item_title);
        mDescribtion = (TextView) itemView.findViewById(R.id.item_describtion);
    }
}
