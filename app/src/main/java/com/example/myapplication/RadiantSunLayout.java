package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.core.content.ContextCompat;



//外阴影按钮


public class RadiantSunLayout extends LinearLayout {

    private Paint radiantSunPaint = new Paint();
    private float centreX;
    private float centreY;
    private float radius;

    public RadiantSunLayout(Context context) {
        super(context);
    }

    public RadiantSunLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (centreX == 0 || centreY == 0) {
            centreX = getWidth() / 2;
            centreY = getHeight() / 2;
            radius = Math.min(getWidth(), getHeight()) / 2;
        }

        radiantSunPaint.setShader(new RadialGradient(centreX, centreY, radius,
                Color.parseColor("#0084FF"),
                ContextCompat.getColor(getContext(), android.R.color.transparent),
                Shader.TileMode.CLAMP));
        canvas.drawCircle(centreX, centreY, radius, radiantSunPaint);
        super.onDraw(canvas);
    }
}