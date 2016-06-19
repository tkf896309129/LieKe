package com.comexample.lieke.myapplication.ui;

import com.comexample.lieke.myapplication.R;
import com.comexample.lieke.myapplication.adapter.TeamAdapter;
import com.comexample.lieke.myapplication.bean.TeamListBean;
import com.comexample.lieke.myapplication.constant.Constant;
import com.comexample.lieke.myapplication.utils.HttpUtils;
import com.comexample.lieke.myapplication.view.OrderListView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * 我的团队
 * Created by Administrator on 2016/6/16.
 */
@ContentView(R.layout.activity_my_team)
public class MyTeamActivity extends BaseActivity {
    @ViewInject(R.id.lv_my_team)
    private OrderListView listView;

    private TeamAdapter teamAdapter;
    private List<TeamListBean> list;
    private int page = 1;
    private int sortBy = 0;


    @Override
    protected void initView() {
        super.initView();
        //初始话集合
        initList();
    }

    private void initList() {
        list = new ArrayList<>();
    }


    @Override
    protected void initData() {
        super.initData();
        teamAdapter = new TeamAdapter(this, list);
        listView.setAdapter(teamAdapter);
        //获取团队数据
        getTeamData();
    }

    private void getTeamData() {
        HttpUtils.getTeamData(this, Constant.getPhone(), list, teamAdapter, page, sortBy);
    }


}
