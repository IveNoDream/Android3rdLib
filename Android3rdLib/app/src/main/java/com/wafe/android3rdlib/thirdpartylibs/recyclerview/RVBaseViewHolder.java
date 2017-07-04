package com.wafe.android3rdlib.thirdpartylibs.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by root on 2/6/17.
 */
//pattern T
public abstract  class RVBaseViewHolder<T> extends RecyclerView.ViewHolder {
    public RVBaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bingHolder(T model);
}
