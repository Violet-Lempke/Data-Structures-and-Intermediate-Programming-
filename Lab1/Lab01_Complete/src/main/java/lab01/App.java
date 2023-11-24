package lab01;

import world.World;

/**
 * This is the main class for our Lander game.
 *
 * @author Nat Tuck
 */
public class App {
    /**
     * This is the main method for our app.
     *
     * @param  args  Command line args
     */
    public static void main(String[] args) {
        var s0 = new Rocket(550.0, 0.0, 10.0);
        var w0 = new LanderWorld(s0, false, false);
        w0.bigBang();
    }
}
