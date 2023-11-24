package lab01;

/**
 * The Rocket we're trying to land.
 *
 * @author Nat Tuck
 * @param  alt    Distance from bottom of ship to ground in pixels.
 * @param  vel    Velocity in pixels per second.
 * @param  fuel   How many burns can this rocket do?
 */
public record Rocket(double alt, double vel, double fuel) {
    final static double G = 50.0;

    /**
     * Produce a new Rocket representing the state
     * after the game ticks.
     *
     * @param  dt  Time delta since last tick.
     * @return     The Rocket after the tick.
     */
    /*@editor Violet
     * var currentVel - pulls current velocity from Rocket
     * var currentAlt - pulls current altitude from Rocket
     * Purpose: simulates gravity for Rocket
    
     */
    public Rocket tick(double dt) {
        // Generate the new Rocket representing state after dt seconds.
        // Specifically, apply gravity.
        var currentVel = vel;
        var currentAlt = alt;
        currentAlt += dt * currentVel;
        currentVel -= dt * G;
        
        return new Rocket(currentAlt,currentVel,fuel);
    }
    
    /**
     * Produce a new Rocket representing the state after a burn.
     *
     * @return     The Rocket after the burn is finished.
     */
    /*@Editor Violet
     * var currentFuel: pulls current fuel amount from rocket
     * var currentVel: pulss current Velocity from rocket
     * Purpose: Simulates rocket burning fuel to change direction when user presses space key
     */
    public Rocket burn() {
        // Generate the new Rocket represneting state after a burn.
        // (A burn is when the user presses the space bar).
        // If there is remaining fuel, this should decrease fuel
        // by one and increase velocity by 75.
        
        var currentFuel = fuel;
        var currentVel = vel;
        if (fuel != 0){
        currentFuel -= 1;
        currentVel += 75;}

        return new Rocket(alt,currentVel,currentFuel);
    }
}

