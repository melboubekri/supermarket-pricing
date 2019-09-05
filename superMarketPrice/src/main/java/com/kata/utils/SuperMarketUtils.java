package com.kata.utils;

import java.util.function.Function;

import com.kata.model.WeightUnit;

public class SuperMarketUtils {

	/**
	 * the job of this method is to return a function allowing the conversion of the weight from pound to ounce or the contrary
	 * @param inputUnit  the weightUnit in input
	 * @param outputUnit the weightUnit in outPut
	 * @return weight Unit converted 
	 */
	public static Function<Double, Double> convertWeight(WeightUnit inputUnit, WeightUnit outputUnit) {
		if (outputUnit == inputUnit) {
			return weight -> weight;
		}
		switch (inputUnit) {
		case OUNCE:
			return weight -> weight / 16;
		case POUND:
			return weight -> weight * 16;
		}
		return weight -> weight;
	}

}
