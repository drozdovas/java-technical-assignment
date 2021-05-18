package kata.supermarket.services;

import kata.supermarket.models.Item;

import java.math.BigDecimal;

public class DiscountCalculator {
    public BigDecimal get (Item item){

        switch (item.discountType){

            case BUY_ONE_GET_ONE_FREE:
                return applyBuyOneGetOneFreeDiscount(item.price, item.quantity)
                        .setScale(2, BigDecimal.ROUND_HALF_UP);

            default:
                return totalPriceWithoutDiscount(item.price, item.quantity)
                        .setScale(2, BigDecimal.ROUND_HALF_UP);

        }
    }

    private BigDecimal applyBuyOneGetOneFreeDiscount (BigDecimal price, BigDecimal quantity){

        return BigDecimal.ZERO;
    }

    private BigDecimal applyTwoForOnePoundDiscount (){

        return BigDecimal.ZERO;
    }

    private BigDecimal threeForThePriceOfTwo (){

        return BigDecimal.ZERO;
    }

    private BigDecimal kiloOfVeggiesForHalfPrice (){
        return BigDecimal.ZERO;
    }

    private BigDecimal totalPriceWithoutDiscount(BigDecimal price, BigDecimal quantity){

        return price.multiply(quantity).setScale(1, BigDecimal.ROUND_HALF_UP);
    }
}
