package lab02;

import world.*;
import image.*;


/** 
 * Solves problem 3.
 *
 *@author Violet Lempke
 */
public class Prob3 {
    public static void main(String[] args) {
        var bw = new BirdWorld(0.0);
        bw.bigBang();
        
    }

    
   
    
}

// Define your Bird record here.

/**
 * Contains all of the data for a bird.
 *
 * @author Violet Lempke
 *
 * @param xx a float representing x position
 *
 * @param yy a float respresenting y position
 *
 * @param frame integer representing what frame of animation 
 *
 * @param flip boolean representing whether or not bird is flipped
 *
 */
record Bird(double xx, double yy, String frame, boolean flip ) {



    
    /**
    *Returns the path to a frame.
    *
    *@author Violet Lempke

    * @param frame a string
    * 
    * @return a string
    */

    public static String framePath(int frame) {
        if (frame == 1) {
            return "/bird/frame-1.png"; 
        }
        else if (frame == 2 ) {
            return "/bird/frame-2.png"; 
        }
        else if (frame == 3) {
            return "/bird/frame-3.png"; 
        }
        else if (frame == 4) {
            return "/bird/frame-4.png"; 
        }
        else if (frame == 5) {
            return "/bird/frame-5.png"; 
        }
        else if (frame == 6) {
            return "/bird/frame-6.png"; 
        }
        else if (frame == 7) {
            return "/bird/frame-7.png";
        }
        else {
            return "/bird/frame-8.png";
        }
    }
    /**
    *Returns the number of pixels moved.
    *
    *@author Violet Lempke
    *
    * @param time a double
    *
    * @return a double
    */
    public static double pixelsMoved(double time) {
        return time * 200;
    }
    /**
    *Returns if the bird is moving backwards.
    *
    * @author Violet Lempke
    *
    * @param time a double
    *
    * @return a boolean
    */
    public static boolean goingBackwards(double time) {
        var pixelsMoved = pixelsMoved(time);
        if (pixelsMoved > 1600) {
            while (pixelsMoved > 1600 ) {
                pixelsMoved -= 1600;
            }
        }
    
        if (pixelsMoved > 800) {
            return true;

        }
        else {
            return false;
        }
    } 
    /**
    *Returns x position.
    *
    * @author Violet Lempke
    *
    * @param time a double
    *
    * @return a double
    */
    public static double timeToX(double time) {
        var xxMovement = 200*time;
        if (xxMovement > 1600) {
            while (xxMovement > 1600) {
                xxMovement -= 1600;
            }
        }
        var back = goingBackwards(time);
        if (back == true) {
            return 800 - (xxMovement - 800);
    
        }
        else {
            return xxMovement;
        }
    }
    /**
     * Assigns a frame based on the second.
     *
     * @author Violet Lempke
     *
     * @param time
     *
     * @return
     */
    public static String timeToFrameNum(double time) {
        var ftime = Math.round(time);
        if (ftime > 8) {
            while (ftime > 8) {
                ftime -= 8;
            }
            if (Math.round(ftime) == 1) {
                return (framePath(1));
            }
            else if (Math.round(ftime) == 2) {
                return (framePath(2));
            }
            else if (Math.round(ftime) == 3) {
                return (framePath(3));
            }
            else if (Math.round(ftime) == 4) {
                return (framePath(4));

            }
            else if (Math.round(ftime) == 5) {
                return (framePath(5));
            }
            else if (Math.round(ftime) == 6) {
                return (framePath(6));
            }
            else if (Math.round(ftime) == 7) {
                return (framePath(7));
            }
            else {
                return (framePath(8));
            }
        }    
        else if (Math.round(ftime) == 1) {
            return (framePath(1));
        }
        else if (Math.round(ftime) == 2) {
            return (framePath(2));
        }
        else if (Math.round(ftime) == 3) {
            return (framePath(3));
        }
        else if (Math.round(ftime) == 4) {
            return (framePath(4));

        }
        else if (Math.round(ftime) == 5) {
            return (framePath(5));
        }
        else if (Math.round(ftime) == 6) {
            return (framePath(6));
        }
        else if (Math.round(ftime) == 7) {
            return (framePath(7));
        }
        else {
            return (framePath(8));
        }
      
    }



    /**
    *Returns x value of bird.
    *
    * @author Violet Lempke
    *
    * @param bird a bird object
    *
    * @return
    */

    public double getxx(Bird bird) {
        return xx;
    }

    /**
    * creates a bird.
    *
    * @author Violet Lempke
    *
    * @param time a double
    *
    * @return a bird object
    */
    public static Bird timeToBird(double time) {

        var xx = timeToX(time);
        var yy = 600;
        var frame = timeToFrameNum(time);
        var flip = goingBackwards(time);
        var newby = new Bird(xx, yy, frame, flip);

        return newby;
    }
}
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

        var bird = Bird.timeToBird(this.currentTime);
        var birdFrame = bird;
        var img = bird.timeToFrameNum(this.currentTime);
        var image = new FromResource(img);
        var bg = new EmptyScene(WW, HH);
        var flip = bird.goingBackwards(this.currentTime);
       
        
        return bg.placeImage(image, bird.getxx(bird), 200);
        
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

