package lab10;

/**
 * Our main app class.
 *
 * @author Various Authors
 */
public class App {
    public static void main(String[] args) {
        var addr = Address.newRandom();
        addr.print();
    }
}
