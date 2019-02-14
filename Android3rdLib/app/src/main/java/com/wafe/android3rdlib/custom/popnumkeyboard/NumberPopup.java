package com.wafe.android3rdlib.custom.popnumkeyboard;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.wafe.android3rdlib.R;

/**
 * 数组键盘
 * Author：William（徐威）
 * Create Time：2018-10-18
 */
public class NumberPopup extends PopupWindow implements OnClickListener {
    //全局变量
    private View parent;

    private ImageView iv_NumberPopup_Del;   //删除数字按钮
    //数组按钮
    private TextView tv_NumberPopup_1;
    private TextView tv_NumberPopup_2;
    private TextView tv_NumberPopup_3;
    private TextView tv_NumberPopup_4;
    private TextView tv_NumberPopup_5;
    private TextView tv_NumberPopup_6;
    private TextView tv_NumberPopup_7;
    private TextView tv_NumberPopup_8;
    private TextView tv_NumberPopup_9;
    private TextView tv_NumberPopup_0;
    private TextView tv_NumberPopup_p;
    private TextView tv_NumberPopup_clear;
    private TextView tv_NumberPopup_cancel;
    private TextView tv_NumberPopup_OK;

    /**
     * 构造函数
     * Author：William（徐威）
     * Create Time：2018-10-18
     *
     * @param context
     */
    public NumberPopup(Context context, View parent, int windowWidth, int windowHeight) {
        super(context);
        this.parent = parent;

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = layoutInflater.inflate(R.layout.custom_pop_num_keyboard, null);
        setContentView(contentView);

        //set width and height
        if (windowWidth == 0) {
            windowWidth = 800;
        }
        if (windowHeight == 0) {
            windowHeight = 600;
        }
        setWidth(windowWidth);
        setHeight(windowHeight);

        setOutsideTouchable(true); //
        setFocusable(false); // Not allow to dismiss PopupWindow by touching outside
        setTouchable(true);
        setTouchInterceptor(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });

