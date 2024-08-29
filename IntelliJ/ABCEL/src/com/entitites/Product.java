package com.entitites;

public class Product {

    private String name;

    private Variety variety;

    public Product(String name, Variety variety) {
        this.name = name;
        this.variety = variety;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Variety getVariety() {
        return variety;
    }

    public void setVariety(Variety variety) {
        this.variety = variety;
    }
}
