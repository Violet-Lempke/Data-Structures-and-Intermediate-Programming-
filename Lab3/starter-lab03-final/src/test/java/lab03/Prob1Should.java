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
     @Test
    void test_nachos_price() {
        MenuItem b1 = new Nachos("small", false, false);
        assertEquals(b1.price(), "$1.00");
        MenuItem b2 = new Nachos("medium", true, false);
        assertEquals(b2.price(), "$2.00");
        MenuItem b3 = new Nachos("large", true, true);
        assertEquals(b3.price(), "$2.75");
    }

    @Test
    void test_nachos_weight() {
        MenuItem b1 = new Nachos("small", false, false);
        assertEquals(b1.weight(), 10.0, 0.0001);
        MenuItem b2 = new Nachos("medium", true, false);
        assertEquals(b2.weight(), 43.0, 0.0001);
        MenuItem b3 = new Nachos("large", true, true);
        assertEquals(b3.weight(), 56.0, 0.0001);
    }

    @Test
    void test_nachos_name() {
        MenuItem b1 = new Nachos("small", false, false);
        assertEquals(b1.name(), "Small Nachos");
        MenuItem b2 = new Nachos("medium", true, false);
        assertEquals(b2.name(), "Medium Nachos with Guacamole");
        MenuItem b3 = new Nachos("large", true, true);
        assertEquals(b3.name(), "Large Spicy Nachos with Guacamole");
    }
 @Test
    void test_icecream_price() {
        MenuItem b1 = new IceCream(1, 0, false);
        assertEquals(b1.price(), "$1.25");
        MenuItem b2 = new IceCream(2, 1, false);
        assertEquals(b2.price(), "$3.25");
        MenuItem b3 = new IceCream(4, 2, true);
        assertEquals(b3.price(), "$6.50");
    }

    @Test
    void test_icecream_weight() {
        MenuItem b1 = new IceCream(1, 0, false);
        assertEquals(b1.weight(), 14.0, 0.0001);
        MenuItem b2 = new IceCream(2, 1, false);
        assertEquals(b2.weight(), 22.0, 0.0001);
        MenuItem b3 = new IceCream(4, 2, true);
        assertEquals(b3.weight(), 39.0, 0.0001);
    }

    @Test
    void test_icecream_name() {
        MenuItem b1 = new IceCream(1, 0, false);
        assertEquals(b1.name(), "Ice Cream Cone, 1 Vanilla ");
        MenuItem b2 = new IceCream(2, 1, false);
        assertEquals(b2.name(), "Ice Cream Cone, 2 Vanilla and 1 Chocolate ");
        MenuItem b3 = new IceCream(4, 2, true);
        assertEquals(b3.name(), "Ice Cream Bowl, 4 Vanilla and 2 Chocolate ");
    }

}
