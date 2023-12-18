package lab07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConsListShould {
    @Test
    void still_work() {
        var xs = ConsList.list(1, 2, 3, 4, 5);
        assertEquals(1, xs.first());
        assertEquals(ConsList.list(2, 3, 4, 5), xs.rest());
        assertEquals(5, xs.length());
        assertTrue(!xs.empty());

        ConsList<String> ys = new Empty<String>();
        for (int ii = 0; ii < 173; ++ii) {
            ys = ConsList.cons("item " + ii, ys);
        }

        assertEquals("item 172", ys.first());
        assertEquals(173, ys.length());

        assertTrue(ConsList.list().empty());
    }
}
