package lab03;
/**
 *Creates a course list for problem 4.
 *
 *@author Violet Lempke
 */
public class Prob4 {
    public static void main(String[] args) {
        System.out.println("Problem 4");
        CourseList xs = new CourseEmpty();
        xs = new CourseCell(new Course("Data Structures", "Tuck", "CS"), xs);
        xs = new CourseCell(new Course("Calc II", "Case", "MA"), xs);
        xs = new CourseCell(new Course("Finite Math", "Vinogradova", "MA"), xs);
        xs = new CourseCell(new Course("Data Structures", "Tuck", "CS"), xs);
        xs = new CourseCell(new Course("Calc II", "Case", "MA"), xs);
        xs = new CourseCell(new Course("Finite Math", "Vinogradova", "MA"), xs);
        CourseList xy = xs;
        csPrint(xy);
    }   
    /**
    *prints all CS courses.
    *
    * @param courseList CourseList
    *
    */   
    static void csPrint(CourseList courseList) {
    
    
        CourseList xy = courseList;
        var xx = xy.empty();
        while (xx == false) {
            var bb = xy.first();
            var det = bb.program();
            if (det == "CS") {
                System.out.println(bb);
            }
            xy = xy.rest();
            xx = xy.empty();
        }
    }   

}
