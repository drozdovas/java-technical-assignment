package kata.supermarket.models;

import java.math.BigDecimal;

public class ItemByWeight extends Item {

    public ItemByWeight(String name, BigDecimal pricePerKilo, BigDecimal quantityInKilos, DiscountType discountType) {

        super(name, pricePerKilo, quantityInKilos, discountType);
    }

    @Override
    public BigDecimal getPrice() {
        return this.price.multiply(this.quantity).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
