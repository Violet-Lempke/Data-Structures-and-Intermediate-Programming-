package lab05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import lab05.ArrayList;

public class ArrayListShould {
    @Test
    void have_starter_code_work() {
        var a1 = new ArrayList<String>();
        assertEquals(0, a1.length());
        assertEquals(4, a1.capacity());

        var a2 = new ArrayList<Integer>(11);
        a2.append(4);
        assertEquals(1, a2.length());
        assertEquals(11, a2.capacity());

        Long[] nums3 = {10L, 15L, 20L, 25L};
        var a3 = new ArrayList<Long>(nums3);
        assertEquals(15L, a3.get(1));
        a3.set(2, 7L);
        assertEquals(7L, a3.get(2));
    }

    @Test
    void test_map() {
        Integer[] nums4 = {1, 2, 3, 4};
        var a4 = new ArrayList<Integer>(nums4);
        var a5 = a4.map((xx) -> xx * 2);
        assertEquals("[2 4 6 8 ]", a5.toString());
    }

    @Test
    void test_filter() {
        Integer[] nums4 = {1, 2, 3, 4};
        var a4 = new ArrayList<Integer>(nums4);
        var a5 = a4.filter((xx) -> xx % 2 == 0);
        assertEquals("[2 4 ]", a5.toString());
    }
}
