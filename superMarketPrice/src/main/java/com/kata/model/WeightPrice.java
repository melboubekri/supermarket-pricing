package com.kata.model;

public class WeightPrice extends Price {

    public WeightPrice(Double value) {
        super(value);
    }

    public WeightPrice(Double value, WeightUnit unit) {
        super(value);
        this.unit = unit;
    }

    private WeightUnit unit;

    public WeightUnit getUnit() {
        return unit;
    }

    public void setUnit(WeightUnit unit) {
        this.unit = unit;
    }
}
