package lab13;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordsShould {

    @Test
    void quickly_find_word() {
        List<String> xs = Files.readWords();
        assertTrue(Words.wordExists(xs, "star"));
        assertTrue(!Words.wordExists(xs, "grak"));
    }

    @Test
    void detect_palindromes() {
        assertTrue(Words.isPalindrome("bob"));
        assertTrue(!Words.isPalindrome("oboe"));
    }

    @Test
    void longest_palindrome_length() {
        List<String> xs = Files.readWords();
        assertEquals(5, Words.maxPalindromeLength(xs));
    }
}
