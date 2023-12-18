package lab03;
//Largely based on the notes from Notes: 06 Linked List
/**
 *sets the stage for problem 3.
 *
 *@author Violet Lempke
 */
public class Prob3 {
    /**
     *allows problem 3 to run.
     *
     *@author Violet Lempke
     * @param args im sure these do something 
     */
    public static void main(String[] args) {
        System.out.println("Problem 3");

        // CourseList xs = new CourseEmpty();
    }
}

// record Course(...) {}

/**
*Holds the neccassary information about a course.
*
*@author Violet Lempke
*
*@param name String
*
*@param teachName String
*
*@param program String
*/
record Course(String name, String teachName, String program){

}




/**
*Creates the neccassary methods for a courselist.
*
*@author Violet Lempke 
*/
interface CourseList {

    /**
    *Returns if a cell is empty.
    *
    *@author Violet Lempke
    *
    * @return a boolean
    */
    boolean empty();
    /**
    *Sets up the first cell of a list as a course.
    *
    *@author Violet Lempke
    *
    * @return a Course
    */
    Course first();
    /**
    *Sets up the rest of a cell as a list.
    *
    *@author Violet Lempke
    *
    * @return a list
    */
    CourseList rest();

}
     

// record CourseEmpty()
/**
 *Creates new norms for an empty list.
 *
 *@author Violet Lempke
 *
 *
 */
record CourseEmpty() implements CourseList {
    @Override

    
    public boolean empty() {
        return true;
    }

    @Override

   
    public Course first() {
        throw new Error("empty list");
    }
    @Override
   
    public CourseList rest() {
        throw new Error("empty list");
    }
}
// record CourseCell(...)
/**
 *Used to set norms for a full list.
 *
 *@author Violet Lempke
 *
 *@param first Course
 *
 *@param rest CourseList
 *
 */
record CourseCell (Course first, CourseList rest) implements CourseList  {
    @Override
    
    public boolean empty() {
        return false;
    
    }
}

