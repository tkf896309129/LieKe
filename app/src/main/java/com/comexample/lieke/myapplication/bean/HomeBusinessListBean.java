package com.comexample.lieke.myapplication.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/6/14.
 */
public class HomeBusinessListBean implements Serializable {
    private String BusinessOpenID;
    private int ID;
    private String Name;
    private String Pic;

    public String getBusinessOpenID() {
        return BusinessOpenID;
    }

    public void setBusinessOpenID(String businessOpenID) {
        BusinessOpenID = businessOpenID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPic() {
        return Pic;
    }

    public void setPic(String pic) {
        Pic = pic;
    }
}
