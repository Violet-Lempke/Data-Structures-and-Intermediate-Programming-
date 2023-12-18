package lab05;

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
    static final int GG = 200; // Gravity, pixels per second per second.

    // The balls currently on the screen
    final ArrayList<Ball> balls;

    /**
     * Build a BallWorld.
     *
     * @param  balls  The current balls.
     */
    BallWorld(ArrayList<Ball> balls) {
        this.balls = balls;
    }

    @Override
    public Scene onDraw() {
        Scene scn = new EmptyScene(WW, HH);
        for (int ii = 0; ii < this.balls.length(); ++ii) {
            var ball = this.balls.get(ii);
            var img = new Circle(BS, "solid", ball.color());
            scn = scn.placeImage(img, (int) ball.px(), (int)(HH - ball.py()));
        }
        return scn;
    }

    @Override
    public BallWorld onMouse(int x, int y, String me) {
        if (me.equals("button-up")) {
            var ball = Ball.random(x, HH - y);
            var ys = this.balls.clone();
            ys.append(ball);
            return new BallWorld(ys);
        }
        else {
            return this;
        }
    }

    @Override
    public BallWorld onKey(String ke) {
        if (ke.equals(" ")) {
            var newList = this.balls; 
            var filteredList = newList.filter((xx) -> xx.px() < 400);
            return new BallWorld(filteredList);
        }
        else {
            return this;
        }
    }

    @Override
    public BallWorld onTick() {
        double dt = tickRate();
        ArrayList<Ball> updateBalls = this.balls.map(ball -> ball.tick(dt, this.balls));
        return new BallWorld(updateBalls);
    }

    @Override
    public double tickRate() {
        // Set goal simulation rate to 30 ticks per second.
        return 1.0 / 30.0;
    }
}
