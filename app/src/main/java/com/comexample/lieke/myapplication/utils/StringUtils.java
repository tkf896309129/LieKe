package com.comexample.lieke.myapplication.utils;

/**
 * Created by Administrator on 2016/6/16.
 */
public class StringUtils {

    /**
     * 判断字符串不为空
     */
    public static boolean isNoEmpty(String str) {
        return str != null && !str.equals(" ") && !str.equals("");
    }

}
