package com.jac.mpdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

public class PlanApplyBase {
    @TableId(type = IdType.AUTO)
    private int applyId;
    private String applyCode;
    private String applyUserName;
    private int applyUserId;
    private String applyCompany;
    private String supplierCode;
    private String supplierName;

    public int getApplyId() {
        return applyId;
    }

    public void setApplyId(int applyId) {
        this.applyId = applyId;
    }

    public String getApplyCode() {
        return applyCode;
    }

    public void setApplyCode(String applyCode) {
        this.applyCode = applyCode;
    }

    public String getApplyUserName() {
        return applyUserName;
    }

    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName;
    }

    public int getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(int applyUserId) {
        this.applyUserId = applyUserId;
    }

    public String getApplyCompany() {
        return applyCompany;
    }

    public void setApplyCompany(String applyCompany) {
        this.applyCompany = applyCompany;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    @Override
    public String toString() {
        return "PlanApplyBase{" +
                "applyId=" + applyId +
                ", applyCode='" + applyCode + '\'' +
                ", applyUserName='" + applyUserName + '\'' +
                ", applyUserId=" + applyUserId +
                ", applyCompany='" + applyCompany + '\'' +
                ", supplierCode='" + supplierCode + '\'' +
                ", supplierName='" + supplierName + '\'' +
                '}';
    }
}
