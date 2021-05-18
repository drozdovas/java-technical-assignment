package kata.supermarket.models;

import kata.supermarket.services.BasketCalculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Basket {
    private final List<Item> items;

    public Basket() {

        this.items = new ArrayList<>();
    }

    public void add(final Item item) {

        this.items.add(item);
    }

    List<Item> get() {

        return Collections.unmodifiableList(items);
    }

    public BigDecimal total() {

        return new BasketCalculator(items).calculate();
    }


}
