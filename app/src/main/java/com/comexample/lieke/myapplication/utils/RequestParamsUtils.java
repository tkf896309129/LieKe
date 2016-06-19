package com.comexample.lieke.myapplication.utils;

import org.xutils.http.RequestParams;

/**
 * Created by kaifeng on 2016/6/14.
 */
public class RequestParamsUtils {

    private static RequestParams params;

    public static RequestParams getRequsetParams(String path) {
        params = new RequestParams(path);
        return params;
    }
}
