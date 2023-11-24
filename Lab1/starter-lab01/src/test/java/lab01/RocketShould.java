package lab01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RocketShould {
    final static double G = 50.0;

    @Test
    void fall_on_tick() {
	var r0 = new Rocket(100.0, 10.0, 10.0);
	var r1 = r0.tick(0.1);
        assertEquals(r1.vel(), 10.0 - 0.1*G, 0.0001);
        assertEquals(r1.alt(), 100.0 + 0.1*10.0, 0.0001);
    }

    @Test
    void acclerate_on_burn_with_fuel() {
	var r0 = new Rocket(100.0, 15.0, 10.0);
        var r1 = r0.burn();
        assertEquals(r1.vel(), 15.0 + 75.0, 0.0001);
    }

    @Test
    void not_acclerate_on_burn_without_fuel() {
	var r0 = new Rocket(100.0, 15.0, 0.0);
        var r1 = r0.burn();
        assertEquals(r1.vel(), 15.0, 0.0001);
    }

}
