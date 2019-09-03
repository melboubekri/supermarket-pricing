package com.kata.services;

import com.kata.model.*;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PricingServiceTest {

    private PricingService service=new PricingService();

    @Test
    public void testCalculatePriceShopWithDiscount(){
        Shop shop=new Shop();
        Product product=new Product();
        product.setName("p1");
        product.setReference("ref1");
        product.setUnitType(ProductUnit.UNIT);
        product.setPrice(new Price(1.5));
        shop.setProduct(product);
        shop.setQuantity(5.0);

        Discount discount=new Discount();
        discount.setDicountQuantity(4.0);
        discount.setDiscountPrice(new Price(5.0));
        discount.setProduct(product);

        Double total=service.calculatePriceShop(shop, Arrays.asList(discount));
        assertEquals(new Double(6.5),total);
    }

    @Test
    public void testCalculatePriceShopWithoutDiscount(){
        Shop shop=new Shop();
        Product product=new Product();
        product.setName("p1");
        product.setReference("ref1");
        product.setPrice(new Price(1.5));
        shop.setProduct(product);
        shop.setQuantity(5.0);

        Product product2=new Product();
        product2.setName("p2");
        product2.setReference("ref2");
        product2.setPrice(new Price(2.5));
        product2.setUnitType(ProductUnit.UNIT);

        Discount discount=new Discount();
        discount.setDicountQuantity(4.0);
        discount.setDiscountPrice(new Price(5.0));
        discount.setProduct(product2);

        Double total=service.calculatePriceShop(shop, Arrays.asList(discount));
        assertEquals(new Double(7.5),total);
    }

    @Test
    public void testCalculatePriceShopWithDiscountUsingWeight(){
        Shop shop=new Shop();
        Product product=new Product();
        product.setName("p1");
        product.setReference("ref1");
        product.setUnitType(ProductUnit.WEIGHT);
        product.setPrice(new WeightPrice(2.5, WeightUnit.POUND));
        shop.setProduct(product);
        shop.setQuantity(5.5);

        Discount discount=new Discount();
        discount.setDicountQuantity(4.0);
        discount.setDiscountPrice(new Price(5.0));
        discount.setProduct(product);

        Double total=service.calculatePriceShop(shop, Arrays.asList(discount));
        assertEquals(new Double(8.75),total);
    }
}
