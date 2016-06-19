package com.comexample.lieke.myapplication.utils;

import android.content.Context;
import android.widget.Toast;

import com.comexample.lieke.myapplication.adapter.OrderMainAdapter;
import com.comexample.lieke.myapplication.adapter.TeamAdapter;
import com.comexample.lieke.myapplication.bean.HomeOrderListBean;
import com.comexample.lieke.myapplication.bean.MainOrderBean;
import com.comexample.lieke.myapplication.bean.TeamBean;
import com.comexample.lieke.myapplication.bean.TeamListBean;
import com.comexample.lieke.myapplication.constant.Constant;
import com.comexample.lieke.myapplication.constant.FieldConstant;
import com.comexample.lieke.myapplication.constant.OperatorConstant;

import org.xutils.common.Callback;
import org.xutils.x;

import java.util.List;

/**
 * Created by kaifeng on 2016/6/14.
 */
public class HttpUtils {

    /**
     * 请求主界面数据
     */
    public static void getMainOrderData(final Context context, String phone, final OrderMainAdapter adapter, final List<HomeOrderListBean> orderList) {
        orderList.clear();
        x.http().get(RequestParamsUtils.getRequsetParams(Constant.URL + OperatorConstant.HOME
                + FieldConstant.SIGN + "=" + "&" + FieldConstant.OPEN_ID + "=" + phone), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                MainOrderBean orderBean = new MainOrderBean();
                JsonUtils.getMainOrderData(orderBean, result);
                orderList.addAll(orderBean.getReObj().getHomeOrderList());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Toast.makeText(context, Constant.ERROR_MSG, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }


    /**
     * 获取团队数据
     */
    public static void getTeamData(final Context context, String phone, final List<TeamListBean> list, final TeamAdapter teamAdapter, int page, int sort) {
        list.clear();
        x.http().get(RequestParamsUtils.getRequsetParams(Constant.URL + OperatorConstant.GET_TEAM_LIST + FieldConstant.OPEN_ID + "="
                + phone + "&" + FieldConstant.PAGE + "=" + page + "&" + FieldConstant.SORT_BY + "=" + sort), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                TeamBean teamBean = new TeamBean();
                JsonUtils.getMemberData(teamBean, result);
                list.addAll(teamBean.getReList());
                teamAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Toast.makeText(context, Constant.ERROR_MSG, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

}
