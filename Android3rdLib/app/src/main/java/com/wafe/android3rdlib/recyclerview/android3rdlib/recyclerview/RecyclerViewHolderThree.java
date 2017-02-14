package com.wafe.android3rdlib.recyclerview.android3rdlib.recyclerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wafe.android3rdlib.R;

/**
 * Created by root on 2/6/17.
 */
public class RecyclerViewHolderThree extends BaseViewHolder<RVDataModelThree> {
    private ImageView mIVHead;
    private TextView mTvTitle;
    public RecyclerViewHolderThree(View itemView) {
        super(itemView);
        mIVHead = (ImageView) itemView.findViewById(R.id.iv_rv_head);
        mTvTitle = (TextView) itemView.findViewById(R.id.tv_rv_title);
    }

    @Override
    public void bingHolder(RVDataModelThree model) {
        mIVHead.setImageResource(model.getmImageRes());
        mTvTitle.setText(model.getmTitle());
    }
}
