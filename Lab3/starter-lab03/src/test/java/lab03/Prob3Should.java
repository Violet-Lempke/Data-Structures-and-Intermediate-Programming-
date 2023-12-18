package lab03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// If you're interested in a better way to test exceptions:
// import static org.junit.jupiter.api.Assertions.assertThrows;
// https://junit.org/junit5/docs/current/user-guide/#writing-tests-assertions

public class Prob3Should {

    /*
    CourseList example1() {
        CourseList xs = new CourseEmpty();
        xs = new CourseCell(new Course("Data Structures", "Tuck", "CS"), xs);
        xs = new CourseCell(new Course("Calc II", "Case", "MA"), xs);
        xs = new CourseCell(new Course("Finite Math", "Vinogradova", "MA"), xs);
        return xs;
    }
    */

    // TODO: Add 4 more test methods.
    

    @Test
    void test_empty_first () {
        assertTrue(false);
        /*
        boolean gotError = false;
        CourseList xs = new CourseEmpty();
        try {
            xs.first();
        }
        catch (Error _ee) {
            gotError = true;
        }

        assertTrue(gotError, "empty.first() should throw");
        */
    }

    @Test
    void test_cell_rest () {
        assertTrue(false);
        /*
        CourseList xs = example1();
        assertEquals("Calc II", xs.rest().first().name());
        */
    }
}


