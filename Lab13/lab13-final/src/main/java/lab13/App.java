package lab13;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Our app.
 *
 * @author Nat Tuck
 */
public class App {
    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        var gb = new Gradebook();
        System.out.println(gb.showTotals());
    }
}
