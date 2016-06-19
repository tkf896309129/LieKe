package com.comexample.lieke.myapplication.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.xutils.x;

/**
 * Created by kaifeng on 2016/6/12.
 */
public class BaseFragment extends Fragment {
    private Context context;


    /**
     * 获取上下文
     *
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return x.view().inject(this, inflater, container);
    }

    /**
     * 调用onCreateView 方法
     * 先执行onCreateView 再执行onViewCreated
     */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initView();
        initData();
    }

    /**
     * 处理数据
     */
    private void initData() {

    }

    /**
     * 处理ui
     */
    private void initView() {

    }
}
