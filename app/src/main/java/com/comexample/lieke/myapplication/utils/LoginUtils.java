package com.comexample.lieke.myapplication.utils;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/15.
 */
public class LoginUtils {
    public static List<View> listLogin = new ArrayList<>();

    /**
     * 添加到集合中
     */
    public static void addListView(View view) {
        listLogin.add(view);
    }


}
