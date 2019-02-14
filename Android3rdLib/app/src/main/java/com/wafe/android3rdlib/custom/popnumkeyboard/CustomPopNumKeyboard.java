package com.wafe.android3rdlib.custom.popnumkeyboard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.wafe.android3rdlib.R;

/**
 * Created by wangfeng2@siasun.com on 2019/2/1.
 */
public class CustomPopNumKeyboard extends AppCompatActivity {
    private NumberPopup popWindow;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_pop_num_layout);

        final EditText et = (EditText) findViewById(R.id.test_pop_num_et);
        et.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if (popWindow != null) {
                    popWindow.dismiss();
                    popWindow = null;
                }
                popWindow = new NumberPopup(CustomPopNumKeyboard.this, view, 0, 0);
                popWindow.showAtLocation(view, Gravity.TOP | Gravity.RIGHT, 0, 155);
                popWindow.setListener(new NumberPopup.AddListener() {
                    /**
                     * 重写数组选择事件
                     * Author：William（徐威）
                     * Create Time：2018-10-18
                     * @param strNum
                     */
                    @Override
                    public void onChooseNum(String strNum) {
                        String strProductId = et.getText().toString();
                        et.setText(String.format("%s%s", strProductId, strNum));
                    }

                    /**
                     * 重写数字删除事件
                     * Author：William（徐威）
                     * Create Time：2018-10-18
                     */
                    @Override
                    public void onDelNum() {
                        String strProductId = et.getText().toString();
                        if(!TextUtils.isEmpty(strProductId)){
                            et.setText(strProductId.substring(0, strProductId.length() - 1));
                        }
                    }

                    @Override
                    public void onSureNum() {
                    }
                });
                return false;
            }
        });

        final TextView tv = (TextView) findViewById(R.id.test_pop_tv);

        tv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if (popWindow != null) {
                    popWindow.dismiss();
                    popWindow = null;
                }
                popWindow = new NumberPopup(CustomPopNumKeyboard.this, view, 0, 0);
                popWindow.showAtLocation(view, Gravity.TOP | Gravity.RIGHT, 0, 155);
                popWindow.setListener(new NumberPopup.AddListener() {
                    /**
                     * 重写数组选择事件
                     * Author：William（徐威）
                     * Create Time：2018-10-18
                     * @param strNum
                     */
                    @Override
                    public void onChooseNum(String strNum) {
                        String strProductId = tv.getText().toString();
                        tv.setText(String.format("%s%s", strProductId, strNum));
                    }

                    /**
                     * 重写数字删除事件
                     * Author：William（徐威）
                     * Create Time：2018-10-18
                     */
                    @Override
                    public void onDelNum() {
                        String strProductId = tv.getText().toString();
                        if(!TextUtils.isEmpty(strProductId)){
                            tv.setText(strProductId.substring(0, strProductId.length() - 1));
                        }
                    }

                    @Override
                    public void onSureNum() {
                    }
                });
                return false;
            }
        });
    }
}
