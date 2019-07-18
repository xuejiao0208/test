package com.example.demo.entity;

public class Nav {
    private String navId;

    private String navName;

    private Integer navFeight;

    public String getNavId() {
        return navId;
    }

    public void setNavId(String navId) {
        this.navId = navId == null ? null : navId.trim();
    }

    public String getNavName() {
        return navName;
    }

    public void setNavName(String navName) {
        this.navName = navName == null ? null : navName.trim();
    }

    public Integer getNavFeight() {
        return navFeight;
    }

    public void setNavFeight(Integer navFeight) {
        this.navFeight = navFeight;
    }
}