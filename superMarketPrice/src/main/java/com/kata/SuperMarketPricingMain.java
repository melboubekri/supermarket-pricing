package com.kata;

import java.util.Arrays;

import org.apache.log4j.Logger;

import com.kata.services.PricingService;

public class SuperMarketPricingMain {
	
	final static Logger logger = Logger.getLogger(SuperMarketPricingMain.class);
	
	public static void main(String[] args) {
		
		PricingService service = new PricingService();
		
		Parameter parameter = new Parameter();
		
		parameter.parser(args);
		
		double total = service.calculatePriceShop(parameter.getShop(), Arrays.asList(parameter.getDiscount()));
			
		logger.info("Total price of shop is  " +total);
		
	}

}
