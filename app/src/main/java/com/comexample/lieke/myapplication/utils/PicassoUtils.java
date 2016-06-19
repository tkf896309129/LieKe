package com.comexample.lieke.myapplication.utils;

import android.content.Context;
import android.widget.ImageView;

import com.comexample.lieke.myapplication.R;
import com.comexample.lieke.myapplication.view.CircleTransform;
import com.squareup.picasso.Picasso;

/**
 * Created by Administrator on 2016/6/16.
 */
public class PicassoUtils {

    /**
     * 加载图片
     */
    public static void loadImage(Context context, String url, ImageView imageView) {
        Picasso.with(context).load(url).fit().placeholder(R.mipmap.moren).into(imageView);
    }

    /**
     * 加载圆形图片
     */
    public static void loadCircleImage(Context context, String url, ImageView imageView) {
        Picasso.with(context).load(url).transform(new CircleTransform()).into(imageView);
    }
}
