package com.k9501.house.util;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class HouseCondition extends PageCondition {
    private String id;

    private Integer userId;

    private Integer typeId;

    private String title;

    private String description;

    private Long price;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pubdate;

    private Integer floorage;

    private String contact;

    private Integer streetId;

    private Integer ispass;

    private Integer isdel;

    private String path;

    private String floorageScope;

    private String priceScope;

    private Integer floorageFrom;

    private Integer floorageTo;

    private Long priceFrom;

    private Long priceTo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getFloorageScope() {
        return floorageScope;
    }

    public void setFloorageScope(String floorageScope) {
        this.floorageScope = floorageScope;
        //将面积范围拆分成条件并赋值
        if (floorageScope!=null&&floorageScope!=""){
            String[] floorages = floorageScope.split("-");
            this.floorageFrom=Integer.valueOf(floorages[0]);
            this.floorageTo=Integer.valueOf(floorages[1]);
        }
    }

    public String getPriceScope() {
        return priceScope;
    }

    public void setPriceScope(String priceScope) {
        this.priceScope = priceScope;
        //将价格范围拆分成条件并赋值
        if (priceScope!=null&&priceScope!=""){
            String[] prices = priceScope.split("-");
            this.priceFrom=Long.valueOf(prices[0]);
            this.priceTo=Long.valueOf(prices[1]);
        }
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public Integer getFloorage() {
        return floorage;
    }

    public void setFloorage(Integer floorage) {
        this.floorage = floorage;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Integer getStreetId() {
        return streetId;
    }

    public void setStreetId(Integer streetId) {
        this.streetId = streetId;
    }

    public Integer getIspass() {
        return ispass;
    }

    public void setIspass(Integer ispass) {
        this.ispass = ispass;
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getFloorageFrom() {
        return floorageFrom;
    }

    public void setFloorageFrom(Integer floorageFrom) {
        this.floorageFrom = floorageFrom;
    }

    public Integer getFloorageTo() {
        return floorageTo;
    }

    public void setFloorageTo(Integer floorageTo) {
        this.floorageTo = floorageTo;
    }

    public Long getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(Long priceFrom) {
        this.priceFrom = priceFrom;
    }

    public Long getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(Long priceTo) {
        this.priceTo = priceTo;
    }

    @Override
    public String toString() {
        return "HouseCondition{" +
                "id=" + id +
                ", userId=" + userId +
                ", typeId=" + typeId +
                ", title=" + title +
                ", description=" + description +
                ", price=" + price +
                ", pubdate=" + pubdate +
                ", floorage=" + floorage +
                ", contact=" + contact +
                ", streetId=" + streetId +
                ", ispass=" + ispass +
                ", isdel=" + isdel +
                ", path=" + path +
                ", floorageFrom=" + floorageFrom +
                ", floorageTo=" + floorageTo +
                ", priceFrom=" + priceFrom +
                ", priceTo=" + priceTo +
                '}';
    }
}
