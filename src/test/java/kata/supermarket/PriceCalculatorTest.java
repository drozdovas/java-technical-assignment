package kata.supermarket;

import kata.supermarket.models.DiscountType;
import kata.supermarket.models.ItemByUnit;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void itemByUnitWithBuyOneGetOneFreeHasExpectedDiscount(String price, int quantity, String expectedPrice) {

        final ItemByUnit item = new ItemByUnit("Carton of Milk", new BigDecimal(price)
                , quantity, DiscountType.BUY_ONE_GET_ONE_FREE);
        assertEquals(new BigDecimal(expectedPrice), item.totalPrice());
    }

    static Stream<Arguments> itemByUnitWithBuyOneGetOneFreeHasExpectedDiscount() {
        return Stream.of(
                Arguments.of("1.29", 1, "1.29"),
                Arguments.of("1.29", 2, "1.29"),
                Arguments.of("1.29", 5, "3.87")
        );
    }

    @ParameterizedTest
    @MethodSource
    void itemByUnitWithTwoForOnePoundFreeHasExpectedDiscount(String price, int quantity, String expectedPrice) {

        final ItemByUnit item = new ItemByUnit("Snickers Bar", new BigDecimal(price)
                , quantity, DiscountType.TWO_FOR_ONE_POUND);
        assertEquals(new BigDecimal(expectedPrice), item.totalPrice());
    }

    static Stream<Arguments> itemByUnitWithTwoForOnePoundFreeHasExpectedDiscount() {
        return Stream.of(
                Arguments.of("1.02", 1, "1.02"),
                Arguments.of("1.02", 2, "1.00"),
                Arguments.of("1.02", 5, "3.02")
        );
    }
}