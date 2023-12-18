package lab03;

public class Prob1 {
    public static void main(String[] args) {
        MenuItem burger = new Burger(2, true, false);
        System.out.println("The " + burger.name() + " is only " + burger.price());
    }
}

/**
 * Common interface for a food item item.
 *
 * @author Nat Tuck
 */
interface MenuItem {
    /**
     * Return the price of this menu item for display.
     *
     * @return  Price as string, formatted as dollars to two decimal places.
     */
    default String price() {
        int dollars = this.priceCents() / 100;
        int cents = this.priceCents() % 100;
        return String.format("$%d.%02d", dollars, cents);
    }

    /**
     * Return the price of this menu item in cents.
     *
     * @return  Price in cents.
     */
    int priceCents();

    /**
     * Return the weight of this item.
     *
     * @return  Weight in grams.
     */
    double weight();

    /**
     * Return the name of this menu item for display.
     *
     * @return  The name.
     */
    String name();
}

/**
 * A Burger.
 *
 * @author Nat Tuck
 */
record Burger(int patties, boolean cheese, boolean bacon) implements MenuItem {
    @Override
    public int priceCents() {
        int cents = 100 * this.patties;
        if (this.cheese) {
            cents += 25;
        }
        if (this.bacon) {
            cents += 50;
        }
        return cents;
    }

    @Override
    public double weight() {
        double grams = 85.0 * this.patties;
        if (this.cheese) {
            grams += 28.0;
        }
        if (this.bacon) {
            grams += 16.0;
        }
        return grams;
    }

    @Override
    public String name() {
        StringBuilder yy = new StringBuilder();

        switch (this.patties) {
        case 1:
            break;
        case 2:
            yy.append("Double ");
            break;
        case 3:
            yy.append("Triple ");
            break;
        default:
            yy.append("Mega " + this.patties + " ");
        }

        if (this.bacon) {
            yy.append("Bacon ");
        }

        if (this.cheese) {
            yy.append("Cheeseburger");
        }
        else {
            yy.append("Hamburger");
        }

        return yy.toString();
    }
}

