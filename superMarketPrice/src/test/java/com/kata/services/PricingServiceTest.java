package com.kata.services;

import com.kata.model.*;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PricingServiceTest {

	private PricingService service = new PricingService();

	@Test
	public void testCalculatePriceShopWithDiscountWithUnit() {
		Shop shop = new Shop();
		Product product = new Product();
		product.setName("p1");
		product.setReference("ref1");
		product.setPrice(new UnitPrice(1.5));

		shop.setProduct(product);
		shop.setQuantity( new UnitQuantity(5.0));

		Discount discount = new Discount();
		discount.setDicountQuantity(new UnitQuantity(4.0));
		discount.setDiscountPrice(new Price(5.0));
		discount.setProduct(product);

		Double total = service.calculatePriceShop(shop, Arrays.asList(discount));
		assertEquals(new Double(6.5), total);
	}

	@Test
	public void testCalculatePriceShopWithoutDiscount() {
		Shop shop = new Shop();
		Product product1 = new Product();
		product1.setName("p1");
		product1.setReference("ref1");
		product1.setPrice(new Price(1.5));

		Product product2 = new Product();
		product2.setName("p2");
		product2.setReference("ref2");
		product2.setPrice(new UnitPrice(2.5));

		shop.setProduct(product1);
		shop.setQuantity(new UnitQuantity(5.0));

		Discount discount = new Discount();
		discount.setDicountQuantity(new UnitQuantity(4.0));
		discount.setDiscountPrice(new Price(5.0));
		discount.setProduct(product2);

		Double total = service.calculatePriceShop(shop, Arrays.asList(discount));
		assertEquals(new Double(7.5), total);
	}

	@Test
	public void testCalculatePriceShopWithDiscountUsingWeight() {
		Shop shop = new Shop();
		Product product = new Product();
		product.setName("p1");
		product.setReference("ref1");
		product.setPrice(new WeightPrice(1.99, WeightUnit.POUND));
		shop.setProduct(product);
		shop.setQuantity(new WeightQuantity(48.0,WeightUnit.OUNCE));

		Discount discount = new Discount();
		discount.setDicountQuantity(new WeightQuantity(3.0,WeightUnit.POUND));
		discount.setDiscountPrice(new WeightPrice(1.0,WeightUnit.POUND));
		discount.setProduct(product);

		Double total = service.calculatePriceShop(shop, Arrays.asList(discount));
		assertEquals(new Double (1.0), total);
	}
}
