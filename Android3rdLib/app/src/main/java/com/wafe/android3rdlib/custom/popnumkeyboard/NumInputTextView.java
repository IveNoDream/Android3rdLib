package com.wafe.android3rdlib.custom.popnumkeyboard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.wafe.android3rdlib.util.DisplayUtil;

/**
 * Created by wangfeng2@siasun.com on 2019/2/14.
 */
@SuppressLint("AppCompatCustomView")
public class NumInputTextView extends TextView {
    private Context mContext;
    private NumberPopup mNumPopWindow;
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
        setOnTouchListener(mTouchListener);
    }

    private OnTouchListener mTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {

            if (mNumPopWindow != null) {
                mNumPopWindow.dismiss();
                mNumPopWindow = null;
            }
            mNumPopWindow = new NumberPopup(mContext, view, 0, 0);


            int windowPos[] = calculatePopWindowPos(view, view);
            int xOff = 20;
            windowPos[0] -= xOff;

            mNumPopWindow.showAsDropDown(view);
            //mNumPopWindow.showAtLocation(view, Gravity.TOP | Gravity.RIGHT, 0, 155);
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
                public void onSureNum() {
                }
            });
            return false;
        }
    };


    /**
     * 计算出来的位置，y方向就在anchorView的上面和下面对齐显示，x方向就是与屏幕右边对齐显示
     * 如果anchorView的位置有变化，就可以适当自己额外加入偏移来修正
     * @param anchorView  呼出window的view
     * @param contentView   window的内容布局
     * @return window显示的左上角的xOff,yOff坐标
     */
    private static int[] calculatePopWindowPos(final View anchorView, final View contentView) {
        final int windowPos[] = new int[2];
        final int anchorLoc[] = new int[2];
        // 获取锚点View在屏幕上的左上角坐标位置
        anchorView.getLocationOnScreen(anchorLoc);
        final int anchorHeight = anchorView.getHeight();
        // 获取屏幕的高宽
        final int screenHeight = DisplayUtil.getScreenHeight(anchorView.getContext());
        final int screenWidth = DisplayUtil.getScreenWidth(anchorView.getContext());
        contentView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        // 计算contentView的高宽
        final int windowHeight = contentView.getMeasuredHeight();
        final int windowWidth = contentView.getMeasuredWidth();
        // 判断需要向上弹出还是向下弹出显示
        final boolean isNeedShowUp = (screenHeight - anchorLoc[1] - anchorHeight < windowHeight);
        if (isNeedShowUp) {
            windowPos[0] = screenWidth - windowWidth;
            windowPos[1] = anchorLoc[1] - windowHeight;
        } else {
            windowPos[0] = screenWidth - windowWidth;
            windowPos[1] = anchorLoc[1] + anchorHeight;
        }
        return windowPos;
    }
}
