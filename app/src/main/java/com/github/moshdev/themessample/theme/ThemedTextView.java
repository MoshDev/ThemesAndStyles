package com.github.moshdev.themessample.theme;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;


public class ThemedTextView extends AppCompatTextView {

  public ThemedTextView(Context context) {
    super(context);
  }

  public ThemedTextView(Context context, AttributeSet attrs) {
    super(context, attrs);
    System.out.println(this + " received context: " + context);
  }

  public ThemedTextView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }
}
