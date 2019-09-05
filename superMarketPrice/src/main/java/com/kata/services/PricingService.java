package com.kata.services;

import java.util.List;
import java.util.stream.Collectors;

import com.kata.model.Discount;
import com.kata.model.Shop;
import com.kata.model.WeightPrice;
import com.kata.model.WeightQuantity;
import com.kata.model.WeightUnit;
import com.kata.utils.SuperMarketUtils;

public class PricingService {

	/**
	 * calculate the price of the shop with applying the given discount using
	 * weghitQuantity or unitQuantity
	 * 
	 * @param shop
	 *            the shop
	 * @param allDiscounts
	 *            list of discounts to apply
	 * @return the price of the shop
	 */
	public double calculatePriceShop(final Shop shop, List<Discount> allDiscounts) {
		List<Discount> discounts = allDiscounts.stream()
				.filter(d -> d.getProduct().getReference().equals(shop.getProduct().getReference()))
				.collect(Collectors.toList());
		if (discounts != null && discounts.size() == 1
				&& shop.getQuantity().getValue() >= discounts.get(0).getDicountQuantity().getValue()) {
			Discount discount = discounts.get(0);
			double realQuantityShop = 0;
			realQuantityShop = calculShopQuantity(shop);
			Integer realQuantityDiscount = (int) (realQuantityShop / discount.getDicountQuantity().getValue());
			Double realPriceDiscount = realQuantityDiscount * discount.getDiscountPrice().getValue();
			Double realQuantityWithoutDiscount = realQuantityShop % discount.getDicountQuantity().getValue();
			Double realPriceWithoutDiscount = realQuantityWithoutDiscount * shop.getProduct().getPrice().getValue();
			return realPriceDiscount + realPriceWithoutDiscount;
		} else {
			return shop.getQuantity().getValue() * shop.getProduct().getPrice().getValue();
		}

	}

	private double calculShopQuantity(final Shop shop) {
		double realQuantityShop;
		if (shop.getQuantity() instanceof WeightQuantity) {
			WeightUnit input = ((WeightQuantity) shop.getQuantity()).getUnit();
			WeightPrice weightPrice = (WeightPrice) (shop.getProduct().getPrice());
			WeightUnit output = weightPrice.getUnit();
			realQuantityShop = SuperMarketUtils.convertWeight(input, output).apply(shop.getQuantity().getValue());
		} else {
			realQuantityShop = shop.getQuantity().getValue();
		}
		return realQuantityShop;
	}
}
