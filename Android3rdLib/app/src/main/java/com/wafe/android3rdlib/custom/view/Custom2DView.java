package com.wafe.android3rdlib.custom.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by root on 8/8/17.
 */

public class Custom2DView extends View {
    private Paint mPaint = new Paint();
    private int WIDTH = 0;
    private int HEIHT = 0;
    public Custom2DView(Context context) {
        super(context);
    }

    public Custom2DView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Custom2DView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Custom2DView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        WIDTH = getWidth();
        HEIHT = getHeight();

        //draw point
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
        int startX = 0;
        int startY = 0;
        int stopX = 0;
        int stopY = 0;
        startX = 25;
        startY = 25;
        canvas.drawPoint(startX,startY,mPaint);

        mPaint.setStyle(Paint.Style.FILL);
        startX = WIDTH/4;
        startY = HEIHT/4;
        canvas.drawPoint(startX,startY,mPaint);

        //draw line
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(5);
        startX = WIDTH/4;
        startY = 0;
        stopX = WIDTH/2;
        stopY = HEIHT/4;

        canvas.drawLine(startX,startY,stopX,stopY,mPaint);

        //draw rect
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(2);
        canvas.drawRect(WIDTH/2+ 10, 0 + 10, WIDTH/4 * 3 - 10, HEIHT/4 - 10,mPaint);

        canvas.drawRoundRect(WIDTH/4 * 3 + 10, 0 + 10, WIDTH - 10, HEIHT/4 - 10,10, 20,mPaint);

        //draw circle
        canvas.drawCircle(WIDTH/4/2,HEIHT/4/2,30,mPaint);

        //draw Arc
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(0, HEIHT/4,WIDTH/4, HEIHT/2,0,120,false,mPaint);
        canvas.drawArc(WIDTH/4, HEIHT/4,WIDTH/2, HEIHT/2,0,150,true,mPaint);

        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawArc(WIDTH/2, HEIHT/4,WIDTH/4 * 3, HEIHT/2,0,80,false,mPaint);
        canvas.drawArc(WIDTH/4 * 3, HEIHT/4,WIDTH, HEIHT/2,0,90,true,mPaint);

        //draw Oval
        canvas.drawOval(0,HEIHT/2,WIDTH/4,HEIHT/4 * 3,mPaint);

        //draw text
        canvas.drawText("HELLO",WIDTH/4,HEIHT/4 * 3 + 20,mPaint);

        //draw pos text
        //canvas.drawPosText("Hello",new float[]{});

        //draw path
        Path path = new Path();
        path.moveTo(WIDTH/2,HEIHT/4 * 3);
        path.lineTo(WIDTH/2 + 50,HEIHT/4 * 3 + 30);
        path.lineTo(WIDTH - 100, HEIHT - 50);
        path.lineTo(50,HEIHT/4 * 3 + 50);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path,mPaint);
    }
}
