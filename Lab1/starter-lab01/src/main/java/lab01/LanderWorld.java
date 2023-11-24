package lab01;

import image.*;
import world.World;

/**
 * The world for our Lander game.
 *
 * @author Nat Tuck
 */
public class LanderWorld extends World {
    Rocket rkt;
    boolean landed;
    boolean boom;

    /**
     * Construct a LanderWorld.
     *
     * @param  rkt1  The current state of the rocket.
     * @param  l1    Has the rocket landed?
     * @param  b1    Has the rocket exploded?
     */
    LanderWorld(Rocket rkt1, boolean l1, boolean b1) {
        this.rkt = rkt1;
        this.landed = l1;
        this.boom = b1;
    }
    
    @Override
    public Scene onDraw() {
        var bg = new EmptyScene(800, 600);
        if (this.boom) {
            var msg = new Text("BOOM!", 60, "red");
            return bg.placeImage(msg, 400, 300);
        }

        if (this.landed) {
            var msg = new Text("WIN!", 60, "black");
            return bg.placeImage(msg, 400, 300);
        }

        var rkt_img = new RoundRectangle(30, 30, 10, "solid", "black");
        var fuel_txt = new Text(String.format("fuel: %.0f", rkt.fuel()), 30, "black");
        return bg
            .placeImage(rkt_img, 400, 600 - rkt.alt() - 15)
            .placeImage(fuel_txt, 70, 40);
    }

    @Override
    public LanderWorld onKey(String ke) {
        if (this.gameOver()) {
            return this;
        }

        switch (ke) {
        case " ":
            return new LanderWorld(rkt.burn(), this.landed, this.boom);
        default:
            return this;
        }   
    }

    @Override
    public LanderWorld onTick() {
        if (this.gameOver()) {
            return this;
        }

        var rkt1 = rkt.tick(this.tickRate());
        if (rkt.alt() <= 0) {
            System.out.println("Landing, vel = " + rkt1.vel());

            if (Math.abs(rkt1.vel()) < 30) {
                return new LanderWorld(rkt1, true, false);
            }
            else {
                return new LanderWorld(rkt1, false, true);
            }
        }
        else {
            return new LanderWorld(rkt1, false, false);
        }
    }

    @Override
    public double tickRate() {
        return 1.0 / 30.0;
    }
    
    private boolean gameOver() {
        return this.landed || this.boom;
    }
}

