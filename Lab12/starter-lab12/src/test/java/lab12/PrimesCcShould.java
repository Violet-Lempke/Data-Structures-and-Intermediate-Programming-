package lab12;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimesCcShould {
    @Test
    void find_1b_primes() {
        var limit = new TimeLimit(10);
        limit.start();

        assertEquals(50847534, Primes.findPrimes(1000 * 1000 * 1000, 8).size());
    }
}
