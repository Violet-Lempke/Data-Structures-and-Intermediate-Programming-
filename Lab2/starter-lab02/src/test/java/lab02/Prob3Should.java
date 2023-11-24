package lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import lab02.Bird;

public class Prob3Should {
    @Test
    void test_frame_path() {
        assertEquals(1, 2);
    }

    @Test
    void test_pixels_moved() {
        assertEquals(1, 2);
    }

    // Some more test methods

    @Test
    void test_time_to_frame_num() {
        assertEquals(1, 2);
        /*
        assertEquals(1, Bird.timeToFrameNum(0.0));
        assertEquals(3, Bird.timeToFrameNum(0.2));
        assertEquals(4, Bird.timeToFrameNum(0.4));
        assertEquals(1, Bird.timeToFrameNum(3.0));
        assertEquals(3, Bird.timeToFrameNum(3.2));
        */
    }
    
    @Test
    void test_time_to_bird() {
        var b1a = 5; // Bird.timeToBird(1.0);
        var b1b = 7; // new Bird(200, 300, 1, false);
        assertEquals(b1b, b1a);
    }
}
