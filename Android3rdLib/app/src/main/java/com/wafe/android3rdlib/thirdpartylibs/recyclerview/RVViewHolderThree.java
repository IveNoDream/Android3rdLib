package com.wafe.android3rdlib.thirdpartylibs.recyclerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wafe.android3rdlib.R;

/**
 * Created by root on 2/6/17.
 */
public class RVViewHolderThree extends RVBaseViewHolder<RVDataModelThree> {
    private ImageView mIVHead;
    private TextView mTvTitle;
    public RVViewHolderThree(View itemView) {
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
