package com.github.moshdev.themessample.attributes;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.github.moshdev.themessample.R;

public class CheeseView extends View {

  private float sweepAngle;

  private final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

  public CheeseView(Context context) {
    this(context, null);
  }

  public CheeseView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);

    TypedArray typedArray = context.obtainStyledAttributes(attrs,
        new int[]{R.attr.cheese_portion});
    sweepAngle = typedArray.getFloat(0, 90f);
    typedArray.recycle();

    paint.setStyle(Paint.Style.FILL);
    paint.setColor(Color.RED);

  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    canvas.drawArc(0, 0, getWidth(), getHeight(), 0, sweepAngle, true, paint);
  }
}
