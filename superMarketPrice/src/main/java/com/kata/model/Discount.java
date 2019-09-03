package com.kata.model;

public class Discount {

    private Product product;
    private Price discountPrice;
    private Double dicountQuantity;

    public Price getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Price discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Double getDicountQuantity() {
        return dicountQuantity;
    }

    public void setDicountQuantity(Double dicountQuantity) {
        this.dicountQuantity = dicountQuantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
