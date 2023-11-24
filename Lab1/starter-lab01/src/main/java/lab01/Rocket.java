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
    public Rocket tick(double dt) {
        // Generate the new Rocket representing state after dt seconds.
        // Specifically, apply gravity.
        return this;
    }

    /**
     * Produce a new Rocket representing the state after a burn.
     *
     * @return     The Rocket after the burn is finished.
     */
    public Rocket burn() {
        // Generate the new Rocket represneting state after a burn.
        // (A burn is when the user presses the space bar).
        // If there is remaining fuel, this should decrease fuel
        // by one and increase velocity by 75.
        return this;
    }
}
