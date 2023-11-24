package lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// You'll want to import your record here to test it
//import lab02.Pet;

public class Prob2Should {
    // Add a test method for getOlder

    private static final int Age = 0;

	@Test
    void test_is_old() {
        // This one is going to take quite a few test cases.

        //getOlder() - Test
        // Pet myPet = new Pet(Elton, Cat, 3, 10);
        // myPet.getOlder() => Pet(Elton, Cat, 4, 10)
        Pet myPet = new Pet("Elton", "Cat", 3, 10);
        assertEquals(new Pet("Elton", "Cat", 4, 10), myPet.getOlder());
        // 2nd Test
    }
    @Test
    void test_is_old1() {
        Pet myPet2 = new Pet("Baxter", "Dog", 10.5, 15);
        assertEquals(new Pet("Baxter", "Dog", 11.5, 15), myPet2.getOlder());
    
        //isOld() - Test
        // Pet myPet = new Pet(Elton, Cat, 12, 10);
        // myPet.isOld() => Age >= 10
        Pet myPet3 = new Pet("Elton", "Cat", 12, 10);
        assertEquals(true, myPet3.isOld());
    }
}
