package lab13;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GradebookShould {
    @Test
    void calculate_grades() {
        var gb = new Gradebook();
        assertEquals(78.65, gb.finalGrade(7464), 0.01);
        assertEquals(89.51, gb.finalGrade(7577), 0.01);
    }

    @Test
    void show_totals() {
        var gb = new Gradebook();
        var totals = gb.showTotals();
        var correct = """
            Laura Allen 61.05
            Douglas Anderson 90.27
            Gerald Bell 59.73
            Nancy Bell 73.65
            Jerry Collins 60.86
            Thomas Davis 74.31
            Ralph Diaz 78.31
            Denise Foster 86.79
            Gregory Gomez 85.06
            James Harris 70.76
            Debra Jackson 94.79
            Jeremy Johnson 82.10
            Barbara Phillips 78.65
            Mary Phillips 73.89
            Virginia Phillips 79.02
            Patrick Scott 93.29
            Alan Sullivan 70.60
            Christian Thompson 70.95
            Sean Turner 89.51
            Alexander Williams 88.42
            """;
        assertEquals(correct, totals);
    }
}
