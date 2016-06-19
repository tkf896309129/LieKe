package com.comexample.lieke.myapplication;

import android.app.Application;

import org.xutils.x;

/**
 * Created by kaifeng on 2016/6/12.
 */
public class BaseApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);
    }
}
