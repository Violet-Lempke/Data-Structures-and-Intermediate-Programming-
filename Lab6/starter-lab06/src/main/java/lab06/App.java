package lab06;

/**
 * Some demo code for stacks.
 *
 * @author Nat Tuck
 */
public class App {
    public static void main(String[] args) {
        // ConsStack
        Stack<Integer> xs = new ConsStack<Integer>();
        for (int ii = 0; ii < 10; ++ii) {
            xs.push(ii);
        }
        for (int ii = 0; ii < 10; ++ii) {
            System.out.print(xs.pop());
            System.out.print(" ");
        }
        System.out.println();

        // ArrayStack
        Stack<Integer> ys = new ArrayStack<Integer>();
        for (int ii = 0; ii < 10; ++ii) {
            ys.push(ii);
        }
        for (int ii = 0; ii < 10; ++ii) {
            System.out.print(ys.pop());
            System.out.print(" ");
        }
        System.out.println();

        // BitStack
        Stack<Boolean> zs = new BitStack();
        for (int ii = 0; ii < 10; ++ii) {
            zs.push(ii % 4 == 0);
        }
        for (int ii = 0; ii < 10; ++ii) {
            System.out.print(zs.pop());
            System.out.print(" ");
        }
        System.out.println();
    }
}
