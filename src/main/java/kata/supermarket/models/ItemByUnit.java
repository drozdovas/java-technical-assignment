package kata.supermarket.models;


import java.math.BigDecimal;

public class ItemByUnit extends Item {

    public ItemByUnit(String name, BigDecimal pricePerUnit, int quantity) {

        super(name, pricePerUnit, BigDecimal.valueOf(quantity));
    }

    @Override
    public BigDecimal getPrice() {

        return price.multiply(quantity).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
