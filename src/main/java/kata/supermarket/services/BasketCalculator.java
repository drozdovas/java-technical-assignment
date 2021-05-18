package kata.supermarket.services;

import kata.supermarket.models.Item;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class BasketCalculator {
    private final List<Item> items;

    public BasketCalculator(List<Item> items) {

        this.items = items;
    }

    public BigDecimal calculate() {
        return items.parallelStream()
                .map(Item::getPrice)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO)
                .setScale(2, RoundingMode.HALF_UP);
    }
}
