package kata.supermarket;

import kata.supermarket.models.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasketTest {

    @DisplayName("basket provides its total value when containing...")
    @MethodSource
    @ParameterizedTest(name = "{0}")
    void basketProvidesTotalValue(String description, String expectedTotal, Iterable<Item> items) {
        final Basket basket = new Basket();
        items.forEach(basket::add);
        assertEquals(new BigDecimal(expectedTotal), basket.total());
    }

    static Stream<Arguments> basketProvidesTotalValue() {
        return Stream.of(
                noItems(),
                aSingleItemPricedPerUnit(),
                multipleItemsPricedPerUnit(),
                aSingleItemPricedByWeight(),
                multipleItemsPricedByWeight()
        );
    }

    private static Arguments aSingleItemPricedByWeight() {

        return Arguments.of("a single weighed item", "1.25", Collections.singleton(twoFiftyGramsOfAmericanSweets()));
    }

    private static Arguments multipleItemsPricedByWeight() {

        return Arguments.of("multiple weighed items", "1.85",
                Arrays.asList(twoHundredGramsOfPickAndMix(), twoFiftyGramsOfAmericanSweets()));
    }

    private static Arguments multipleItemsPricedPerUnit() {

        return Arguments.of("multiple items priced per unit", "2.04",
                Arrays.asList(aPackOfDigestives(), aPintOfMilk()));
    }

    private static Arguments aSingleItemPricedPerUnit() {

        return Arguments.of("a single item priced per unit", "0.49", Collections.singleton(aPintOfMilk()));
    }

    private static Arguments noItems() {

        return Arguments.of("no items", "0.00", Collections.emptyList());
    }

    private static Item aPintOfMilk() {

        return new ItemByUnit("Pint of milk",new BigDecimal("0.49"), 1, DiscountType.NONE);
    }

    private static Item aPackOfDigestives() {

        return new ItemByUnit("Pack Of Digestives", new BigDecimal("1.55"),1, DiscountType.NONE);
    }

    private static Item aKiloOfAmericanSweets() {

        return new ItemByWeight("American Sweets", new BigDecimal("4.99"), new BigDecimal(1), DiscountType.NONE);
    }

    private static Item twoFiftyGramsOfAmericanSweets() {

        return new ItemByWeight("American Sweets", new BigDecimal("4.99"), new BigDecimal(".25"), DiscountType.NONE);
    }

    private static Item aKiloOfPickAndMix() {

        return new Item("Pick And Mix", new BigDecimal("2.99"), new BigDecimal(1), DiscountType.NONE);
    }

    private static Item twoHundredGramsOfPickAndMix() {

        return new ItemByWeight("Pick And Mix", new BigDecimal("2.99"), new BigDecimal(".20"), DiscountType.NONE);
    }
}