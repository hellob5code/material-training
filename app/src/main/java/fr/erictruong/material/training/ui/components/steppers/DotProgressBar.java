package fr.erictruong.material.training.ui.components.steppers;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import fr.erictruong.android.core.util.MathUtils;
import fr.erictruong.android.core.util.ThemeUtils;
import fr.erictruong.material.training.R;

public class DotProgressBar extends View {

    private Paint mPaintFill = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private int mProgress;
    private int mDotCount;

    private boolean mIndeterminate;

    private int mRadius;
    private int mMargin;
    private int widthSize, heightSize;
    private Handler mHandler = new Handler();

    public DotProgressBar(Context context) {
        super(context);
        initProgressBar(context);
    }

    public DotProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initProgressBar(context);
    }

    public DotProgressBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initProgressBar(context);
    }

    private void initProgressBar(Context context) {
        mRadius = context.getResources().getDimensionPixelSize(R.dimen.circle_indicator_radius);
        mMargin = context.getResources().getDimensionPixelSize(R.dimen.circle_indicator_margin);

        // dot fill color
        mPaintFill.setStyle(Paint.Style.FILL);
        mPaintFill.setColor(ThemeUtils.obtainColorPrimary(context));
        // dot background color
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(ContextCompat.getColor(context, R.color.material_divider));

        mDotCount = 5;
        mProgress = 0;
        mIndeterminate = false;
    }

    public boolean isIndeterminate() {
        return mIndeterminate;
    }

    public void setIndeterminate(boolean indeterminate) {
        this.mIndeterminate = indeterminate;
        if (indeterminate) {
            start();
        } else {
            stop();
        }
    }

    public void setMax(int max) {
        mDotCount = max;
    }

    public void start() {
        mProgress = -1;
        mHandler.removeCallbacks(mRunnable);
        mHandler.post(mRunnable);
    }

    public void stop() {
        mHandler.removeCallbacks(mRunnable);
    }

    private int step = 1;
    private Runnable mRunnable = new Runnable() {

        @Override
        public void run() {
            mProgress += step;
            if (mProgress < 0) {
                mProgress = 1;
                step = 1;
            } else if (mProgress > (mDotCount - 1)) {
                if ((mDotCount - 2) >= 0) {
                    mProgress = mDotCount - 2;
                    step = -1;
                } else {
                    mProgress = 0;
                    step = 1;
                }
            }

            invalidate();
            mHandler.postDelayed(mRunnable, 200);
        }
    };

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        widthSize = MeasureSpec.getSize(widthMeasureSpec);
        heightSize = (int) mRadius * 2 * 2 + getPaddingBottom() + getPaddingTop();
        setMeasuredDimension(widthSize, heightSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float dX = (widthSize - mDotCount * mRadius * 2 - (mDotCount - 1) * mMargin) / 2.0f;
        float dY = heightSize / 2;
        for (int i = 0; i < mDotCount; i++) {
            if (i == mProgress) {
                canvas.drawCircle(dX, dY, mRadius * 2, mPaintFill);
            } else {
                canvas.drawCircle(dX, dY, mRadius, mPaint);
            }
            dX += (2 * mRadius + mMargin);
        }
    }

    public void setProgress(int progress) {
        progress = MathUtils.constrain(progress, 0, mDotCount);
        mProgress = progress;
        invalidate();
    }
}
