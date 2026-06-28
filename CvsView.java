CvsView.java

package com.dts.Wreefiremax;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Process;
import android.view.View;

/* JADX INFO: loaded from: /tmp/decompiler/261309cd6a8f497bbd4c575abae56d8d/classes.dex */
public class CvsView extends View implements Runnable {
    Paint mRectPaint1;
    Paint mRectPaint2;
    Paint mStrokePaint;
    Paint mTextPaint;
    Thread mThread;
    long sleepTime;

    private native void drawUpdate(CvsView cvsView, Canvas canvas, int i, int i2);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CvsView(Context context) {
        super(context, null, 0);
        setFocusableInTouchMode(false);
        setBackgroundColor(0);
        Paint paint = new Paint();
        this.mStrokePaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.mStrokePaint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.mTextPaint = paint2;
        paint2.setTypeface(Typeface.MONOSPACE);
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        Paint paint3 = new Paint();
        this.mRectPaint1 = paint3;
        paint3.setTypeface(Typeface.MONOSPACE);
        this.mRectPaint1.setAntiAlias(true);
        this.mRectPaint1.setTextAlign(Paint.Align.CENTER);
        Paint paint4 = new Paint();
        this.mRectPaint2 = paint4;
        paint4.setTypeface(Typeface.MONOSPACE);
        this.mRectPaint2.setAntiAlias(true);
        this.mRectPaint2.setTextAlign(Paint.Align.CENTER);
        this.sleepTime = 16;
        Thread thread = new Thread(this);
        this.mThread = thread;
        thread.start();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            drawUpdate(this, canvas, canvas.getWidth(), canvas.getHeight());
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        while (this.mThread.isAlive() && !this.mThread.isInterrupted()) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                postInvalidate();
                Thread.sleep(Math.max(Math.min(0, this.sleepTime - (System.currentTimeMillis() - jCurrentTimeMillis)), this.sleepTime));
            } catch (InterruptedException e) {
            }
        }
    }

    public void DrawLine(Canvas canvas, int i, int i2, int i3, int i4, float f, float f2, float f3, float f4, float f5) {
        this.mStrokePaint.setColor(Color.rgb(i2, i3, i4));
        this.mStrokePaint.setAlpha(i);
        this.mStrokePaint.setStrokeWidth(f);
        canvas.drawLine(f2, f3, f4, f5, this.mStrokePaint);
    }

    public void DrawText(Canvas canvas, int i, int i2, int i3, int i4, float f, String str, float f2, float f3, float f4) {
        this.mTextPaint.setColor(Color.rgb(i2, i3, i4));
        this.mTextPaint.setAlpha(i);
        this.mTextPaint.setTextSize(f4 + 2.0f);
        canvas.drawText(str, f2, f3, this.mTextPaint);
    }

    public void DrawTextRect(Canvas canvas, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, float f, float f2) {
        this.mRectPaint1.setColor(Color.rgb(i2, i3, i4));
        this.mRectPaint1.setStrokeWidth(1.1f);
        this.mRectPaint1.setAlpha(i);
        this.mRectPaint2.setColor(Color.rgb(150, 0, 255));
        this.mRectPaint2.setStrokeWidth(1.1f);
        this.mRectPaint2.setAlpha(150);
        canvas.drawRect(f - i5, f2 - i6, f + i7, f2 + i8, this.mRectPaint1);
        canvas.drawRect(f - i9, f2 - i10, f - i11, f2 + i12, this.mRectPaint2);
    }

    public void DrawRoundRect(Canvas canvas, int i, int i2, int i3, int i4, float f, int i5, int i6, float f2, float f3, float f4, float f5) {
        this.mStrokePaint.setStrokeWidth(f);
        this.mStrokePaint.setColor(Color.rgb(i2, i3, i4));
        this.mStrokePaint.setAlpha(i);
        canvas.drawRoundRect(f2, f3, f2 + f4, f3 + f5, i5, i6, this.mStrokePaint);
    }
}
