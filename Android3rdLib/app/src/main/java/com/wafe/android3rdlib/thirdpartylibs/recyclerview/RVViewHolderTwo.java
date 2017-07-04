package com.wafe.android3rdlib.thirdpartylibs.recyclerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wafe.android3rdlib.R;

/**
 * Created by root on 2/6/17.
 */
public class RVViewHolderTwo extends RVBaseViewHolder<RVDataModelTwo> {
    private ImageView mIVHead;
    private TextView mTvTitle;
    private TextView mTvDescribtion;
    public RVViewHolderTwo(View itemView) {
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
