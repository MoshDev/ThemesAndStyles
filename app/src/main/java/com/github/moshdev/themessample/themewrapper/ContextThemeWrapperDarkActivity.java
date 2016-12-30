package com.github.moshdev.themessample.themewrapper;

import android.content.Context;
import android.view.ContextThemeWrapper;

import com.github.moshdev.themessample.R;

public class ContextThemeWrapperDarkActivity extends ContextThemeWrapperLightActivity {

  @Override
  protected void attachBaseContext(Context newBase) {
    super.attachBaseContext(
        new ContextThemeWrapper(newBase, R.style.MaterialTheme));
  }
}
