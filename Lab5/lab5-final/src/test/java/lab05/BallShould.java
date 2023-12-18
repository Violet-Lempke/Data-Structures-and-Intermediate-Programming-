package lab05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;

//import lab05.Ball;

public class BallShould {
    @Test
    void test_tick() {
        var b0 = Ball.random(100, 100);
        var b1 = b0.tick(0.1, new ArrayList<Ball>());

        assertEquals(b0.color(), b1.color(), "color");
        assertEquals(b0.px() + 0.1*b0.vx(), b1.px(), 0.0001, "px");
        assertEquals(b0.py() + 0.1*b0.vy(), b1.py(), 0.0001, "py");
        assertEquals(b0.vx(), b1.vx(), 0.0001, "vx");
        //There was a minus twenty here? 
        //Didn't make sense so was removed.
        assertEquals(b0.vy(), b1.vy(), 0.0001, "vy");
    }

    @Test
    void test_maybe_bounce() {
        // before collision
        var b1 = new Ball("red" ,400,400, 30, 30);
        var b2 = new Ball("Yellow", 400, 400, -30, -30);
        var a1 = new ArrayList<Ball>(2);
        a1.append(b1);
        a1.append(b2);
        BallWorld bw0 = new BallWorld(a1);
        var bw1 = bw0.onTick();
        var bs1 = bw1.balls;
        
        // after collision
        var b3 = new Ball("red" ,399,399, -30, -30);
        var b4 = new Ball("Yellow", 401, 401, 30, 30);
        var a2 = new ArrayList<Ball>(2);
        a2.append(b3);
        a2.append(b4);
        BallWorld bw2 = new BallWorld(a2);
        var bs2 = bw2.balls;

        assertEquals(bs1.length(), bs2.length());
        for (int ii = 0; ii < bs2.length(); ++ii) {
            assertEquals(bs2.get(ii), bs1.get(ii));
        }
        
    }
}