        initView(contentView);/**/
    }

    /**
     * 初始化视图
     * Author：William（徐威）
     * Create Time：2018-10-18
     *
     * @param view
     */
    private void initView(View view) {
        //获取数组按钮
        tv_NumberPopup_1 = (TextView) view.findViewById(R.id.tv_NumberPopup_1);
        tv_NumberPopup_2 = (TextView) view.findViewById(R.id.tv_NumberPopup_2);
        tv_NumberPopup_3 = (TextView) view.findViewById(R.id.tv_NumberPopup_3);
        tv_NumberPopup_4 = (TextView) view.findViewById(R.id.tv_NumberPopup_4);
        tv_NumberPopup_5 = (TextView) view.findViewById(R.id.tv_NumberPopup_5);
        tv_NumberPopup_6 = (TextView) view.findViewById(R.id.tv_NumberPopup_6);
        tv_NumberPopup_7 = (TextView) view.findViewById(R.id.tv_NumberPopup_7);
        tv_NumberPopup_8 = (TextView) view.findViewById(R.id.tv_NumberPopup_8);
        tv_NumberPopup_9 = (TextView) view.findViewById(R.id.tv_NumberPopup_9);
        tv_NumberPopup_0 = (TextView) view.findViewById(R.id.tv_NumberPopup_0);
        tv_NumberPopup_p = (TextView) view.findViewById(R.id.tv_NumberPopup_p);
        tv_NumberPopup_clear = (TextView) view.findViewById(R.id.tv_NumberPopup_clear);
        tv_NumberPopup_cancel = (TextView) view.findViewById(R.id.tv_NumberPopup_cancel);
        tv_NumberPopup_OK = (TextView) view.findViewById(R.id.tv_NumberPopup_ok);
        iv_NumberPopup_Del = (ImageView) view.findViewById(R.id.iv_NumberPopup_Del);
        tv_NumberPopup_1.setOnClickListener(this);
        tv_NumberPopup_2.setOnClickListener(this);
        tv_NumberPopup_3.setOnClickListener(this);
        tv_NumberPopup_4.setOnClickListener(this);
        tv_NumberPopup_5.setOnClickListener(this);
        tv_NumberPopup_6.setOnClickListener(this);
        tv_NumberPopup_7.setOnClickListener(this);
        tv_NumberPopup_8.setOnClickListener(this);
        tv_NumberPopup_9.setOnClickListener(this);
        tv_NumberPopup_0.setOnClickListener(this);
        tv_NumberPopup_p.setOnClickListener(this);
        iv_NumberPopup_Del.setOnClickListener(this);
        tv_NumberPopup_clear.setOnClickListener(this);
        tv_NumberPopup_cancel.setOnClickListener(this);
        tv_NumberPopup_OK.setOnClickListener(this);
    }

    public void show() {
        // Show at bottom of parent
        this.showAtLocation(parent, Gravity.BOTTOM, 0, 0);
        Log.d("DialogTest", "ShowDialog");
    }

    /**
     * 点击事件监听
     * Author：William（徐威）
     * Create Time：2018-10-18
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_NumberPopup_1:
                if (listener != null) {
                    listener.onChooseNum(tv_NumberPopup_1.getText().toString());
                }
                break;
            case R.id.tv_NumberPopup_2:
                if (listener != null) {
                    listener.onChooseNum(tv_NumberPopup_2.getText().toString());
                }
                break;
            case R.id.tv_NumberPopup_3:
                if (listener != null) {
                    listener.onChooseNum(tv_NumberPopup_3.getText().toString());
                }
                break;
            case R.id.tv_NumberPopup_4:
                if (listener != null) {
                    listener.onChooseNum(tv_NumberPopup_4.getText().toString());
                }
                break;
            case R.id.tv_NumberPopup_5:
                if (listener != null) {
                    listener.onChooseNum(tv_NumberPopup_5.getText().toString());
                }
                break;
            case R.id.tv_NumberPopup_6:
                if (listener != null) {
                    listener.onChooseNum(tv_NumberPopup_6.getText().toString());
                }
                break;
            case R.id.tv_NumberPopup_7:
                if (listener != null) {
                    listener.onChooseNum(tv_NumberPopup_7.getText().toString());
                }
                break;
            case R.id.tv_NumberPopup_8:
                if (listener != null) {
                    listener.onChooseNum(tv_NumberPopup_8.getText().toString());
                }
                break;
            case R.id.tv_NumberPopup_9:
                if (listener != null) {
                    listener.onChooseNum(tv_NumberPopup_9.getText().toString());
                }
                break;
            case R.id.tv_NumberPopup_0:
                if (listener != null) {
                    listener.onChooseNum(tv_NumberPopup_0.getText().toString());
                }
                break;
            case R.id.tv_NumberPopup_p:
                if (listener != null) {
                    listener.onChooseNum(tv_NumberPopup_p.getText().toString());
                }
                break;
            case R.id.iv_NumberPopup_Del:  //删除按钮
                if (listener != null) {
                    listener.onDelNum();
                }
                break;
            case R.id.tv_NumberPopup_clear:
                if (listener != null) {
                    listener.onClearNum();
                }
                break;
            case R.id.tv_NumberPopup_cancel:
                if (listener != null) {
                    listener.onCancelNum();
                }
                break;
            case R.id.tv_NumberPopup_ok:
                if (listener != null) {
                    listener.onSureNum();
                }
                break;
            default:
                break;
        }
    }

    private NumberPopup.AddListener listener = null;

    public void setListener(NumberPopup.AddListener listener) {
        this.listener = listener;
    }

    /**
     * 申明监听接口
     * Author：William（徐威）
     * Create Time：2018-10-18
     */
    public interface AddListener {
        //选择数字事件
        void onChooseNum(String strNum);

        //删除数字事件
        void onDelNum();

        //清空重输
        void onClearNum();

        //确认数字事件
        void onSureNum();

        //取消输入
        void onCancelNum();
    }
}