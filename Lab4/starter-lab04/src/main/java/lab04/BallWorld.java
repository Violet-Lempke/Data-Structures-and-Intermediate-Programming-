package lab04;

import image.*;
import world.*;

/**
 * Implements ball interactive visualization.
 *
 * @author Nat Tuck
 */
public class BallWorld extends World {
    static final int WW = 800; // Window width, logical pixels
    static final int HH = 600; // Window height, logical pixels
    static final int BS = 40;  // Ball size, logical pixels

    // The balls currently on the screen
    final List<Ball> balls;

    /**
     * Build a BallWorld.
     *
     * @param  balls  The current balls.
     */
    BallWorld(List<Ball> balls) {
        this.balls = balls;
    }

    @Override
    public Scene onDraw() {
        Scene scn = new EmptyScene(WW, HH);
        for (var curr = this.balls; !curr.empty(); curr = curr.rest()) {
            var ball = curr.first();
            var img = new Circle(BS, "solid", ball.color());
            scn = scn.placeImage(img, ball.px(), ball.py());
        }
        return scn;
    }

    @Override
    public BallWorld onMouse(int x, int y, String me) {
        if (me.equals("button-up")) {
            var ball = Ball.random(x, y);
            return new BallWorld(new Cell<>(ball, this.balls));
        }
        else {
            return this;
        }
    }

    @Override
    public BallWorld onKey(String ke) {
        if (ke.equals(" ")) {
            return this;
        }
        else {
            return this;
        }
    }

    @Override
    public BallWorld onTick() {
        return this;
    }

    @Override
    public double tickRate() {
        // Set goal simulation rate to 30 ticks per second.
        return 1.0 / 30.0;
    }
}
