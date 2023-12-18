package lab09;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.function.Function;

/**
 * Used for counting words in a document/text file.
 *
 * @author Nat Tuck
 * @author Violet Lempke
 * @author Hunter Harris
 * @author Rider McCallum
 */
public class WordCount {
    TreeMap<String, Integer> counts;
    
    /**
     * Adds one occurrence to the counter each time a word appears.
     *
     * @author Violet Lempke
     * @author Hunter Harris
     * @author Rider McCallum
     * @param path File to read from.
     */
    public WordCount(String path) {
        var words = readWords(path);
        counts = new TreeMap<String, Integer>();

        for (var word : words) {
            if (counts.hasKey(word)) {
                int temp = counts.get(word) + 1;
                counts.delete(word);
                counts.insert(word, temp);
            }
            else {
                counts.insert(word, 1);
            }
        }
        
    }

    /**
     * Gets the count of associated word.
     *
     * @author Nat Tuck
     * @param word The word to look the count up of.
     * @return The count of the word.
     */
    int getCount(String word) {
        return counts.get(word);
    }

    /**
     * Finds the count of the most commonly occurring word.
     *
     * @author Violet Lempke
     * @author Hunter Harris
     * @author Rider McCallum
     *
     * @return Count of most common word.
     */
    int maxCount() {
        var xx = counts.toList();
        int curMax = 0;
        for (var word : xx) {
            if (word.val() > curMax) {
                curMax = word.val();
            }

        }
        return curMax;
    }
    
    /**
     * Finds the most common occurring word.
     *
     * @author Violet Lempke
     * @author Hunter Harris
     * @author Rider McCallum
     * @return Most common word.
     */
    String mostCommon() {
        var xx = counts.toList();
        int curMax = maxCount();
        for (var word : xx) {
            if (word.val() == curMax) {
                return word.key();
            }
        }
        return null;
    }
    
    /**
     * Reads words.
     *
     * @author Nat Tuck
     * @param path Existing path.
     * @return New arraylist with path?
     */
    static ArrayList<String> readWords(String path) {
        var istr = WordCount.class.getResourceAsStream(path);
        var brdr = new BufferedReader(new InputStreamReader(istr));

        var ys = new ArrayList<String>();
        brdr.lines().forEach((line) -> {
            for (var word : line.split("\\s+")) {
                ys.add(word);
            }
        });
        return ys;
    }
}
