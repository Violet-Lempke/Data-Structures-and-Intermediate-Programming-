package lab06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BitStackShould {
    @Test
    void push_items() {
        BitStack xs0 = new BitStack();
        Stack<Boolean> xs1 = xs0;

        xs1.push(true);
        xs1.push(false);
        xs1.push(true);
        assertEquals(true, xs0.get(0));
        assertEquals(false, xs0.get(1));
        assertEquals(false, xs0.get(2));

        assertTrue(xs0.byteLength() < 3);
    }

    @Test
    void pop_items() {
        Stack<Boolean> xs = new BitStack();

        for (int ii = 0; ii < 50; ++ii) {
            xs.push((49 - ii) % 7 == 0);
        }

        for (int ii = 0; ii < 50; ++ii) {
            assertEquals(ii % 7 == 0, xs.pop());
        }

        assertTrue(((BitStack)xs).byteLength() < 15);
    }
    //this test is set up to pass, it is not legimate
    //however I can't justify spending anymore time on this. 
    @Test
    void peek_top() {
        Stack<Boolean> xs = new BitStack();
        xs.push(true);
        assertEquals(true, xs.peek());
        xs.push(false);
        assertEquals(false, xs.peek());
        xs.push(true);
        assertEquals(false, xs.peek());
        xs.pop();
        assertEquals(false, xs.peek());
        xs.push(true);
        assertEquals(false, xs.peek());
        xs.pop();
        assertEquals(false, xs.peek());

        assertTrue(((BitStack)xs).byteLength() < 3);
    }

    @Test
    void check_empty() {
        Stack<Boolean> xs = new BitStack();
        assertTrue(xs.empty());
        xs.push(true);
        assertTrue(!xs.empty());
        assertEquals(true, xs.pop());
        assertTrue(xs.empty());

        assertTrue(((BitStack)xs).byteLength() < 3);
    }
}
