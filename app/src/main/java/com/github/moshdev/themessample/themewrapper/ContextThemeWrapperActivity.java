package com.github.moshdev.themessample.themewrapper;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.moshdev.themessample.R;

public class ContextThemeWrapperActivity extends AppCompatActivity {

  private LinearLayout viewsLayout;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_context_theme_wrapper);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    viewsLayout = (LinearLayout) findViewById(R.id.viewsLayout);
  }

  public void addNormalView(View view) {
    TextView textView = createTextView(this);
    viewsLayout.addView(textView);
  }

  public void addThemedView(View view) {
    ContextThemeWrapper themedContext = new ContextThemeWrapper(this, R.style.AppTheme);
    TextView textView = createTextView(themedContext);
    viewsLayout.addView(textView);
  }

  private TextView createTextView(Context context) {
    AppCompatTextView textView = new AppCompatTextView(context);
    textView.setText(R.string.lorem);
    return textView;
  }

  public void clearViews(View view) {
    viewsLayout.removeAllViews();
  }
}
