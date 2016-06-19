package com.comexample.lieke.myapplication.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/6/16.
 */
public class TeamListBean implements Serializable {
    private String Createtime;
    private String HeadPic;
    private String OpenID;
    private String Realname;
    private String Sortdisplay;
    private String Sortno;
    private String ToLastLine;


    public String getCreatetime() {
        return Createtime;
    }

    public void setCreatetime(String createtime) {
        Createtime = createtime;
    }

    public String getHeadPic() {
        return HeadPic;
    }

    public void setHeadPic(String headPic) {
        HeadPic = headPic;
    }

    public String getOpenID() {
        return OpenID;
    }

    public void setOpenID(String openID) {
        OpenID = openID;
    }

    public String getRealname() {
        return Realname;
    }

    public void setRealname(String realname) {
        Realname = realname;
    }

    public String getSortdisplay() {
        return Sortdisplay;
    }

    public void setSortdisplay(String sortdisplay) {
        Sortdisplay = sortdisplay;
    }

    public String getSortno() {
        return Sortno;
    }

    public void setSortno(String sortno) {
        Sortno = sortno;
    }

    public String getToLastLine() {
        return ToLastLine;
    }

    public void setToLastLine(String toLastLine) {
        ToLastLine = toLastLine;
    }
}
