package com.wafe.android3rdlib.custom.customseekbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.wafe.android3rdlib.R;

/**
 * Created by wafej on 2018/4/19.
 */

public class CustomSeekbarView extends View {
    private int mColor = getResources().getColor(R.color.seekbar_color);
    private int mPaintWidth = 10;
    private int mLength = 100;
    private int mCurValue = 30;
    private Paint mPaint = new Paint();
    private int mStep = 1;
    public CustomSeekbarView(Context context) {
        super(context);
    }

    public CustomSeekbarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomSeekbarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomSeekbarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = this.getWidth();
        int height = this.getHeight();

        int startX = 0;
        int startY = 0;
        int stopX = 0;
        int stopY = 0;
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(mPaintWidth);
        mPaint.setStyle(Paint.Style.STROKE);//描边
        mPaint.setStrokeCap(Paint.Cap.ROUND);//圆的
        startX = width/2;
        startY = height/2;
        stopX = startX;
        stopY = height * (mLength - mCurValue) / mLength;
        if (stopY == startY) {
            canvas.drawPoint(startX,startY,mPaint);
        } else {
            canvas.drawLine(startX, startY, stopX, stopY, mPaint);
        }
        if (stopY > startY) {
            canvas.drawLine(stopX, stopY,stopX - 50,stopY - 50, mPaint);
            canvas.drawLine(stopX, stopY,stopX + 50,stopY - 50, mPaint);
        } else if (stopY < startY) {
            canvas.drawLine(stopX, stopY,stopX - 50,stopY + 50, mPaint);
            canvas.drawLine(stopX, stopY,stopX + 50,stopY + 50, mPaint);
        }
    }

    public void setColor(int color){
        mColor = color;
    }

    public void setwidth(int width) {
        mPaintWidth = width;
    }

    public void setLength(int length) {
        mLength = length;
    }

    public void setCurValue(int value) {
        mCurValue = value;
    }

    public void update(int value) {
        mCurValue = value;
        invalidate();
    }
}
