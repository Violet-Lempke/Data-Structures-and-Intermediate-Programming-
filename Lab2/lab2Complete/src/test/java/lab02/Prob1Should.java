package lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//  You'll want to import these to test them:
import static lab02.Prob1.nameOverflows;
import static lab02.Prob1.truncate;

public class Prob1Should {
    @Test
    void test_name_overflows() {
        // Replace this with real tests.
        
        
        assertEquals(true, nameOverflows("Supercalifragilisticexpialidocious")); 
        assertEquals(false,nameOverflows("rat"));
    }
    @Test
    void test_name_overflows2(){

        assertEquals("Rat", truncate("RatStraightOuttaHell", 3));
        System.out.println(truncate("RatStraight",3));

}
   
}
