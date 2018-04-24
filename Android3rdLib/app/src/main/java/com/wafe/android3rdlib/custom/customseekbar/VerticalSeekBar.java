package com.wafe.android3rdlib.custom.customseekbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SeekBar;

import com.wafe.android3rdlib.R;
import com.wafe.android3rdlib.util.LogUtils;

/**
 * Created by wafej on 2018/4/19.
 */

@SuppressLint("AppCompatCustomView")
public class VerticalSeekBar extends SeekBar {
    public VerticalSeekBar(Context context) {
        super(context);
    }

    public VerticalSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VerticalSeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public VerticalSeekBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredHeight(),getMeasuredWidth());
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {

        Paint paint = new Paint();
        paint.setAntiAlias(true);//设置抗锯齿
        paint.setTextSize(100);//设置文字大小
        paint.setColor(Color.BLACK);//设置文字颜色

        //setTextLocation();//定位文本绘制的位置
        Rect rect_seek = this.getProgressDrawable().getBounds();
        LogUtils.i("ssss","rect_seek before: " + rect_seek);
        //定位文字背景图片的位置
        float bm_x = rect_seek.width() - rect_seek.width() * getProgress() / getMax();
        float bm_y = rect_seek.height()/2;
//        //计算文字的中心位置在bitmap
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        int img_width = bitmap.getWidth();
        int img_height = bitmap.getHeight();
        Paint.FontMetrics fm = paint.getFontMetrics();
        //文本的宽度
        String mTitleText = "125";

        float numTextWidth = paint.measureText(mTitleText);

        canvas.drawBitmap(bitmap, bm_y, bm_x, paint);//画背景图
        //LogUtils.i("ssss","bitmap: " + bm_x + "," + bm_y + "img: " + img_width + "," + img_height + "text: " + numTextWidth + "," + height);

        float text_height = fm.descent - fm.ascent;
        LogUtils.i("ssss","textW: " + numTextWidth + " textH: " +text_height);
        float tx = bm_x + img_width/2 + text_height/2 - text_height /5;//(img_height - text_height)/2 + text_height;//baseline(paint,bm_x + img_width);//bm_x + (img_width - numTextWidth) / 2;
        float ty = bm_y + img_height/2 - numTextWidth/2;//(img_width - numTextWidth)/2 + numTextWidth;//baseline(paint,bm_y + img_height);//bm_y + (img_height - text_height)/2 + text_height;//+ (img_height - txHeight)/2 + txHeight;
        canvas.drawText(mTitleText, ty, tx, paint);//画文字
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(30);
        canvas.drawPoint(bm_y+img_height,bm_x+img_width/2,paint);




        //canvas.rotate(-90);
        //canvas.translate(-1 * getHeight(),0);
        LogUtils.i("ssss","rect_seek before: " + this.getProgressDrawable().getBounds());
        super.onDraw(canvas);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(h, w, oldh, oldw);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_MOVE:
                setProgress(getMax() - (int)(getMax() * event.getY() / getHeight()));
                onSizeChanged(getWidth(),getHeight(),0,0);
                break;
            case MotionEvent.ACTION_CANCEL:
                break;
        }
        return true;
    }

    @Override
    public void setThumb(Drawable thumb) {
        super.setThumb(thumb);
    }

    /**
     * 计算绘制文字基线
     * @param p paint
     * @param centerY 中线
     * @return
     */
    private float baseline(Paint p, float centerY) {
        Paint.FontMetrics fontMetrics = p.getFontMetrics();
        float height = fontMetrics.descent - fontMetrics.ascent;
        float top = centerY - height/2;
        return top - fontMetrics.ascent;
    }

}
