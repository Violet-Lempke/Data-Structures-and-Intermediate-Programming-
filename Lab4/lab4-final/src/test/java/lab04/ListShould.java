package lab04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ListShould {
    @Test
    void still_work() {
        var xs = List.list(1, 2, 3, 4);
        var ys = List.list("a", "bb", "ccc", "dddd");

        assertEquals(1, xs.first());
        assertEquals("a", ys.first());

        assertEquals(3, ys.rest().length());
        assertEquals(3, ys.rest().length());

        assertEquals(List.list(4, 3, 2, 1), xs.reverse());

        assertEquals(List.list(2, 3, 4, 5), xs.map((xx) -> xx + 1));
    }
}
