package lab03; 

 
 

import org.junit.jupiter.api.Test; 

 
 

import static org.junit.jupiter.api.Assertions.assertEquals; 

 
 

public class Prob2Should { 

 
 

    @Test 

    void find_snowman_height() { 

        Snowman s0 = Snowman.build(0); 

        assertEquals(30, s0.height()); 

        Snowman s3 = Snowman.build(3); 

        assertEquals(57, s3.height()); 

    } 

} 

 
 

 

 
 

 