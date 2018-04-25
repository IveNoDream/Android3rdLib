package com.wafe.android3rdlib.custom.customseekbar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.wafe.android3rdlib.R;

/**
 * Created by wafej on 2018/4/25.
 * blog: https://blog.csdn.net/wjw_java_android/article/details/25984749
 *
 * draw Arc blog:https://blog.csdn.net/qq_18432309/article/details/51811546
 */

public class CustomRotView extends View {
    private Bitmap mRotBitmap = null;
//    private int mBitmapWidth = 0;
//    private int mBitmapHeight = 0;
//    private int mMaxWidth = 0;
    private int mOLocX = 0;
    private int mOLocY = 0;
    private float mDetaDegree = 0;
    private float mCurDegree = 0;
    private Paint mPaint = new Paint();
    public CustomRotView(Context context) {
        super(context);
    }

    public CustomRotView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomRotView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomRotView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // 它的宽高不是图片的宽高，而是以宽高为直角的矩形的对角线的长度
        //setMeasuredDimension(mMaxWidth, mMaxWidth);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float downX;
        float downY;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = event.getX();
                downY = event.getY();
                mCurDegree = detaDegree(mOLocX,mOLocY,downX,downY);
                break;
            case MotionEvent.ACTION_MOVE:
                downX = event.getX();
                downY = event.getY();
                float degree = detaDegree(mOLocX, mOLocY, downX, downY);

// 滑过的弧度增量
                float dete = degree - mCurDegree;
// 如果小于-90度说明 它跨周了，需要特殊处理350->17,
                if (dete < -270) {
                    dete = dete + 360;

// 如果大于90度说明 它跨周了，需要特殊处理-350->-17,
                } else if (dete > 270) {
                    dete = dete - 360;
                }

                //addDegree(dete);
                //控制旋转度数，如果超过360，让它求余，防止，该值过大造成越界
                mDetaDegree += dete;
                if (mDetaDegree > 360 || mDetaDegree < -360) {
                    mDetaDegree = mDetaDegree % 360;
                }

                mCurDegree = degree;
                Log.i("ssss","downXY: " + downX + "," + downY + "degree: " + mCurDegree);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:

                break;
            default:
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (null == mRotBitmap){
            setRotatDrawableResource(R.mipmap.ic_launcher);
        }

        int width = getWidth();
        int height = getHeight();

        int bitmapWidth = mRotBitmap.getWidth();
        int bitmapHeight = mRotBitmap.getHeight();

        //确定圆心坐标
        mOLocX = width/2;
        mOLocY = height/2;


        Matrix matrix = new Matrix();
// 设置转轴位置
        matrix.setTranslate((float)bitmapWidth / 2, (float)bitmapHeight / 2);
        //matrix.setTranslate((float)width / 2, (float)height / 2);

// 开始转
        matrix.preRotate(mDetaDegree);
        Log.i("ssss","mDetaDegree: " + mDetaDegree);
// 转轴还原
        matrix.preTranslate(-(float)bitmapWidth / 2, -(float)bitmapHeight / 2);
        //matrix.preTranslate(-(float)width / 2, -(float)height / 2);

// 将位置送到view的中心
        //matrix.postTranslate((float)(mMaxWidth - mBitmapWidth) / 2, (float)(mMaxWidth - mBitmapHeight) / 2);
        matrix.postTranslate((float)(width - bitmapWidth) / 2, (float)(height - bitmapHeight) / 2);

        canvas.drawBitmap(mRotBitmap, matrix,mPaint);
        //canvas.drawBitmap(mRotBitmap,0,0,mPaint);


        mPaint.setStrokeWidth(20);
        mPaint.setColor(getResources().getColor(R.color.seekbar_color));
        mPaint.setStyle(Paint.Style.STROKE);//描边
        mPaint.setStrokeCap(Paint.Cap.ROUND);//圆的
        float x = (getWidth() - getHeight() / 2) / 2;
        float y = getHeight() / 4;
        float rectWidth = (float) (Math.sqrt(bitmapWidth * bitmapWidth + bitmapHeight * bitmapHeight) + 10);
        if (rectWidth > width) {
            //means can't draw Arc
        }
        float left = (width - rectWidth) / 2;
        float top = (height - rectWidth) / 2;
        float right = left + rectWidth;
        float bottom = top + rectWidth;


        RectF oval = new RectF(left, top, right, bottom);
        canvas.drawArc(oval,-90,mDetaDegree,false,mPaint);

        super.onDraw(canvas);
    }

    public void setRotatBitmap(Bitmap bitmap) {
        mRotBitmap = bitmap;
        //initSize();
        postInvalidate();
    }

    public void setRotatDrawableResource(int id) {

        BitmapDrawable drawable = (BitmapDrawable)getContext().getResources().getDrawable(id);

        setRotatDrawable(drawable);
    }

    public void setRotatDrawable(BitmapDrawable drawable) {
        mRotBitmap = drawable.getBitmap();
        //initSize();
        postInvalidate();
    }

//    private void initSize() {
//        if (mRotBitmap == null) {
//
//// throw new NoBitMapError("Error,No bitmap in RotatView!");
//            return;
//        }
//        mBitmapWidth = mRotBitmap.getWidth();
//        mBitmapHeight = mRotBitmap.getHeight();
//
//        mMaxWidth = (int) Math.sqrt(mBitmapWidth * mBitmapWidth + mBitmapHeight * mBitmapHeight);
//        //mOLocX = mOLocY = mMaxWidth / 2;//确定圆心坐标
//        mOLocX = getWidth()/2;
//        mOLocY = getHeight()/2;
//    }

    /**
     * 通过此方法来控制旋转度数，如果超过360，让它求余，防止，该值过大造成越界
     *
     * @param added
     */
//    private void addDegree(float added) {
//        mDetaDegree += added;
//        if (mDetaDegree > 360 || mDetaDegree < -360) {
//            mDetaDegree = mDetaDegree % 360;
//        }
//
//    }

    /**
     * 计算以(src_x,src_y)为坐标圆点，建立直角体系，求出(target_x,target_y)坐标与x轴的夹角
     * 主要是利用反正切函数的知识求出夹角
     *
     * @param src_x
     * @param src_y
     * @param target_x
     * @param target_y
     * @return
     */
    float detaDegree(float src_x, float src_y, float target_x, float target_y) {

        float detaX = target_x - src_x;
        float detaY = target_y - src_y;
        double d;
        //坐标在四个象限里
        if (detaX != 0) {
            float tan = Math.abs(detaY / detaX);

            if (detaX > 0) {

                //第一象限
                if (detaY >= 0) {
                    d = Math.atan(tan);

                } else {
                    //第四象限
                    d = 2 * Math.PI - Math.atan(tan);
                }

            } else {
                if (detaY >= 0) {
                    //第二象限
                    d = Math.PI - Math.atan(tan);
                } else {
                    //第三象限
                    d = Math.PI + Math.atan(tan);
                }
            }

        } else {
            //坐标在y轴上
            if (detaY > 0) {
                //坐标在y>0上
                d = Math.PI / 2;
            } else {
                //坐标在y<0上
                d = -Math.PI / 2;
            }
        }

        return (float)((d * 180) / Math.PI);
    }
}
