package lab13;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Represents the grades for a class.
 */ 
public class Gradebook {
    // TODO: Fields

    /**
     * Construct the gradebook from data files.
     */
    Gradebook() {
        for (var line : Files.readLines("students.txt")) {
            System.out.println(line);
        }
    }

    /**
     * Calculate the final grade for a student.
     *
     * @param  student_id  Which student
     * @return             The final grade
     */
    double finalGrade(int student_id) {
        return (double) student_id;
    }

    /**
     * Show totals for all students.
     *
     * @return  Each student with their final grade as a string.
     */
    String showTotals() {
        var yy = new StringBuilder();
        return yy.toString();
    }
}

// TODO: Add one or more record types for intermediate data.
