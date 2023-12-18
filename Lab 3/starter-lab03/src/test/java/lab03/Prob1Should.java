package lab03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Prob1Should {
    @Test
    void test_burger_price() {
        MenuItem b1 = new Burger(1, false, false);
        assertEquals(b1.price(), "$1.00");
        MenuItem b2 = new Burger(2, true, false);
        assertEquals(b2.price(), "$2.25");
        MenuItem b3 = new Burger(4, true, true);
        assertEquals(b3.price(), "$4.75");
    }

    @Test
    void test_burger_weight() {
        MenuItem b1 = new Burger(1, false, false);
        assertEquals(b1.weight(), 85.0, 0.0001);
        MenuItem b2 = new Burger(2, true, false);
        assertEquals(b2.weight(), 198.0, 0.0001);
        MenuItem b3 = new Burger(4, true, true);
        assertEquals(b3.weight(), 384.0, 0.0001);
    }

    @Test
    void test_burger_name() {
        MenuItem b1 = new Burger(1, false, false);
        assertEquals(b1.name(), "Hamburger");
        MenuItem b2 = new Burger(2, true, false);
        assertEquals(b2.name(), "Double Cheeseburger");
        MenuItem b3 = new Burger(4, true, true);
        assertEquals(b3.name(), "Mega 4 Bacon Cheeseburger");
        MenuItem b4 = new Burger(3, false, true);
        assertEquals(b4.name(), "Triple Bacon Hamburger");
    }

    // Test methods to add:
    //   Nachos: price, weight, name
    //   Icecream: price, weight, name
}
