package com.k9501.house.util;

import com.k9501.house.entity.House;


//用来接收查询房子的信息
public class HouseExt extends House {
    private String dname;//区域名
    private String sname;//街道名
    private String tname;//类型名

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }
}
