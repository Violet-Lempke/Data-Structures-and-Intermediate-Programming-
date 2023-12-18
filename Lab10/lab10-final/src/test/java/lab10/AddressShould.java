package lab10;

import java.util.TreeSet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddressShould {
    @Test
    void not_have_trivial_collisions() {
        var codes = new TreeSet<Integer>();
        for (int ii = 0; ii < 500; ++ii) {
            var xx = Address.newRandom(ii + 1);
            var code = xx.hashCode();
            assertTrue(!codes.contains(code));
            codes.add(code);
        }
        assertEquals(500, codes.size());
    }
}
