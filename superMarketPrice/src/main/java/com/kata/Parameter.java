package com.kata;

import com.kata.model.Discount;
import com.kata.model.Price;
import com.kata.model.Product;
import com.kata.model.Quantity;
import com.kata.model.Shop;
import com.kata.model.UnitPrice;
import com.kata.model.UnitQuantity;
import com.kata.model.WeightPrice;
import com.kata.model.WeightQuantity;
import com.kata.model.WeightUnit;

public class Parameter {

	private Product product;
	private Shop shop;
	private Discount discount;

	/**
	 * the job of this method is to parse the list of arguments to execute the main class
	 * 
	 * @param parameters list or paramaters to execute the main class
	 */
	public void parser(String [] parameters) {

		if("-product".equals(parameters[0])) {

			product = new Product(parameters[2], parameters[1]);

			switch (parameters[4]) {

			case "UNIT" : product.setPrice(new UnitPrice(Double.parseDouble(parameters[3]))); break;
			case "POUND": product.setPrice(new WeightPrice(Double.parseDouble(parameters[3]), WeightUnit.POUND)); break;
			case "OUNCE": product.setPrice(new WeightPrice(Double.parseDouble(parameters[3]), WeightUnit.OUNCE));break;

			default:
				break;
			}

		}

		if("-discount".equals(parameters[5])) {


			discount = new Discount(new Product(parameters[7], parameters[6]), new Price(Double.parseDouble(parameters[8])), new Quantity());

			if (discount.getProduct().equals(product)) {
				discount.getProduct().setPrice(product.getPrice());
			}
			else {
				discount.getProduct().setPrice(new Price(0));
			}

			switch (parameters[10]) {

			case "UNIT" : discount.setDicountQuantity(new UnitQuantity(Double.parseDouble(parameters[9]))); break;
			case "POUND": discount.setDicountQuantity(new WeightQuantity(Double.parseDouble(parameters[9]), WeightUnit.POUND)); break;
			case "OUNCE": discount.setDicountQuantity(new WeightQuantity(Double.parseDouble(parameters[9]), WeightUnit.OUNCE));break;

			default:
				break;
			}

		}

		if("-shop".equals(parameters[11])) {

			shop = new Shop(new Product(parameters[13], parameters[12]), new Quantity());

			if (shop.getProduct().equals(product)) {
				shop.getProduct().setPrice(product.getPrice());
			}
			else {
				shop.getProduct().setPrice(new Price(0));
			}

			switch (parameters[15]) {

			case "UNIT" : shop.setQuantity(new UnitQuantity(Double.parseDouble(parameters[14]))); break;
			case "POUND": shop.setQuantity(new WeightQuantity(Double.parseDouble(parameters[14]), WeightUnit.POUND)); break;
			case "OUNCE": shop.setQuantity(new WeightQuantity(Double.parseDouble(parameters[14]), WeightUnit.OUNCE));break;

			default:
				break;
			}

		}


	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}


}