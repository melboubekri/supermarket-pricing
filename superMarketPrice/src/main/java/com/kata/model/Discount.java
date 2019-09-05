package com.kata.model;

public class Discount {

    private Product product;
    private Price discountPrice;
    private Quantity dicountQuantity;

    
    public Discount(Product product, Price discountPrice, Quantity dicountQuantity) {
		super();
		this.product = product;
		this.discountPrice = discountPrice;
		this.dicountQuantity = dicountQuantity;
	}

	public Discount() {
		// TODO Auto-generated constructor stub
	}

	public Price getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Price discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Quantity getDicountQuantity() {
        return dicountQuantity;
    }

    public void setDicountQuantity(Quantity dicountQuantity) {
        this.dicountQuantity = dicountQuantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
