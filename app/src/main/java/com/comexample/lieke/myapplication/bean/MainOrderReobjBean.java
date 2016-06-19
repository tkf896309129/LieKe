package com.comexample.lieke.myapplication.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/6/14.
 */
public class MainOrderReobjBean implements Serializable {
    private String HeadPic;
    private List<HomeBusinessListBean> HomeBusinessList;
    private List<HomeOrderListBean> HomeOrderList;
    private String MyTeamID;
    private String OpenID;
    private String RealName;
    private int islieek;
    private String lieiertel;
    private String myaddmoney;
    private String myhavemoney;
    private int mymsg;
    private String mynextcount;

    public String getHeadPic() {
        return HeadPic;
    }

    public void setHeadPic(String headPic) {
        HeadPic = headPic;
    }

    public List<HomeBusinessListBean> getHomeBusinessList() {
        return HomeBusinessList;
    }

    public void setHomeBusinessList(List<HomeBusinessListBean> homeBusinessList) {
        HomeBusinessList = homeBusinessList;
    }

    public List<HomeOrderListBean> getHomeOrderList() {
        return HomeOrderList;
    }

    public void setHomeOrderList(List<HomeOrderListBean> homeOrderList) {
        HomeOrderList = homeOrderList;
    }

    public String getMyTeamID() {
        return MyTeamID;
    }

    public void setMyTeamID(String myTeamID) {
        MyTeamID = myTeamID;
    }

    public String getOpenID() {
        return OpenID;
    }

    public void setOpenID(String openID) {
        OpenID = openID;
    }

    public String getRealName() {
        return RealName;
    }

    public void setRealName(String realName) {
        RealName = realName;
    }

    public int getIslieek() {
        return islieek;
    }

    public void setIslieek(int islieek) {
        this.islieek = islieek;
    }

    public String getLieiertel() {
        return lieiertel;
    }

    public void setLieiertel(String lieiertel) {
        this.lieiertel = lieiertel;
    }

    public String getMyaddmoney() {
        return myaddmoney;
    }

    public void setMyaddmoney(String myaddmoney) {
        this.myaddmoney = myaddmoney;
    }

    public String getMyhavemoney() {
        return myhavemoney;
    }

    public void setMyhavemoney(String myhavemoney) {
        this.myhavemoney = myhavemoney;
    }

    public int getMymsg() {
        return mymsg;
    }

    public void setMymsg(int mymsg) {
        this.mymsg = mymsg;
    }

    public String getMynextcount() {
        return mynextcount;
    }

    public void setMynextcount(String mynextcount) {
        this.mynextcount = mynextcount;
    }
}
