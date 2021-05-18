package kata.supermarket.models;

import java.math.BigDecimal;

public class Item {

    public final String name;
    public final BigDecimal price;
    public final BigDecimal quantity;

    public Item(String name, BigDecimal price, BigDecimal quantity){

        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {

        return BigDecimal.ZERO;
    }

}
