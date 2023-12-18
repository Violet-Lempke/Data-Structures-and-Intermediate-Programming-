package lab04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BallShould {
    @Test
    void make_random_instances() {
        var bb = Ball.random(100, 200);
        assertEquals(100, bb.px());
        assertEquals(200, bb.py());
    }

    @Test
    void detect_oob() {
       
        
        var b1 = new Ball("green", 10, 200, -5, 5);
        assertTrue(b1.oobX());
        assertTrue(!b1.oobY());

        var b2 = new Ball("red", 790, 590, 5, 5);
        assertTrue(b2.oobX());
        assertTrue(b2.oobY());

        var b3 = new Ball("yellow", 600, 10, 5, -5);
        assertTrue(!b3.oobX());
        assertTrue(b3.oobY());

        var b4 = new Ball("blue", 100, 100, -5, -5);
        assertTrue(!b4.oobX());
        assertTrue(!b4.oobY());

        var b5 = new Ball("green", -1, -1, -5, 5);
        assertTrue(b5.oobX());
        assertTrue(b5.oobY());

        var b6 = new Ball("green", 801, 601, 5, -5);
        assertTrue(b6.oobX());
        assertTrue(b6.oobY());
        
    }

    @Test
    void bounce_off_walls() {
        
        
        var b1 = new Ball("green", 10, 200, -5, 5);
        assertEquals(new Ball("green", 15, 205, 5, 5), b1.tick());

        var b2 = new Ball("red", 790, 590, -5, -5);
        assertEquals(new Ball("red", 785, 585, -5, -5), b2.tick());

        var b3 = new Ball("yellow", 600, 10, 5, -5);
        assertEquals(new Ball("yellow", 605, 15, 5, 5), b3.tick());
        
        var b4 = new Ball("blue", 100, 100, -5, -5);
        assertEquals(new Ball("blue", 95, 95, -5, -5), b4.tick());
        
        var b5 = new Ball("green", -1, -1, -5, 5);
        assertEquals(new Ball("green", 4, 4, 5, 5), b5.tick());

        var b6 = new Ball("green", 801, 601, 5, -5);
        assertEquals(new Ball("green", 796, 596, -5, -5), b6.tick());
        
    }
}
