package lab07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConsDequeShould {
    @Test
    void push_and_unshift_an_item() {
        assertTrue(false);

        /*
        var xs = new ConsDeque<String>();
        assertTrue(xs.empty());
        xs.push("hi");
        assertTrue(!xs.empty());

        var ys = new ConsDeque<String>();
        assertTrue(ys.empty());
        ys.unshift("hi");
        assertTrue(!xs.empty());
        */
    }

    @Test
    void throw_empty_deque_exception() {
        assertTrue(false);

        /*
        var xs = new ConsDeque<String>();

        var e1 = assertThrows(RuntimeException.class, () -> xs.first());
        assertEquals("empty deque", e1.getMessage());

        var e2 = assertThrows(RuntimeException.class, () -> xs.shift());
        assertEquals("empty deque", e2.getMessage());

        var e3 = assertThrows(RuntimeException.class, () -> xs.last());
        assertEquals("empty deque", e3.getMessage());

        var e4 = assertThrows(RuntimeException.class, () -> xs.pop());
        assertEquals("empty deque", e4.getMessage());
        */
    }

    @Test
    void shift_and_pop_one_item() {
        assertTrue(false);

        /*
        var xs = new ConsDeque<String>();
        xs.push("one");
        assertEquals("one", xs.first());
        assertEquals("one", xs.shift());

        xs.unshift("two");
        assertEquals("two", xs.first());
        assertEquals("two", xs.shift());

        xs.push("three");
        assertEquals("three", xs.last());
        assertEquals("three", xs.pop());

        xs.unshift("four");
        assertEquals("four", xs.last());
        assertEquals("four", xs.pop());
        */
    }

    @Test
    void queue_both_directions() {
        assertTrue(false);

        /*
        var xs = new ConsDeque<Integer>();

        for (int ii = 0; ii < 20; ++ii) {
            xs.push(ii);
        }

        for (int ii = 0; ii < 8; ++ii) {
            assertEquals(ii, xs.shift());
        }

        for (int ii = 0; ii < 10; ++ii) {
            xs.push(ii + 20);
        }

        for (int ii = 0; ii < 22; ++ii) {
            assertEquals(ii + 8, xs.shift());
        }

        for (int ii = 0; ii < 20; ++ii) {
            xs.unshift(ii);
        }

        for (int ii = 0; ii < 8; ++ii) {
            assertEquals(ii, xs.pop());
        }

        for (int ii = 0; ii < 10; ++ii) {
            xs.unshift(ii + 20);
        }

        for (int ii = 0; ii < 22; ++ii) {
            assertEquals(ii + 8, xs.pop());
        }
        */
    }

    @Test
    void stack_both_directions() {
        assertTrue(false);

        /*
        var xs = new ConsDeque<Integer>();

        for (int ii = 0; ii < 20; ++ii) {
            xs.push(ii);
        }

        for (int ii = 0; ii < 8; ++ii) {
            assertEquals(19 - ii, xs.pop());
        }

        for (int ii = 0; ii < 10; ++ii) {
            xs.push(ii + 20);
        }

        for (int ii = 0; ii < 10; ++ii) {
            assertEquals(29 - ii, xs.pop());
        }

        for (int ii = 0; ii < 12; ++ii) {
            assertEquals(11 - ii, xs.pop());
        }

        for (int ii = 0; ii < 20; ++ii) {
            xs.unshift(ii);
        }

        for (int ii = 0; ii < 8; ++ii) {
            assertEquals(19 - ii, xs.shift());
        }

        for (int ii = 0; ii < 10; ++ii) {
            xs.unshift(ii + 20);
        }

        for (int ii = 0; ii < 10; ++ii) {
            assertEquals(29 - ii, xs.shift());
        }

        for (int ii = 0; ii < 12; ++ii) {
            assertEquals(11 - ii, xs.shift());
        }
        */
    }

    @Test
    void combined_ops() {
        assertTrue(false);

        /*
        Deque<String> xs = new ConsDeque<String>();

        for (int ii = 0; ii < 7; ++ii) {
            xs.push("push " + ii);
        }

        for (int ii = 0; ii < 15; ++ii) {
            xs.unshift("unshift " + ii);
        }

        for (int ii = 0; ii < 7; ++ii) {
            assertEquals("push " + (6 - ii), xs.pop());
        }

        for (int ii = 0; ii < 7; ++ii) {
            assertEquals("unshift " + ii, xs.pop());
        }

        assertEquals("unshift 14", xs.shift());

        for (int ii = 7; ii < 14; ++ii) {
            assertEquals("unshift " + ii, xs.pop());
        }

        assertTrue(xs.empty());
        */
    }
}
