package lab02;

import world.*;
import image.*;

/**
 * Solves problem 3.
 */
public class Prob3 {
    public static void main(String[] args) {
        var bw = new BirdWorld(0.0);
        bw.bigBang();
    }

    /*
    // This doesn't help solve the problem, but might help for experiments.
    static void showBird() {
        var bird1 = new FromResource("/bird/frame-1.png");
        World.display(new EmptyScene(800, 600).placeImage(bird1, 200, 200));
    }
    */
}

// Define your Bird record here.


/**
 * Implements bird animation.
 *
 * @author Nat Tuck
 * @author A Student
 */
class BirdWorld extends World {
    static int WW = 800; // Window width, logical pixels
    static int HH = 600; // Window height, logical pixels
    
    // time since program start, in seconds
    final double currentTime;

    /**
     * Build a BirdWorld at a given execution time.
     *
     * @param  time  In seconds
     */
    BirdWorld(double time) {
        this.currentTime = time;
    }

    @Override
    public Scene onDraw() {
        //var bird = Bird.timeToBird(this.currentTime);
        //var img = birdFrame(bird);
        var bg = new EmptyScene(WW, HH);
        //return bg.placeImage(img, bird.x(), bird.y());
        return bg;
    }

    @Override
    public BirdWorld onTick() {
        return new BirdWorld(this.currentTime + this.tickRate());
    }

    @Override
    public double tickRate() {
        // Set goal simulation rate to 30 ticks per second.
        return 1.0 / 30.0;
    }
}
