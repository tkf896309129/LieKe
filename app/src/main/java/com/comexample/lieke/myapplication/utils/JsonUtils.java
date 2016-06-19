package com.comexample.lieke.myapplication.utils;


import android.util.Log;

import com.comexample.lieke.myapplication.bean.HomeBusinessListBean;
import com.comexample.lieke.myapplication.bean.HomeOrderListBean;
import com.comexample.lieke.myapplication.bean.MainOrderBean;
import com.comexample.lieke.myapplication.bean.MainOrderReobjBean;
import com.comexample.lieke.myapplication.bean.ProductListBean;
import com.comexample.lieke.myapplication.bean.TeamBean;
import com.comexample.lieke.myapplication.bean.TeamListBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/14.
 */
public class JsonUtils {

    /**
     * 获取成员列表的数据
     */
    public static void getMemberData(TeamBean teamBean, String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            teamBean.setErrMsg(jsonObject.getString("ErrMsg"));
            teamBean.setPageCount(jsonObject.getInt("PageCount"));
            teamBean.setPageIndex(jsonObject.getInt("PageIndex"));

            JSONArray jsonArray = jsonObject.getJSONArray("ReList");
            List<TeamListBean> listBeans = new ArrayList<>();
            int num = jsonArray.length();
            for (int i = 0; i < num; i++) {
                TeamListBean listBean = new TeamListBean();
                listBean.setCreatetime(jsonArray.getJSONObject(i).getString("Createtime"));
                listBean.setHeadPic(jsonArray.getJSONObject(i).getString("HeadPic"));
                listBean.setOpenID(jsonArray.getJSONObject(i).getString("OpenID"));
                listBean.setRealname(jsonArray.getJSONObject(i).getString("Realname"));
                listBean.setSortdisplay(jsonArray.getJSONObject(i).getString("Sortdisplay"));
                listBean.setSortno(jsonArray.getJSONObject(i).getString("Sortno"));
                listBean.setToLastLine(jsonArray.getJSONObject(i).getString("ToLastLine"));
                listBeans.add(listBean);
            }
            teamBean.setReList(listBeans);
            teamBean.setSuccess(jsonObject.getInt("Success"));
            teamBean.setTotalCount(jsonObject.getInt("TotalCount"));
            teamBean.setTotalSum(jsonObject.getString("TotalSum"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取首页数据信息
     */
    public static void getMainOrderData(MainOrderBean mainOrderBean, String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            mainOrderBean.setErrMsg(jsonObject.getString("ErrMsg"));
            JSONObject jsonObject1 = jsonObject.getJSONObject("ReObj");
            MainOrderReobjBean reobjBean = new MainOrderReobjBean();
            //商家列表
            JSONArray jsonArray = jsonObject1.getJSONArray("HomeBusinessList");
            reobjBean.setHeadPic(jsonObject1.getString("HeadPic"));
            List<HomeBusinessListBean> businessListBeans = new ArrayList<>();
            int num1 = jsonArray.length();
            for (int i = 0; i < num1; i++) {
                HomeBusinessListBean businessListBean = new HomeBusinessListBean();
                businessListBean.setBusinessOpenID(jsonArray.getJSONObject(i).getString("BusinessOpenID"));
                businessListBean.setID(jsonArray.getJSONObject(i).getInt("ID"));
                businessListBean.setName(jsonArray.getJSONObject(i).getString("Name"));
                businessListBean.setPic(jsonArray.getJSONObject(i).getString("Pic"));
                businessListBeans.add(businessListBean);
            }
            reobjBean.setHomeBusinessList(businessListBeans);

            //商品列表
            JSONArray jsonArray1 = jsonObject1.getJSONArray("HomeOrderList");
            List<HomeOrderListBean> homeOrderListBeans = new ArrayList<>();
            int num2 = jsonArray1.length();
            for (int i = 0; i < num2; i++) {
                HomeOrderListBean homeOrderListBean = new HomeOrderListBean();
                homeOrderListBean.setBusinessAddress(jsonArray1.getJSONObject(i).getString("BusinessAddress"));
                homeOrderListBean.setBusinessLbsLat(jsonArray1.getJSONObject(i).getString("BusinessLbsLat"));
                homeOrderListBean.setBusinessLbsLong(jsonArray1.getJSONObject(i).getString("BusinessLbsLong"));
                homeOrderListBean.setBusinessName(jsonArray1.getJSONObject(i).getString("BusinessName"));
                homeOrderListBean.setBusinessPic(jsonArray1.getJSONObject(i).getString("BusinessPic"));
                homeOrderListBean.setBusinessTel(jsonArray1.getJSONObject(i).getString("BusinessTel"));
                homeOrderListBean.setBuyerHeadPic(jsonArray1.getJSONObject(i).getString("BuyerHeadPic"));
                homeOrderListBean.setBuyerOpenID(jsonArray1.getJSONObject(i).getString("BuyerOpenID"));
                homeOrderListBean.setBuyerRealname(jsonArray1.getJSONObject(i).getString("BuyerRealname"));
                homeOrderListBean.setExpressName(jsonArray1.getJSONObject(i).getString("ExpressName"));
                homeOrderListBean.setExpressNo(jsonArray1.getJSONObject(i).getString("ExpressNo"));
                homeOrderListBean.setExpressTime(jsonArray1.getJSONObject(i).getString("ExpressTime"));
                homeOrderListBean.setFatherHeadPic(jsonArray1.getJSONObject(i).getString("FatherHeadPic"));
                homeOrderListBean.setFatherOpenID(jsonArray1.getJSONObject(i).getString("FatherOpenID"));
                homeOrderListBean.setFatherRealname(jsonArray1.getJSONObject(i).getString("FatherRealname"));
                homeOrderListBean.setFatherTimes(jsonArray1.getJSONObject(i).getString("FatherTimes"));
                homeOrderListBean.setFuwuHeadPic(jsonArray1.getJSONObject(i).getString("FuwuHeadPic"));
                homeOrderListBean.setFuwuOpenID(jsonArray1.getJSONObject(i).getString("FuwuOpenID"));
                homeOrderListBean.setFuwuRealname(jsonArray1.getJSONObject(i).getString("FuwuRealname"));
                homeOrderListBean.setFuwuTimes(jsonArray1.getJSONObject(i).getString("FuwuTimes"));
                homeOrderListBean.setMyTimes(jsonArray1.getJSONObject(i).getString("MyTimes"));
                homeOrderListBean.setOrderFrom(jsonArray1.getJSONObject(i).getString("OrderFrom"));
                homeOrderListBean.setOrderID(jsonArray1.getJSONObject(i).getString("OrderID"));
                homeOrderListBean.setOrderPrice(jsonArray1.getJSONObject(i).getString("OrderPrice"));
                homeOrderListBean.setOrderState(jsonArray1.getJSONObject(i).getString("OrderState"));
                homeOrderListBean.setOrderStatePic(jsonArray1.getJSONObject(i).getString("OrderStatePic"));
                homeOrderListBean.setOrderTime(jsonArray1.getJSONObject(i).getString("OrderTime"));
                homeOrderListBean.setOrderType(jsonArray1.getJSONObject(i).getString("OrderType"));

                //商品详情
                JSONArray jsonArray2 = jsonArray1.getJSONObject(i).getJSONArray("ProductList");
                List<ProductListBean> productListBeans = new ArrayList<>();
                int num3 = jsonArray2.length();
                for (int j = 0; j < num3; j++) {
                    ProductListBean productListBean = new ProductListBean();
                    productListBean.setID(jsonArray2.getJSONObject(j).getInt("ID"));
                    productListBean.setName(jsonArray2.getJSONObject(j).getString("Name"));
                    productListBean.setPic(jsonArray2.getJSONObject(j).getString("Pic"));
                    productListBean.setToNum(jsonArray2.getJSONObject(j).getString("ToNum"));
                    productListBean.setToPrice(jsonArray2.getJSONObject(j).getString("ToPrice"));
                    productListBeans.add(productListBean);
                }
                homeOrderListBean.setProductList(productListBeans);


                homeOrderListBean.setToFatherScore(jsonArray1.getJSONObject(i).getString("ToFatherScore"));
                homeOrderListBean.setToFuwuScore(jsonArray1.getJSONObject(i).getString("ToFuwuScore"));
                homeOrderListBeans.add(homeOrderListBean);
            }
            reobjBean.setHomeOrderList(homeOrderListBeans);


            reobjBean.setMyTeamID(jsonObject1.getString("MyTeamID"));
            reobjBean.setOpenID(jsonObject1.getString("OpenID"));
            reobjBean.setIslieek(jsonObject1.getInt("islieek"));
            reobjBean.setLieiertel(jsonObject1.getString("lieiertel"));
            reobjBean.setMyaddmoney(jsonObject1.getString("myaddmoney"));
            reobjBean.setMyhavemoney(jsonObject1.getString("myhavemoney"));
            reobjBean.setMymsg(jsonObject1.getInt("mymsg"));
            reobjBean.setMynextcount(jsonObject1.getString("mynextcount"));
            mainOrderBean.setReObj(reobjBean);
            mainOrderBean.setSuccess(jsonObject.getInt("Success"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
