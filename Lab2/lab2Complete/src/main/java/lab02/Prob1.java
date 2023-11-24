package lab02;

/**
 * Solves problem 1.
 *
 * @author Nat Tuck
 */
public class Prob1 {
    public static void main(String name) {
        System.out.println("Problem 1");
    }

    /**
    * Checks if a sring is more than 10 characters. 
    *
    * @param name String representing the last name on a boater's license 
    * @return A boolean value
    *
    * @author Violet Lempke
    */

    static boolean nameOverflows(String name) {
        if (name.length() < 10) {
            return false;
        }
        else {
            return true;
        }
        //Template:
        //System.out.println(nameOverflows("I don't really get this whole template thing"));
        // Outputs: True   
    }
    /**
     * Shortens a string to a specified value.
     *
     * @author Violet Lempke
     * 
     * @param string a string
     * 
     * @param length an integer
     * @return A String
     */
    public static String truncate(String string, int length) {
        return (string.substring(0, (length)));
        //Template:
        //System.out.println(truncate("Violet,3"));
        //Outputs "Vio"
    }
}
