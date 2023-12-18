package lab10;

/**
 * An address.
 *
 * @author Nat Tuck
 * @author Student
 */
public class Address implements Comparable<Address> {
    String name;
    int streetNumber;
    String streetName;
    String lineTwo;

    /**
     * Construct address.
     *
     * @param  name    Name of person
     * @param  stNumb  Street number
     * @param  stName  Street name
     * @param  line2   Optional second line of address
     */
    public Address(String name, int stNumb, String stName, String line2) {
        this.name = name;
        this.streetNumber = stNumb;
        this.streetName = stName;
        this.lineTwo = line2;
    }

    @Override
    public int hashCode() {
        var hash1 = this.name.hashCode();
        var hash2 = this.streetName.hashCode();
        return (hash1 + hash2 + this.streetNumber);
        
    }

    /**
     * Print this address.
     */
    void print() {
        System.out.printf(
            "%s\n%d %s\n%s\n",
            name,
            streetNumber,
            streetName,
            lineTwo == null ? "" : lineTwo
        );
    }

    @Override
    public int compareTo(Address that) {
        return this.name.compareTo(that.name);
    }

    /**
     * Make a new random address, given a street number.
     *
     * @param  stNum  Street number
     * @return        New address
     */
    public static Address newRandom(int stNum) {
        return new Address(randomName(),
                           stNum,
                           randomStreet(),
                           randomLineTwo());
    }

    /**
     * Make a new random address.
     *
     * @return        New address
     */
    public static Address newRandom() {
        return newRandom(randomStreetNumber());
    }

    /**
     * Generate a random personal name.
     *
     * @return The name
     */
    public static String randomName() {
        String[] names = {
            "Alice Anderson",
            "Bob Baker",
            "Carol Carter",
            "Dave Douglas"
        };
        return pickRandom(names);
    }

    /**
     * Generate a random street number.
     *
     * @return The number
     */
    public static int randomStreetNumber() {
        return 1 + (int)(Math.random() * 200);
    }

    /**
     * Generate a random street name.
     *
     * @return The name
     */
    public static String randomStreet() {
        String[] streets = {
            "Main St.",
            "High St.",
            "Rocky Rd.",
            "North Rd."
        };
        return pickRandom(streets);
    }

    /**
     * Generate a random second address line.
     *
     * @return Apartment number or null
     */
    public static String randomLineTwo() {
        if (Math.random() < 0.5) {
            return null;
        }
        int yy = 1 + (int)(Math.random() * 10);
        return "Apt " + yy;
    }

    /**
     * Randomly select an item from an array.
     *
     * @param  <T> Type of items in array
     * @param  xs  The array
     * @return     Random item from array
     */
    static <T> T pickRandom(T[] xs) {
        return xs[(int)(Math.random() * xs.length)];
    }
}
