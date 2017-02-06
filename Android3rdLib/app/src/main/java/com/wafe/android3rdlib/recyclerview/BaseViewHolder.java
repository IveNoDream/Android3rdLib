package com.wafe.android3rdlib.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by root on 2/6/17.
 */
public abstract  class BaseViewHolder extends RecyclerView.ViewHolder {
    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bingHolder(RVDataModel model);
}
