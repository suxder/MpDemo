package com.jac.mpdemo.entity;

import java.util.List;

public class PlanApply {
    private int apply_id;
    private String apply_code;
    private String apply_user_name;
    private int apply_user_id;
    private String apply_company;
    private String supplier_code;
    private String supplier_name;
    private List<ProductInfo> apply_info;

    public String getApply_code() {
        return apply_code;
    }

    public void setApply_code(String apply_code) {
        this.apply_code = apply_code;
    }

    public String getApply_user_name() {
        return apply_user_name;
    }

    public void setApply_user_name(String apply_user_name) {
        this.apply_user_name = apply_user_name;
    }

    public int getApply_user_id() {
        return apply_user_id;
    }

    public void setApply_user_id(int apply_user_id) {
        this.apply_user_id = apply_user_id;
    }

    public String getApply_company() {
        return apply_company;
    }

    public void setApply_company(String apply_company) {
        this.apply_company = apply_company;
    }

    public String getSupplier_code() {
        return supplier_code;
    }

    public void setSupplier_code(String supplier_code) {
        this.supplier_code = supplier_code;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public List<ProductInfo> getApply_info() {
        return apply_info;
    }

    public void setApply_info(List<ProductInfo> apply_info) {
        this.apply_info = apply_info;
    }

    public int getApply_id() {
        return apply_id;
    }

    public void setApply_id(int apply_id) {
        this.apply_id = apply_id;
    }

    @Override
    public String toString() {
        return "PlanApply{" +
                "apply_id=" + apply_id +
                ", apply_code='" + apply_code + '\'' +
                ", apply_user_name='" + apply_user_name + '\'' +
                ", apply_user_id=" + apply_user_id +
                ", apply_company='" + apply_company + '\'' +
                ", supplier_code='" + supplier_code + '\'' +
                ", supplier_name='" + supplier_name + '\'' +
                ", apply_info=" + apply_info +
                '}';
    }
}
