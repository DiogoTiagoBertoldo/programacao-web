package com.people;

import com.entitites.Pallet;
import com.entitites.Product;

public class Enrollment {
    private int enrollmentCode;
    private Product product;
    private Farmer farmer;

    //private Variety variety;

    private Pallet pallet;

    public Enrollment(int enrollmentCode, Product product, Farmer farmer, Pallet pallet) {
        this.enrollmentCode = enrollmentCode;
        this.product = product;
        this.farmer = farmer;
        this.pallet = pallet;
    }

    public int getEnrollmentCode() {
        return enrollmentCode;
    }

    public void setEnrollmentCode(int enrollmentCode) {
        this.enrollmentCode = enrollmentCode;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Farmer getFarmer() {
        return farmer;
    }

    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
    }

    public Pallet getPallet() {
        return pallet;
    }

    public void setPallet(Pallet pallet) {
        this.pallet = pallet;
    }
}
