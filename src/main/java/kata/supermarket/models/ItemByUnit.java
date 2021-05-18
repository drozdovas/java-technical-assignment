package kata.supermarket.models;


import kata.supermarket.services.PriceCalculator;

import java.math.BigDecimal;

public class ItemByUnit extends Item {

    private final PriceCalculator priceCalculator = new PriceCalculator();

    public ItemByUnit(String name, BigDecimal pricePerUnit, int quantity, DiscountType discountType) {

        super(name, pricePerUnit, BigDecimal.valueOf(quantity), discountType);
    }

    @Override
    public BigDecimal totalPrice() {

        return priceCalculator.get(this);
    }
}
