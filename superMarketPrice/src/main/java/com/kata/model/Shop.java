package com.kata.model;

public class Shop {

    private Product product;
    private Quantity quantity;

    
    public Shop(Product product, Quantity quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	public Shop() {
		// TODO Auto-generated constructor stub
	}

	public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }
}
