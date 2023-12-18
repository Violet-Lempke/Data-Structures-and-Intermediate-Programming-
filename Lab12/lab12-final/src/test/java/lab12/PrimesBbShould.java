package lab12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimesBbShould {
    @Test
    void find_100m_primes() {
        var limit = new TimeLimit(10);
        limit.start();

        assertEquals(5761455, NewPrimes.findPrimes(100 * 1000 * 1000, 8).size());
    }
}
