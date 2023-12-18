package lab06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConsStackShould {
    @Test
    void push_items() {
        ConsStack<String> xs0 = new ConsStack<String>();
        Stack<String> xs1 = xs0;

        xs1.push("aa");
        xs1.push("bb");
        xs1.push("cc");

        assertEquals("aa", xs0.get(2));
        assertEquals("bb", xs0.get(1));
        assertEquals("cc", xs0.get(0));
    }

    @Test
    void pop_items() {
        Stack<Integer> xs = new ConsStack<Integer>();

        for (int ii = 0; ii < 50; ++ii) {
            xs.push(49 - ii);
        }

        for (int ii = 0; ii < 50; ++ii) {
            assertEquals(ii, xs.pop());
        }
    }

    @Test
    void peek_top() {
        Stack<String> xs = new ConsStack<String>();
        xs.push("aa");
        assertEquals("aa", xs.peek());
        xs.push("bb");
        assertEquals("bb", xs.peek());
        xs.push("cc");
        assertEquals("cc", xs.peek());
        xs.pop();
        assertEquals("bb", xs.peek());
        xs.push("dd");
        assertEquals("dd", xs.peek());
        xs.pop();
        assertEquals("bb", xs.peek());
    }

    @Test
    void check_empty() {
        Stack<String> xs = new ConsStack<String>();
        assertTrue(xs.empty());
        xs.push("aa");
        assertTrue(!xs.empty());
        assertEquals("aa", xs.pop());
        assertTrue(xs.empty());
    }
}
