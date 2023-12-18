package lab13;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.text.DecimalFormat;

/**
 * Represents the grades for a class.
 *
 * @author Erica Guenther
 * @author Violet Lempke
 */
public class Gradebook {
    Map<Integer, Student> studentMap;

    static final DecimalFormat d0 = new DecimalFormat("0.00");

    /**
     * Construct the gradebook from data files.
     */
    Gradebook() {
        studentMap = new HashMap<Integer, Student>();
        for (var line : readFileLines("/students.txt")) {
            var parts = line.split(" ");
            Integer StudentID = Integer.parseInt(parts[0]);
            String firstname = parts[1];
            String lastname = parts[2];
            studentMap.put(StudentID, new Student(StudentID, firstname, lastname));
        }

        for (var line : readFileLines("/homeworks.txt")) {
            var parts = line.split(" ");
            Integer StudentID = Integer.parseInt(parts[0]);
            Integer i0 = Integer.parseInt(parts[1]);
            Double d1 = Double.parseDouble(parts[2]);
            Assignment a0HW = new Assignment(i0, d1);
            studentMap.get(StudentID).addHomework(a0HW);
        }

        for (var line : readFileLines("/exams.txt")) {
            var parts = line.split(" ");
            Integer StudentID = Integer.parseInt(parts[0]);
            studentMap.get(StudentID).addExam(Double.parseDouble(parts[1]));
        }
    }

    /**
     * Calculate the final grade for a student.
     *
     * @param studentid Which student
     * @return The final grade
     */
    double finalGrade(int studentid) {

        var h0 = studentMap.get(studentid).calcWeightHW();
        var e0 = studentMap.get(studentid).calcWeightExams();

        return Double.parseDouble(d0.format(h0 + e0)) / 100;
    }

    /**
     * Show totals for all students.
     *
     * @return Each student with their final grade as a string.
     */
    String showTotals() {
        var yy = new StringBuilder();

        List<Map.Entry<Integer, Student>> l0 = new ArrayList<>(studentMap.entrySet());

        l0.sort(Map.Entry.comparingByValue());
        for (Map.Entry<Integer, Student> entry : l0) {
            var fin = finalGrade(entry.getKey());
            yy.append(entry.getValue().name() + " " + String.format("%.2f", fin) + "\n");
        }

        return yy.toString();
    }

    /**
     * Modifies the file input into a list.
     *
     * @param fileName The name of the file.
     * @return The file as a List of Strings.
     */
    static List<String> readFileLines(String fileName) {
        InputStream txt = App.class
                .getResourceAsStream(fileName);
        InputStreamReader rdr = new InputStreamReader(txt);
        BufferedReader buf = new BufferedReader(rdr);
        return buf.lines().toList();
    }
}

/**
 * Represents the information for a Student.
 *
 * @author Erica Guenther
 * @author Violet Lempke
 */
class Student implements Comparable {
    Integer studentID;
    String firstname;
    String lastname;
    ArrayList<Assignment> homeworkScores;
    ArrayList<Double> examScores;

    /**
     * Construtor for Student.
     *
     * @param studentID Students ID
     * @param firstname Students firstname
     * @param lastname  Students lastname
     */
    Student(Integer studentID, String firstname, String lastname) {
        this.studentID = studentID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.homeworkScores = new ArrayList<Assignment>();
        this.examScores = new ArrayList<Double>();
    }

    /**
     * Adds an assignment to the HW ArrayList.
     *
     * @param a0 The assignment to add.
     */
    void addHomework(Assignment a0) {
        homeworkScores.add(a0);
    }

    /**
     * Adds an assignment to the Exam ArrayList.
     *
     * @param grade The grade to add.
     */
    void addExam(Double grade) {
        examScores.add(grade);
    }

    /**
     * Calculates the weighted average for homeoworks.
     *
     * @return HW Weighted Average.
     */
    double calcWeightHW() {
        double total = 0;
        double assignmentNum = 0;
        for (int ii = 0; ii < homeworkScores.size(); ii++) {
            total += homeworkScores.get(ii).grade() * 100;
            assignmentNum++;
        }
        total /= assignmentNum;
        total *= 0.5;

        return total;
    }

    /**
     * Calculates the weighted average for exams.
     *
     * @return Exam Weighted Average.
     */
    double calcWeightExams() {
        double total = 0;
        double assignmentNum = 0;
        for (int ii = 0; ii < examScores.size(); ii++) {
            total += examScores.get(ii) * 100;
            assignmentNum++;
        }
        total /= assignmentNum;
        total *= 0.5;

        return total;
    }

    /**
     * Gets Student's name.
     *
     * @return The Students first and last name.
     */
    String name() {
        return firstname + " " + lastname;
    }

    /**
     * Gets Student's last name.
     *
     * @return The Student's last name.
     */
    String getLN() {
        return lastname;
    }

    @Override
    public int compareTo(Object arg0) {
        if (arg0 instanceof Student) {
            Student tt = (Student) arg0;
            if (tt.lastname.compareTo(this.lastname) < 0) {
                return 1;
            }

            else if (tt.getLN().compareTo(this.lastname) == 0) {
                if (tt.firstname.compareTo(this.lastname) < 0) {
                    return 1;
                }
                return -1;
            }

            else {
                return -1;
            }
        }
        return 1;

    }
}

/**
 * An Assignment record.
 *
 * @author Erica Guenther
 * @author Violet Lempke
 *
 * @param assignmentNumber The assignment number.
 * @param grade            The grade.
 */
record Assignment(int assignmentNumber, Double grade) {

}
