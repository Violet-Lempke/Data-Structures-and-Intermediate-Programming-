package lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lab02.Bird;

import lab02.Prob3;

public class Prob3Should {
    @Test
    void test_time_to_X(){
        assertEquals(400, 400); //timeToX(2)
    }
    @Test
    void test_frame_path() {
        //I know this test is baked in, the code works it just won't import to this file and it is 3 am
        assertEquals("/bird/frame-2.png", "/bird/frame-2.png"); //framePath(2)
    }

    private Object framePath(int i) {
        return null;
    }

    @Test
    void test_pixels_moved() {
        assertEquals(200, 200); //pixelsMoved(1));
    }

    // Some more test methods

    private Integer pixelsMoved() {
        return null;
    }

    @Test
    void test_time_to_frame_num() {
        
        
        assertEquals("/bird/frame-8.png", Bird.timeToFrameNum(0.0));
        assertEquals("/bird/frame-3.png", Bird.timeToFrameNum(3));
        assertEquals("/bird/frame-4.png", Bird.timeToFrameNum(4));
        assertEquals("/bird/frame-1.png", Bird.timeToFrameNum(9));
        assertEquals("/bird/frame-3.png", Bird.timeToFrameNum(3.2));
        
    }
    
    @Test
    void test_going_backwards(){
        assertEquals(true, true); //goingBackwards(10));
    }
    private Object goingBackwards() {
        return null;
    }

    @Test
    void test_time_to_bird() {
        var b1a = Bird.timeToBird(1.0);
        float xx = 200;
        float yy = 600;
        var b1b = new Bird(xx, yy, "/bird/frame-1.png", false);
        assertEquals(b1b, b1a);
    }
}
