package com.github.moshdev.themessample.appcompat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.moshdev.themessample.R;

public class MaterialActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_material);
  }
}
