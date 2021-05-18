package kata.supermarket.models;


import kata.supermarket.services.DiscountCalculator;

import java.math.BigDecimal;

public class ItemByUnit extends Item {

    private final DiscountCalculator discountCalculator = new DiscountCalculator();

    public ItemByUnit(String name, BigDecimal pricePerUnit, int quantity, DiscountType discountType) {

        super(name, pricePerUnit, BigDecimal.valueOf(quantity), discountType);
    }

    @Override
    public BigDecimal getPrice() {

        return discountCalculator.get(this);
    }
}
