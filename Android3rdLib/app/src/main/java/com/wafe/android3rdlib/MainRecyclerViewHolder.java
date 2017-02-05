package com.wafe.android3rdlib;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by wafe on 2017/2/5.
 */

public class MainRecyclerViewHolder extends RecyclerView.ViewHolder {
    public TextView mTitle;
    public MainRecyclerViewHolder(View itemView) {
        super(itemView);
        mTitle = (TextView) itemView.findViewById(R.id.item_title);
    }
}
