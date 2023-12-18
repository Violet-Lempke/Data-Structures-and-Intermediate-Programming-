package lab04;

import image.ColorDatabase;

/**
 * Represents a bouncing ball for lab04.
 *
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
        return new Ball(this.color,
                        this.px + this.vx,
                        this.py + this.vy,
                        this.vx,
                        this.vy);
    }
}
