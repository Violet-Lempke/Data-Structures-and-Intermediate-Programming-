package lab07;

/**
 * Our App.
 *
 *@author Nat Tuck
 *
 */
public class App {
    /**
     * Entry point.
     *
     * @param  args  Command line args.
     */
    public static void main(String[] args) {
        ArrayQueue<Integer> xs = new ArrayQueue<Integer>();
        for (int ii = 0; ii < 10; ++ii) {
            xs.push(ii);
            System.out.println(ii);
            System.out.println("" + xs.shift());
            
        }
        System.out.println("length" + xs.length);
        System.out.println("capacity" + xs.capacity());
    }
}
