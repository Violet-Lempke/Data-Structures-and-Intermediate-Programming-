package lab03;

/**
 *contains the data for prob1. 
 *
 *@author Ryan Moriarty
 */
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
 * 
 *@param patties int representing patties
 *
 *@param cheese boolean determining cheese
 *
 *@param bacon boolean determing bacon
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

/**
 * Nachos.
 *
 * @author Ryan Moriarty
 * 
 *@param size string representing size
 *
 *@param guac boolean reprenting guac
 *
 *@param spicy boolean representing spicy
 */
record Nachos(String size, boolean guac, boolean spicy) implements MenuItem {
    @Override
    public int priceCents() {
        int cents = 0;
        
        if (this.size == "small") {
            cents += 100;
        }
        if (this.size == "medium") {
            cents += 150;
        }
        if (this.size == "large") {
            cents += 200;
        }
        if (this.guac) {
            cents += 50;
        }
        if (this.spicy) {
            cents += 25;
        }
        return cents;
    }

    @Override
    public double weight() {
        double grams = 0;
        if (this.size == "small") {
            grams += 10.0;
        }
        if (this.size == "medium") {
            grams += 15.0;
        }
        if (this.size == "large") {
            grams += 20.0;
        }
        if (this.guac) {
            grams += 28.0;
        }
        if (this.spicy) {
            grams += 8.0;
        }
        return grams;
    }

    @Override
    public String name() {
        StringBuilder yy = new StringBuilder();

        switch (this.size) {
        case "small":
            yy.append("Small ");
            break;
        case "medium":
            yy.append("Medium ");
            break;
        case "large":
            yy.append("Large ");
            break;
        
        }

       

        if (this.spicy) {
            yy.append("Spicy ");
        }
    
        yy.append("Nachos");
        
        if (this.guac) {
            yy.append(" with Guacamole");
        }

        return yy.toString();
    }
}

/**
 * Ice Cream.
 *
 * @author Ryan Moriarty
 * 
 *@param vanilla int representing scoops
 *
 *@param chocolate int representing scoops 
 *
 *@param bowl boolean representing bowl
 */
record IceCream(int vanilla, int chocolate, boolean bowl) implements MenuItem {
    @Override
    public int priceCents() {
        int cents = 100 * this.vanilla;
        cents += 100 * this.chocolate;
        if (this.bowl) {
            cents += 50;
        }
        if (this.bowl == false) {
            cents += 25;
        }
      
        return cents;
    }

    @Override
    public double weight() {
        double grams = 4.0 * this.vanilla;
        grams += 4.0 * this.chocolate;
        if (this.bowl) {
            grams += 15.0;
        }
        if (this.bowl == false) {
            grams += 10.0;
        }
        return grams;
    }

    @Override
    public String name() {
        StringBuilder yy = new StringBuilder();
        if (this.bowl) {
            yy.append("Ice Cream Bowl, ");
        }
        if (this.bowl == false) {
            yy.append("Ice Cream Cone, ");
        }
        if (this.vanilla > 0) {
     
            yy.append( this.vanilla + " Vanilla ");
        }
        if (this.vanilla > 0 && this.chocolate > 0) {
            yy.append("and ");
        }
        if (this.chocolate > 0) {
            yy.append(this.chocolate + " Chocolate ");
        }
        return yy.toString();
    }
}
