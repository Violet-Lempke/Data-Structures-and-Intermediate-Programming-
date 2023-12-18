package lab05;

import image.ColorDatabase;

/**
 * Represents a bouncing ball for lab04.
 *
 * @author Nat Tuck
 * @param color
 * @param px     X position
 * @param py     Y position
 * @param vx     X velocity
 * @param vy     Y velocity
 */
public record Ball(String color, double px, double py, double vx, double vy) {
    /**
     * Generate a random ball starting at x, y.
     *
     * @param  x  Initial x position.
     * @param  y  Initial y position.
     * @return    Newly created Ball.
     */
    static Ball random(int x, int y) {
        double vx = (Math.random() * 600) - 300;
        double vy = (Math.random() * 400) - 200;
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
    Ball tick(double dt, ArrayList<Ball> bs) {
        return this.maybeBounce(dt, bs).move(dt);
    }

    private Ball move(double dt) {
        double newPx = this.px + this.vx *dt;
        double newPy = this.py + this.vy *dt;
        return new Ball(this.color, newPx, newPy, this.vx, this.vy);
    }

    /**
     * If the ball is within its radius of an edge, set the sign
     * of its velocity so it's moving away from that edge.
     */
    Ball maybeBounce(double dt, ArrayList<Ball> bs) {
        final double BR = BallWorld.BS / 2;
        var vx = this.vx;
        var vy = this.vy;
              
        var b0 = bs.clone();
        for (int ii = 0; ii < bs.length(); ++ii) {
            if (!(b0.get(ii) == this)) {

                var px2 = b0.get(ii).px;
                var py2 = b0.get(ii).py;

                if ((this.px + BallWorld.BS >= px2) 
                                    && (this.px <= px2 + BallWorld.BS)
                                    && (this.py + BallWorld.BS >= py2)
                                    && (this.py <= py2 + BallWorld.BS)) {

                    vx *= (-1);
                    vy *= (-1);
                }
            }
        }

        if (this.px - BR <= 0) {
            vx = setSign(vx, +1);
        }
        if (this.px + BR >= BallWorld.WW) {
            vx = setSign(vx, -1);
        }
        if (this.py - BR <= 0) {
            vy = setSign(vy, +1);
        }
        if (this.py + BR >= BallWorld.HH) {
            vy = setSign(vy, -1);
        }

        return new Ball(this.color, this.px, this.py, vx, vy);
    }

    private static double setSign(double xx, double sign) {
        return Math.signum(sign) * Math.abs(xx);
    }

    private double distance(Ball b1) {
        double dx2 = Math.pow(this.px() - b1.px(), 2.0);
        double dy2 = Math.pow(this.py() - b1.py(), 2.0);
        return Math.sqrt(dx2 + dy2);

    }
}
