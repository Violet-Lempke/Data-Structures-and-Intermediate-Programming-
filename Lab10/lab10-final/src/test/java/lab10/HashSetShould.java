package lab10;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HashSetShould {
    @Test
    void add_and_remove_items() {
        var xs = HashSet.set(2, 6, 15);
        xs.add(5);
        assertEquals(HashSet.set(2, 5, 6, 15), xs);
        xs.remove(6);
        assertEquals(HashSet.set(2, 5, 15), xs);
    }

    @Test
    void do_contains() {
        var xs = HashSet.set("aa", "cc", "dd");
        assertTrue(xs.contains("aa"));
        assertTrue(!xs.contains("bb"));
        assertTrue(xs.contains("cc"));
        assertTrue(xs.contains("dd"));
        assertTrue(!xs.contains("aaa"));
        assertTrue(!xs.contains(""));
    }

    @Test
    void do_union() {
        var xs = HashSet.set(3, 6, 9);
        var ys = HashSet.set(2, 4, 6);
        assertEquals(HashSet.set(2, 3, 4, 6, 9), xs.union(ys));
        assertEquals(HashSet.set(2, 3, 4, 6, 9), ys.union(xs));
        assertEquals(xs, xs.union(xs));
        assertEquals(ys, ys.union(ys));
    }

    @Test
    void do_intersection() {
        var xs = HashSet.set(3, 6, 9);
        var ys = HashSet.set(2, 4, 6);
        var zs = HashSet.set(2, 4, 8, 16);
        var actualIntersection = HashSet.set(2,4);
        assertEquals(HashSet.set(6), xs.intersection(ys));
        assertEquals(HashSet.set(2, 4), zs.intersection(ys));
        assertEquals(actualIntersection, zs.intersection(ys));
    }

    @Test
    void do_subset() {
        var xs = HashSet.set(3, 6);
        var ys = HashSet.set(2, 3, 5, 6, 8);
        var zs = HashSet.set(2,5, 6, 8);
        assertTrue(xs.isSubset(xs));
        assertTrue(xs.isSubset(ys));
        assertTrue(!xs.isSubset(zs));
    }

    @Test
    void do_superset() {
        var xs = HashSet.set(3, 6);
        var ys = HashSet.set(2, 3, 5, 6, 8);
        var zs = HashSet.set(2, 5, 6, 8);
        assertTrue(ys.isSuperset(ys));
        assertTrue(ys.isSuperset(xs));
        assertTrue(!xs.isSuperset(ys));
        assertTrue(!zs.isSuperset(xs));
    }

    @Test
    void lots_of_addresses() {
        var xs = new HashSet<Address>();
        var ys = new ArrayList<Address>();
        for (int ii = 0; ii < 1000; ++ii) {
            var zz = Address.newRandom();
            xs.add(zz);
            ys.add(zz);
        }

        for (var yy : ys) {
            assertTrue(xs.contains(yy));
        }

        for (int ii = 0; ii < 1000; ++ii) {
            var zz = Address.newRandom();
            assertTrue(!xs.contains(zz));
        }
    }

    @Test
    void set_of_sets() {
        var xs = HashSet.set(HashSet.set("a", "b"), HashSet.set("a"));
        assertTrue(xs.contains(HashSet.set("a", "b")));
        assertTrue(!xs.contains(HashSet.set("a", "c")));
    }
}
