package lab02;


//Solves problem 2.
/**
 *A record for a pet.

 *@author Max H
 */
public class Prob2 {
    public static void main(String[] args) {
        System.out.println("Problem 2");
    }
}

// put the record for Problem 2 here.
/**
 * A record for a pet.
 *
 * @param Name      Name of the Pet
 *
 * @param Species   Species of the Pet
 *
 * @param Age       Age of the Pet in years
 *
 * @param Weight Weight of pet
 *
 * @author Max Haussmann
 */
record Pet(String Name, String Species, double Age, float Weight) {

    /**
     * Creates an Updated Obeject with the Pet's Age one year older.
     *
     * @return  The Pets Name, Species, Weight, and Age but one year older
     */
    public Pet getOlder() {
        double newAge = Age + 1;
        return new Pet(this.Name, this.Species, newAge, this.Weight);
    }
    // Examples
    // Pet myPet = new Pet(Elton, Cat, 3, 10);
    // myPet.getOlder() => Pet(Elton, Cat, 4, 10)

    //Template
    /*
     * Pet getOlder(){.
     *      ... this.Name ...
     *      ... this.Species ...
     *      ... Age ...
     *      ... this.Weight ...
     * }
     */

    /**
    * Returns if the Pet is old.
    *
    * @return if the Pet is Old depending on its age
    */
    public boolean isOld() {
        if (Species == "Mouse") {
            return Age >= 1;
        }
        else if (Species == "Dog") {
            return Age >= 10;
        }  
        else if (Species == "Cat") {
            return Age >= 10;
        }
        else if (Species == "Turtle") {
            return Age >= 20;
        }      
        else {
            return Age > 5;
        } 
    }
    // Examples
    // Pet myPet = new Pet(Elton, Cat, 12, 10);
    // myPet.isOld() => Age >= 10

    //Template
    /*
     * Pet isOld(){
            ... Species ...
     *      ... Age ...
     * }
     */
}
