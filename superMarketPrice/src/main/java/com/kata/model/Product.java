package com.kata.model;

public class Product
{
    private String reference;
    private Price price;
    private String name;
    private ProductUnit unitType;

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public ProductUnit getUnitType() {
        return unitType;
    }

    public void setUnitType(ProductUnit unitType) {
        this.unitType = unitType;
    }
}
