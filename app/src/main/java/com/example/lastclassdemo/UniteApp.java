package com.example.lastclassdemo;

import android.app.Application;

import com.example.lastclassdemo.bean.DBManager;

/**
 * @author SpreadWater
 * @Date 2020-12-09
 * @Time 11:15
 * @description 表示全局应用的类
 */
public class UniteApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //清单文件当中注册一下
        DBManager.initDB(getApplicationContext());
    }
}
