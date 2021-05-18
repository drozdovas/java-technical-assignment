package kata.supermarket.models;

import java.math.BigDecimal;

public class Item {

    public final String name;
    public final BigDecimal price;
    public final BigDecimal quantity;
    public final DiscountType discountType;

    public Item(String name, BigDecimal price, BigDecimal quantity, DiscountType discountType){

        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.discountType = discountType;
    }

    public BigDecimal getPrice() {

        return BigDecimal.ZERO;
    }

}
