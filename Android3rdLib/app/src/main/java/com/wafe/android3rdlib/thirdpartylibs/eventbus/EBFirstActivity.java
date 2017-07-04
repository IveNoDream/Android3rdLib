package com.wafe.android3rdlib.thirdpartylibs.eventbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wafe.android3rdlib.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by root on 2/27/17.
 */
public class EBFirstActivity extends AppCompatActivity {
    private Button mTurnToSecond;
    private Button mSendStick;
    private TextView mRevInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.eb_firstactivity);
        initView();

        //2.register EventBus
        EventBus.getDefault().register(this);
    }

    private void initView() {
        mTurnToSecond = (Button) findViewById(R.id.eb_btn_turnto_send);
        mSendStick = (Button) findViewById(R.id.eb_btn_send_stick);
        mRevInfo = (TextView) findViewById(R.id.eb_tv_rev_info_1);

        mTurnToSecond.setOnClickListener(mOnClickListner);
        mSendStick.setOnClickListener(mOnClickListner);
    }

    private View.OnClickListener mOnClickListner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.eb_btn_turnto_send:
                    Intent intent = new Intent(EBFirstActivity.this, EBSecondActivity.class);
                    startActivity(intent);
                    break;
                case R.id.eb_btn_send_stick:
                    //b: send stick event
                    EventBus.getDefault().postSticky(new EBStickEvent("Stick MSG from FirstActivity"));
                    Intent intent2 = new Intent(EBFirstActivity.this, EBSecondActivity.class);
                    startActivity(intent2);
                    break;
            }
        }
    };

    //5. rev normal event   must add Subscribe***
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EBNormalEvent msg) {
        mRevInfo.setText(msg.getMsg());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //3.unregister eventbus
        EventBus.getDefault().unregister(this);
    }
}
