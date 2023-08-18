package com.jac.mpdemo.entity;

public class ProductInfo {

    private String product_area;
    private String product_name;

    public String getProduct_area() {
        return product_area;
    }

    public void setProduct_area(String product_area) {
        this.product_area = product_area;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    @Override
    public String toString() {
        return "ProductInfo{" +
                "product_area='" + product_area + '\'' +
                ", product_name='" + product_name + '\'' +
                '}';
    }
}
