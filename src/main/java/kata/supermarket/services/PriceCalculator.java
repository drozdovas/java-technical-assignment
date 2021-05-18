package kata.supermarket.services;

import kata.supermarket.models.Item;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PriceCalculator {
    public BigDecimal get (Item item){

        switch (item.discountType){

            case BUY_ONE_GET_ONE_FREE:
                return applyBuyOneGetOneFreeDiscount(item.price, item.quantity)
                        .setScale(2, BigDecimal.ROUND_HALF_UP);

            case TWO_FOR_ONE_POUND:
                return applyTwoForOnePoundDiscount(item.price, item.quantity)
                        .setScale(2, BigDecimal.ROUND_HALF_UP);

            default:
                return totalPriceWithoutDiscount(item.price, item.quantity)
                        .setScale(2, BigDecimal.ROUND_HALF_UP);

        }
    }

    private BigDecimal applyBuyOneGetOneFreeDiscount (BigDecimal price, BigDecimal quantity){

        if(quantity.intValue() % 2 == 0) {
            return quantity
                    .divide(new BigDecimal("2"))
                    .multiply(price);
        }
        else
            return getApplicableItemCountWhenDividingByTwo(quantity)
                    .multiply(price)
                    .add(price);
    }

    private BigDecimal applyTwoForOnePoundDiscount (BigDecimal price, BigDecimal quantity){

        if(quantity.intValue() % 2 == 0) {
            return quantity.divide(new BigDecimal(2));
        }
        else
            return getApplicableItemCountWhenDividingByTwo(quantity)
                    .add(price);
    }

    private BigDecimal getApplicableItemCountWhenDividingByTwo (BigDecimal quantity){

        return quantity.divide(new BigDecimal(2), RoundingMode.FLOOR);
    }

    private BigDecimal threeForThePriceOfTwo (){

        return BigDecimal.ZERO;
    }

    private BigDecimal kiloOfVeggiesForHalfPrice (){
        return BigDecimal.ZERO;
    }

    private BigDecimal totalPriceWithoutDiscount(BigDecimal price, BigDecimal quantity){

        return price.multiply(quantity).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
