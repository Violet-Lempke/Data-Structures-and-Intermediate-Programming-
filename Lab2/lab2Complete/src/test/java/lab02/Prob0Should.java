package lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static lab02.Prob0.doubleString;

public class Prob0Should {
    @Test
    void run_tests() {
        // Replace this with real tests for Problem 0
        // Test 1
        doubleString("car");
        assertEquals("carcar", doubleString("car"));

        // Test 2
        doubleString("hello");
        assertEquals("hellohello", doubleString("hello"));

    }
}
