package com.moshx.threadsample;


import android.app.Application;

public class SampleApplication extends Application {

  public SampleApplication() {

    int id=0;

    for (Thread thread : Thread.getAllStackTraces().keySet()) {
      System.out.println(id++ + "- thread = " + thread + " id:"+ thread.getId() + " daemon:"+ thread.isDaemon());
    }
  }
}
