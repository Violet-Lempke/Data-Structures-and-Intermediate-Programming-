package lab04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class PairShould {
   
    
    @Test 
    void swap_sides1() {
        var p1 = new Pair<>("a", 5.0);
        var p1Swapped = new Pair<>(5.0, "a");
        assertEquals(p1Swapped, p1.swap());
    }
}
