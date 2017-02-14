package com.wafe.android3rdlib.recyclerview.android3rdlib.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by root on 2/6/17.
 */
//pattern T
public abstract  class BaseViewHolder<T> extends RecyclerView.ViewHolder {
    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bingHolder(T model);
}
