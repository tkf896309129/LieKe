package com.comexample.lieke.myapplication.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/6/14.
 */
public class ProductListBean implements Serializable {
    private int ID;
    private String Name;
    private String Pic;
    private String ToNum;
    private String ToPrice;


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

    public String getToNum() {
        return ToNum;
    }

    public void setToNum(String toNum) {
        ToNum = toNum;
    }

    public String getToPrice() {
        return ToPrice;
    }

    public void setToPrice(String toPrice) {
        ToPrice = toPrice;
    }
}
