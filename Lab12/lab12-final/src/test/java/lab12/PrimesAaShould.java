package lab12;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimesAaShould {
    @BeforeAll
    static void init() {
        var limit = new TimeLimit(5);
        limit.start();
    }
    
    @Test
    void find_primes_to_100() throws Exception {
        assertEquals(25, NewPrimes.findPrimes(100, 1).size());
        assertEquals(25, Primes.findPrimes(100, 8).size());
    }

    @Test
    void find_primes_to_10000() throws Exception {
        assertEquals(1229, NewPrimes.findPrimes(10000, 1).size());
        assertEquals(1229, NewPrimes.findPrimes(10000, 8).size());
    }

    @Test
    void find_primes_to_1000000() throws Exception {
        assertEquals(78498, NewPrimes.findPrimes(1000000, 8).size());
    }
}
