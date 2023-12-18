package lab10;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HashMapShould {
    @Test
    void put_and_get_two() {
        var sounds = new HashMap<String, String>();
        assertEquals(0, sounds.size());

        sounds.put("cow", "moo");
        sounds.put("dog", "bork");
        assertEquals("moo", sounds.get("cow"));
        assertEquals("bork", sounds.get("dog"));
        assertEquals(2, sounds.size());
    }

    @Test
    void put_and_get_many() {
        var ns = new HashMap<Integer, String>();
        for (int ii = 0; ii < 101; ++ii) {
            int xx = ((ii + 1) * 4951) % 101;
            ns.put(xx, "z"+xx);
        }
        assertEquals(101, ns.size());

        for (int ii = 0; ii < 101; ++ii) {
            assertEquals("z"+ii, ns.get(ii));
        }
    }

    @Test
    void replace_and_delete() {
        var ns = new HashMap<Integer, String>();
        for (int ii = 0; ii < 101; ++ii) {
            int xx = ((ii + 1) * 4951) % 101;
            ns.put(xx, "z"+xx);
        }
        assertEquals(101, ns.size());

        ns.del(57);
        ns.del(35);

        assertEquals(99, ns.size());

        var ee = assertThrows(RuntimeException.class, () -> ns.get(57));
        assertEquals("key not found", ee.getMessage());
    }

    @Test
    void maintain_reasonable_load_factor() {
        var ns = new HashMap<Integer, String>();
        for (int ii = 0; ii < 511; ++ii) {
            int xx = ((ii + 1) * 4951) % 65537;
            ns.put(xx, "z"+xx);
            assertTrue(ns.loadFactor() < 2.0);
        }
        assertEquals(511, ns.size());
    }


    @Test
    void handle_address_keys() {
        var a1 = Address.newRandom();
        var a2 = Address.newRandom();

        var a1p = new ArrayList<String>();
        a1p.add("Socks");
        a1p.add("Moustache Wax");
        var a2p = new ArrayList<String>();
        a2p.add("Cocoa Powder");

        var packages = new HashMap<Address, ArrayList<String>>();
        packages.put(a1, a1p);
        packages.put(a2, a2p);

        assertEquals(a2p, packages.get(a2));
        assertEquals(a1p, packages.get(a1));
        assertTrue(!a1p.equals(packages.get(a2)));
    }

    @Test
    void handle_lots_of_collisions() {
        var mm = new HashMap<BadHasher, Integer>();
        for (int ii = 0; ii < 1000; ++ii) {
            var xx = new BadHasher(ii);
            mm.put(xx, ii);
        }
        for (int ii = 0; ii < 1000; ++ii) {
            var zz = new BadHasher(ii);
            assertTrue(mm.hasKey(zz));
            assertEquals(ii, mm.get(zz));
        }
        for (int ii = 1000; ii < 2000; ++ii) {
            assertTrue(!mm.hasKey(new BadHasher(ii)));
        }
    }
}

class BadHasher {
    int vv;

    BadHasher(int vv) {
        this.vv = vv;
    }

    @Override
    public int hashCode() {
        return 75 + Math.floorMod(this.vv, 4);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof BadHasher)) {
            return false;
        }
        BadHasher that = (BadHasher) other;
        return this.vv == that.vv;
    }
}
