package com.github.moshdev.themessample.attributes;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.github.moshdev.themessample.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class CheeseView extends View {

  /**
   * Cheese Type Enum Values
   */
  private static final int CHEESE_TYPE_NONE = 0;
  private static final int CHEESE_TYPE_NORMAL = 1;
  private static final int CHEESE_TYPE_DARK = 2;

  /**
   * Cheese Portion Color Enum Values
   */
  private static final int PORTION_COLOR_LIGHT = -1;
  private static final int PORTION_COLOR_DARK = -2;

  /**
   * Cheese Ingredients
   */
  private static final int INGREDIENTS_MILK = 1;
  private static final int INGREDIENTS_PEPPER = 2;
  private static final int INGREDIENTS_GARLIC = 4;
  private static final int INGREDIENTS_THYME = 8;

  private CharSequence overlayText;

  private float sweepAngle;
  private int cheeseType;

  private final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
  private final Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
  private float edibleRate;
  private String ingredientsContents;

  private Drawable manufactureLogo;

  public CheeseView(Context context) {
    this(context, null);
  }

  public CheeseView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);

    TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CheeseView);

    //Float
    sweepAngle = typedArray.getFloat(R.styleable.CheeseView_sweep_angle, 90);

    //Enum
    cheeseType = typedArray.getInt(R.styleable.CheeseView_cheese_type, CHEESE_TYPE_NONE);

    //Color & Default value Enums
    int portionColor;
    TypedValue portionColorValue = new TypedValue();
    if (typedArray.getValue(R.styleable.CheeseView_portion_color, portionColorValue)) {
      portionColor = portionColorValue.data;
      if (portionColor == PORTION_COLOR_LIGHT) {
        portionColor = 0xFF6CBB77;
      } else if (portionColor == PORTION_COLOR_DARK) {
        portionColor = 0xFF2032BB;
      }
    } else {
      portionColor = Color.RED;
    }

    //String
    overlayText = typedArray.getText(R.styleable.CheeseView_overlay_text);
    if (overlayText == null) {
      overlayText = "";
    }

    //Fraction
    edibleRate = typedArray.getFraction(R.styleable.CheeseView_rats_fraction, 20, 1, 0f);

    //Flags
    int ingredientsFlags = typedArray.getInt(R.styleable.CheeseView_ingredients, 0);
    if (ingredientsFlags != 0) {
      ArrayList<String> ingredientsList = new ArrayList<>();
      if ((ingredientsFlags & INGREDIENTS_MILK) == INGREDIENTS_MILK) {
        ingredientsList.add("Milk");
      }
      if ((ingredientsFlags & INGREDIENTS_GARLIC) == INGREDIENTS_GARLIC) {
        ingredientsList.add("Garlic");
      }
      if ((ingredientsFlags & INGREDIENTS_PEPPER) == INGREDIENTS_PEPPER) {
        ingredientsList.add("Pepper");
      }
      if ((ingredientsFlags & INGREDIENTS_THYME) == INGREDIENTS_THYME) {
        ingredientsList.add("Thyme");
      }

      ingredientsContents = Arrays.toString(ingredientsList.toArray());
    } else {
      ingredientsContents = "NOTHING";
    }

    //Reference
    manufactureLogo = typedArray.getDrawable(R.styleable.CheeseView_manufacture_logo);

    typedArray.recycle();

    paint.setStyle(Paint.Style.FILL);
    paint.setColor(portionColor);

    textPaint.setColor(Color.BLACK);
    textPaint.setTextSize(40);
    textPaint.setTextAlign(Paint.Align.CENTER);

  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    switch (cheeseType) {
      case CHEESE_TYPE_NONE:
        break;
      case CHEESE_TYPE_NORMAL:
        canvas.drawColor(Color.YELLOW);
        break;
      case CHEESE_TYPE_DARK:
        canvas.drawColor(Color.GREEN);
        break;
    }
    canvas.drawArc(0, 0, getWidth(), getHeight(), 0, sweepAngle, true, paint);

    canvas.drawText(overlayText, 0, overlayText.length(), getWidth() / 2, getHeight() / 2,
        textPaint);

    canvas.drawText(String.format(Locale.US, "%s of 20 are edible.", (int) edibleRate),
        getWidth() / 2, 50, textPaint);

    canvas.drawText(String.format(Locale.US, "Contains: %s", ingredientsContents), getWidth() / 2,
        120, textPaint);

    if (manufactureLogo != null) {
      manufactureLogo.setBounds(getLeft(), getTop(),
          getLeft() + manufactureLogo.getIntrinsicWidth(),
          getTop() + manufactureLogo.getIntrinsicHeight());
      manufactureLogo.draw(canvas);
    }
  }
}
