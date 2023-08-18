package com.jac.mpdemo.entity;

import com.baomidou.mybatisplus.annotation.TableId;

public class PlanApplyInfo {

    @TableId
    private int supplyDetailId;
    private int applyId;
    private String productArea;
    private String productName;

    public int getSupplyDetailId() {
        return supplyDetailId;
    }

    public void setSupplyDetailId(int supplyDetailId) {
        this.supplyDetailId = supplyDetailId;
    }

    public int getApplyId() {
        return applyId;
    }

    public void setApplyId(int applyId) {
        this.applyId = applyId;
    }

    public String getProductArea() {
        return productArea;
    }

    public void setProductArea(String productArea) {
        this.productArea = productArea;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "PlanApplyInfo{" +
                "supplyDetailId=" + supplyDetailId +
                ", applyId=" + applyId +
                ", productArea='" + productArea + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }
}
