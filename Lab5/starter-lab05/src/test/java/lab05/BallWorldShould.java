package lab05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import lab05.BallWorld;

public class BallWorldShould {

    @Test
    void filter_for_eastern_balls() {
        var bw = example();

        bw = bw.onKey(" ");

        for (int ii = 0; ii < bw.balls.length(); ++ii) {
            Ball bb = bw.balls.get(ii);
            assertTrue(bb.px() < 400, "" + bb.px() + " < 400");
        }
    }

    @Test
    void correctly_do_onTick() {
        var bw0 = example();
        var bs0 = bw0.balls.clone();
        var bw1 = bw0.onTick();
        var bs1 = bw1.balls;
        var dt  = bw0.tickRate();

        assertEquals(bs0.length(), bs1.length());
        for (int ii = 0; ii < bs0.length(); ++ii) {
            assertBallsEqual(bs0.get(ii).tick(dt, bs0), bs1.get(ii));
        }
    }
        
    private BallWorld example() {
        BallWorld bw = new BallWorld(new ArrayList<Ball>());
        for (int ii = 0; ii < 100; ++ii) {
            bw = bw.onMouse(ii * 8, (ii*63) % 600, "button-up");
        }
        return bw;
    }

    private static void assertBallsEqual(Ball b0, Ball b1) {
        assertEquals(b0.color(), b1.color(), "color");
        assertEquals(b0.px(), b1.px(), 0.0001, "px");
        assertEquals(b0.py(), b1.py(), 0.0001, "py");
        assertEquals(b0.vx(), b1.vx(), 0.0001, "vx");
        assertEquals(b0.vy(), b1.vy(), 0.0001, "vy");
    }
}
