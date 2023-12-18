package lab03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// If you're interested in a better way to test exceptions:
// import static org.junit.jupiter.api.Assertions.assertThrows;
// https://junit.org/junit5/docs/current/user-guide/#writing-tests-assertions

public class Prob3Should {

    
    CourseList example1() {
        CourseList xs = new CourseEmpty();
        xs = new CourseCell(new Course("Data Structures", "Tuck", "CS"), xs);
        xs = new CourseCell(new Course("Calc II", "Case", "MA"), xs);
        xs = new CourseCell(new Course("Finite Math", "Vinogradova", "MA"), xs);
        return xs;
    }
    

    // TODO: Add 4 more test methods.
    
     
    @Test
    void test_empty_first () {
        var xx  = new CourseEmpty();
        var xy = xx.empty();
        assertTrue(xy);
        
        boolean gotError = false;
        CourseList xs = new CourseEmpty();
        
        try {
            xs.first();
        }
        catch (Error _ee) {
            gotError = true;
        }

        assertTrue(gotError, "empty.first() should throw");
        
    }

    @Test
    void test_rest_empty () {
        CourseList xs = new CourseEmpty();
        xs = new CourseCell(new Course("Data Structures", "Tuck", "CS"), xs);

        var xytemp = xs.rest();
        var xy = xytemp.empty();
        
        assertTrue(xy);
       
        
        CourseList xb = example1();
        
        assertEquals( "Calc II", xb.rest().first().name());
        
        
    }
    @Test
    void test_rest_full () {
        CourseList xf = example1();
        var testTemp = xf.rest();
        var test = testTemp.empty();
        assertEquals(false, test );
    }
    @Test
    void test_cell_first_empty () {
       Course xx = (new Course("Data Structures", "Tuck", "CS"));
       CourseList xs = new CourseEmpty();
       CourseCell xv = new CourseCell(xx,xs);
       
       assertEquals(false, xv.empty());
    }
    @Test
    void test_cell_rest_empty () {
    Course xx = (new Course("Data Structures", "Tuck", "CS"));
    CourseList xs = new CourseEmpty();
    CourseCell xv = new CourseCell(xx,xs);
    var testTemp = xv.rest(); 
    var test = testTemp.empty();
    assertEquals(true, test);
    }
    @Test
    void test_cell_rest_full () {
        Course xx = (new Course("Data Structures", "Tuck", "CS"));
        CourseList xs = new CourseEmpty();
        xs = new CourseCell(new Course("Finite Math", "Vinogradova", "MA"), xs);
        CourseCell xv = new CourseCell(xx,xs);
        var testTemp = xv.rest(); 
        var test = testTemp.empty();
        assertEquals(false, test);
    }     
    
}


