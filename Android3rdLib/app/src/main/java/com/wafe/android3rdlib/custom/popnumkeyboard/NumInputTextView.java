package com.wafe.android3rdlib.custom.popnumkeyboard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.wafe.android3rdlib.util.DisplayUtil;

/**
 * Created by wangfeng2@siasun.com on 2019/2/14.
 */
@SuppressLint("AppCompatCustomView")
public class NumInputTextView extends TextView {
    private Context mContext;
    private NumberPopup mNumPopWindow;
    private String mLastNum;
    private boolean mIsOKClick = false;
    public NumInputTextView(Context context) {
        super(context);
        initInputView(context,null);
    }

    public NumInputTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initInputView(context, attrs);
    }

    public NumInputTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInputView(context, attrs);
    }

    public NumInputTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInputView(context, attrs);
    }

    private void initInputView(Context context, AttributeSet attrs) {
        mContext = context;
        setSingleLine(true);
        setOnTouchListener(mTouchListener);
    }

    private OnTouchListener mTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {

            if (mNumPopWindow != null) {
                mNumPopWindow.dismiss();
                mNumPopWindow = null;
            }
            mLastNum = getText().toString().trim();
            mIsOKClick = false;
            mNumPopWindow = new NumberPopup(mContext, view, 0, 0);

            mNumPopWindow.showAsDropDown(view,0,0);
            mNumPopWindow.setListener(new NumberPopup.AddListener() {
                /**
                 * 重写数组选择事件
                 * Author：William（徐威）
                 * Create Time：2018-10-18
                 * @param strNum
                 */
                @Override
                public void onChooseNum(String strNum) {
                    String strProductId = getText().toString();
                    setText(String.format("%s%s", strProductId, strNum));
                    setGravity(Gravity.CENTER);
                }

                /**
                 * 重写数字删除事件
                 * Author：William（徐威）
                 * Create Time：2018-10-18
                 */
                @Override
                public void onDelNum() {
                    String strProductId = getText().toString();
                    if(!TextUtils.isEmpty(strProductId)){
                        setText(strProductId.substring(0, strProductId.length() - 1));
                    }
                }

                @Override
                public void onClearNum() {
                    setText("");
                }

                @Override
                public void onSureNum() {
                    mIsOKClick = true;
                    mNumPopWindow.dismiss();
                }

                @Override
                public void onCancelNum() {
                    mNumPopWindow.dismiss();
                }
            });

            mNumPopWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    if (mIsOKClick) {
                        return;
                    }
                    if (!TextUtils.isEmpty(mLastNum)) {
                        setText(mLastNum);
                    } else {
                        setText("");
                    }
                }
            });
            return false;
        }
    };
}
