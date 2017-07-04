package com.wafe.android3rdlib.thirdpartylibs.eventbus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wafe.android3rdlib.R;
import com.wafe.android3rdlib.util.LogUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by root on 2/27/17.
 */
public class EBSecondActivity extends AppCompatActivity {
    private Button mSendNormal;
    private Button mRevStick;
    private TextView mRevInfo;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eb_secondactivity);
        initView();
    }
    private void initView() {
        mSendNormal = (Button) findViewById(R.id.eb_btn_send_normal);
        mRevStick = (Button) findViewById(R.id.eb_btn_rev_stick);
        mRevInfo = (TextView) findViewById(R.id.eb_tv_rev_info_2);

        mSendNormal.setOnClickListener(mOnClickListner);
        mRevStick.setOnClickListener(mOnClickListner);
    }

    private View.OnClickListener mOnClickListner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.eb_btn_send_normal:
                    //4.post normal event
                    EventBus.getDefault().post(new EBNormalEvent("From Second Activity Message"));
                    finish();
                    break;
                case R.id.eb_btn_rev_stick:
                    //d: register stick Event   can refister only once, use a bool flag if true register
                    if (!EventBus.getDefault().isRegistered(this)) {
                        EventBus.getDefault().register(EBSecondActivity.this);
                    }
                    break;
            }
        }
    };

    //d: rev stick msg
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void onEvent(EBStickEvent msg) {
        //c: rev message when user trigger
        if (null != msg) {
            mRevInfo.setText(msg.getMsg());
        } else {
            LogUtils.i("EBSecondActivity","rev stick msg null");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //e: remove stick event
        EventBus.getDefault().removeAllStickyEvents();
        EventBus.getDefault().unregister(this);
    }
}
