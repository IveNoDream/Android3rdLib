package com.wafe.android3rdlib.recyclerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wafe.android3rdlib.R;

/**
 * Created by root on 2/6/17.
 */
public class RecyclerViewHolderTwo extends BaseViewHolder<RVDataModelTwo> {
    private ImageView mIVHead;
    private TextView mTvTitle;
    private TextView mTvDescribtion;
    public RecyclerViewHolderTwo(View itemView) {
        super(itemView);
        mIVHead = (ImageView) itemView.findViewById(R.id.iv_rv_head);
        mTvTitle = (TextView) itemView.findViewById(R.id.tv_rv_title);
        mTvDescribtion = (TextView) itemView.findViewById(R.id.tv_rv_descibtion);
    }

    @Override
    public void bingHolder(RVDataModelTwo model) {
        mIVHead.setImageResource(model.getmImageRes());
        mTvTitle.setText(model.getmTitle());
        mTvDescribtion.setText(model.getmDescribtion());
    }
}
