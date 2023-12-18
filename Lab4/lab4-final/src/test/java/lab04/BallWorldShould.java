package lab04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BallWorldShould {
    @Test
    void move_balls_on_tick() {
        
        
        var balls1 = List.list(
            new Ball("red", 300, 400, 7, -6),
            new Ball("blue", 500, 200, -4, 5));
        var balls2 = List.list(
            new Ball("red", 307, 394, 7, -6),
            new Ball("blue", 496, 205, -4, 5));
        var w1 = new BallWorld(balls1);
        var w2 = w1.onTick();
        assertEquals(balls2, w2.balls);
        
    }

    @Test
    void drop_top_half() {
       
    }
}
