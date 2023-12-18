package lab05;

/**
 * Our App.
 *
 * @author Nat Tuck
 *
 */
public class App {
    public static void main(String[] args) {
        var bs0 = new ArrayList<Ball>();
        var world = new BallWorld(bs0);
        world.bigBang();
        Integer[] nums4 = {1, 2, 3, 4};
        var a4 = new ArrayList<Integer>(nums4);
        var a5 = a4.filter((xx) -> xx % 2 == 0);
    }
}
