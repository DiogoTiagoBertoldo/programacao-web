package com.entitites;

public class Pallet {
    private int code;
    private Product product;

    public Pallet(int code, Product product) {
        this.code = code;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
