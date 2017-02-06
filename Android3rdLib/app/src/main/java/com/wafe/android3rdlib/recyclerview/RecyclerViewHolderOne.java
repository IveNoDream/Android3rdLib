package com.wafe.android3rdlib.recyclerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wafe.android3rdlib.R;

/**
 * Created by root on 2/6/17.
 */
public class RecyclerViewHolderOne extends BaseViewHolder<RVDataModelOne> {
    private ImageView mIVHead;
    private TextView mTvTitle;
    private TextView mTvDescribtion;
    private TextView mTime;
    public RecyclerViewHolderOne(View itemView) {
        super(itemView);
        mIVHead = (ImageView) itemView.findViewById(R.id.iv_rv_head);
        mTvTitle = (TextView) itemView.findViewById(R.id.tv_rv_title);
        mTvDescribtion = (TextView) itemView.findViewById(R.id.tv_rv_descibtion);
        mTime = (TextView) itemView.findViewById(R.id.tv_rv_time);
    }

    @Override
    public void bingHolder(RVDataModelOne model) {
        mIVHead.setImageResource(model.getmImageRes());
        mTvTitle.setText(model.getmTitle());
        mTvDescribtion.setText(model.getmDescribtion());
        mTime.setText(model.getmTime());
    }
}
