package lab04;

/**
 * Our app.
 *
 * @author Nat Tuck
 */
public class App {
    public static void main(String[] args) {
        BallWorld w0 = new BallWorld(new Empty<Ball>());
        w0.bigBang();
    }
}


