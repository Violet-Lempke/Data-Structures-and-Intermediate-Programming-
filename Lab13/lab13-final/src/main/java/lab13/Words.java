package lab13;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Words problems.
 *
 * @author Erica Guenther
 * @author Violet Lempke
 */
public class Words {
    /**
     * Check if word exists in list using binary search.
     *
     * @param xs   List of words
     * @param word The word to look for
     * @return True if word is in list
     */
    static boolean wordExists(List<String> xs, String word) {
        if (Collections.binarySearch(xs, word) > -1) {
            return true;
        }

        else {
            return false;
        }
    }

    /**
     * Check if a word is a palindrome.
     *
     * @param word The word
     * @return True if word is a palindrome
     */
    static boolean isPalindrome(String word) {
        StringBuilder PotentialPalindromeSB = new StringBuilder(word);
        String PotentialPalindrome = PotentialPalindromeSB.reverse().toString();
        if (word.equalsIgnoreCase(PotentialPalindrome)) {
            return true;
        }

        else {
            return false;
        }

    }

    /**
     * Find the length of the longest palindrome in a list.
     *
     * @param xs List of words
     * @return Length of the longest palindrome in list
     */
    static int maxPalindromeLength(List<String> xs) {
        int longestLength = 0;
        for (var curWord : xs) {
            if (isPalindrome(curWord)) {
                if (curWord.length() > longestLength) {
                    longestLength = curWord.length();
                }
            }
        }
        return longestLength;
    }
}
