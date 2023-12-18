package lab04;

import image.ColorDatabase;

/**
 * Represents a bouncing ball for lab04.
 *
 *@author Nat Tuck
 * @param color
 * @param px     X position
 * @param py     Y position
 * @param vx     X velocity
 * @param vy     Y velocity
 */
public record Ball(String color, int px, int py, int vx, int vy) {
    /**
     * Generate a random ball starting at x, y.
     *
     *@author Nat Tuck
     * @param  x  Initial x position.
     * @param  y  Initial y position.
     * @return    Newly created Ball.
     */
    static Ball random(int x, int y) {
        int vx = (int)(Math.random() * 20) - 14;
        int vy = (int)(Math.random() * 20) - 6;
        int rr = (int)(256 * Math.random());
        int gg = (int)(256 * Math.random());
        int bb = (int)(256 * Math.random());
        String color = ColorDatabase.makeColor(rr, gg, bb);
        return new Ball(color, x, y, vx, vy);
    }

    /**
     * Generates the next ball.
     *
     * @return A ball 
     */
    Ball tick() {
        //AntiClip measures
        if (this.px - 20 <= 0) {
            if (this.vx <= 0) {
                return new Ball(this.color,
                        this.px - this.vx,
                        this.py + this.vy,
                        (-1 * this.vx),
                        this.vy);
            }
            else {
                return new Ball(this.color,
                            this.px + this.vx,
                            this.py + this.vy,
                            this.vx,
                            this.vy);
            }
        }
        if (this.px + 20 >= 800) {
            if (this.vx >= 0) {
                return new Ball(this.color,
                        this.px - this.vx,
                        this.py + this.vy,
                        (-1 * this.vx),
                        this.vy);
            }
        
            else {
                return new Ball(this.color,
                        this.px + this.vx,
                        this.py + this.vy,
                        (this.vx),
                        this.vy);
            }
        }
        if (this.py - 20  <= 0) {
            if (this.vy <= 0) {
                return new Ball(this.color,
                            this.px + this.vx,
                            this.py - this.vy,
                            this.vx,
                            (-1 * this.vy));
            }
            else {
                return new Ball(this.color,
                            this.px + this.vx,
                            this.py + this.vy,
                            this.vx,
                            this.vy);
            }    
        }
        if (this.py + 20 >= 600) {
            if (this.vy >= 0) {
                return new Ball(this.color,
                            this.px + this.vx,
                            this.py - this.vy,
                            this.vx,
                            (-1 * this.vy));
            }
            else {
                return new Ball(this.color,
                            this.px + this.vx,
                            this.py + this.vy,
                            this.vx,
                            this.vy);
            }
        }
        // end of anticlip measures
        if ((this.oobX() == false) && (this.oobY() == false)) {
            return new Ball(this.color,
                        this.px + this.vx,
                        this.py + this.vy,
                        this.vx,
                        this.vy);
        }
        if ((this.oobX() == true) && (this.oobY() == true)) {
            return new Ball(this.color,
                        this.px - this.vx,
                        this.py - this.vy,
                        (-1 * this.vx),
                        (-1 * this.vy));
        }
        if (this.oobX() == true) {
            return new Ball(this.color,
                                this.px - this.vx,
                                this.py + this.vy,
                                (-1 * this.vx),
                                this.vy);
        }
        else {
            return new Ball(this.color,
                                this.px + this.vx,
                                this.py - this.vy,
                                this.vx,
                                (-1 * this.vy));
        }
    }
    /**
     *Replaces Tick in oob tests to avoid stackoverflow errors.
     *
     * @return a Ball
     */
    Ball testTick() {
        return new Ball(this.color,
                        this.px + this.vx,
                        this.py + this.vy,
                        this.vx,
                        this.vy);
    }

    /**
     *Determines if the ball is out of x bounds.
     *
     * @return a ball
     */
    Boolean oobX() {
        Ball futureBall = this.testTick();
        if ((futureBall.px() + futureBall.vx() - 20) <= 0 || 
            (futureBall.px() + futureBall.vx() + 20) >= 800 ) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     *Determines if the ball is out of y bounds.
     *
     * @return a ball
     */
    Boolean oobY() {
        Ball futureBall = this.testTick();
        if ((futureBall.py() + futureBall.vy() - 20) <= 0 ||
            (futureBall.py() + futureBall.vy() + 20) >= 600 ) {
            return true;
        }
        else {
            return false;
        }
    }
}
