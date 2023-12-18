package lab07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrayQueueShould {
    @Test
    void push_an_item() {
        

        
        var xs = new ArrayQueue<String>();
        assertTrue(xs.empty());
        xs.push("hi");
        assertTrue(!xs.empty());
        
    }

    @Test
    void throw_empty_queue_exception() {
       

        
        var xs = new ArrayQueue<String>();
        String msg = null;

        try {
            xs.first();
        }
        catch(RuntimeException ee) {
            msg = ee.getMessage();
        }

        assertEquals("empty queue", msg);
        msg = null;

        try {
            var _xx = xs.shift();
        }
        catch(RuntimeException ee) {
            msg = ee.getMessage();
        }

        assertEquals("empty queue", msg);
        
    }

    @Test
    void shift_one_item() {
        

        
        var xs = new ArrayQueue<String>();
        xs.push("one");
        assertEquals("one", xs.first());
        assertEquals("one", xs.shift());
        
    }

    @Test
    void shift_several_items() {
        

        
        Queue<Integer> xs = new ArrayQueue<Integer>();

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
        
    }
}
