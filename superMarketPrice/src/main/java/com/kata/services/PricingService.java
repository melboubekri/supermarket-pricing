package com.kata.services;

import com.kata.model.Discount;
import com.kata.model.Shop;

import java.util.List;
import java.util.stream.Collectors;

public class PricingService {

    public Double calculatePriceShop(final Shop shop, List<Discount> allDiscounts){

        List<Discount> discounts=allDiscounts.stream().filter(d -> d.getProduct().getReference().equals(shop.getProduct().getReference())).collect(Collectors.toList());
        if(discounts!=null && discounts.size()==1 && shop.getQuantity()>=discounts.get(0).getDicountQuantity()){
            Discount discount=discounts.get(0);
            Integer realQuantityDiscount = (int)(shop.getQuantity() / discount.getDicountQuantity());
            Double realPriceDiscount=realQuantityDiscount*discount.getDiscountPrice().getValue();
            Double realQuantityWithoutDiscount=shop.getQuantity() % discount.getDicountQuantity();
            Double realPriceWithoutDiscount=realQuantityWithoutDiscount*shop.getProduct().getPrice().getValue();
            return realPriceDiscount+realPriceWithoutDiscount;
        }else{
            return shop.getQuantity()*shop.getProduct().getPrice().getValue();
        }

    }
}
