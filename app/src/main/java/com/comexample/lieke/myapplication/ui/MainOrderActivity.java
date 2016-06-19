package com.comexample.lieke.myapplication.ui;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;

import com.comexample.lieke.myapplication.R;
import com.comexample.lieke.myapplication.adapter.OrderMainAdapter;
import com.comexample.lieke.myapplication.bean.HomeOrderListBean;
import com.comexample.lieke.myapplication.bean.MainOrderReobjBean;
import com.comexample.lieke.myapplication.constant.Constant;
import com.comexample.lieke.myapplication.utils.HttpUtils;
import com.comexample.lieke.myapplication.view.OrderListView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaifeng on 2016/6/12.
 */
@ContentView(R.layout.activity_main_order)
public class MainOrderActivity extends BaseActivity implements View.OnClickListener {
    @ViewInject(R.id.lv_order)
    private OrderListView lvOrder;
    //我的团队
    @ViewInject(R.id.rl_my_team)
    private RelativeLayout rlMyTeam;

    private OrderMainAdapter adapter;
    private List<HomeOrderListBean> orderList;

    /**
     * ui处理操作  比initData先进行
     */
    @Override
    protected void initView() {
        super.initView();
        orderList = new ArrayList<>();
        //监听事件
        addListener();
    }

    private void addListener() {
        rlMyTeam.setOnClickListener(this);
    }


    /**
     * 数据处理操作
     */
    @Override
    protected void initData() {
        super.initData();

        adapter = new OrderMainAdapter(this, orderList);
        lvOrder.setAdapter(adapter);

        //获取主界面数据
        getMainOrderData(Constant.getPhone(), adapter, orderList);
    }


    /**
     * j加载主界面数据
     */
    private void getMainOrderData(String phone, OrderMainAdapter adapter, List<HomeOrderListBean> orderList) {
        HttpUtils.getMainOrderData(this, phone, adapter, orderList);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_my_team:
                startActivity(new Intent(this, MyTeamActivity.class));
                break;
        }

    }
}
