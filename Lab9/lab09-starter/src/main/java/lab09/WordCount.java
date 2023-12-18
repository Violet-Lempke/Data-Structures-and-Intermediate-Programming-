package lab09;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.function.Function;

public class WordCount {
    TreeMap<String, Integer> counts;
    
    public WordCount(String path) {
        var words = readWords(path);
        counts = new TreeMap<String, Integer>();

        for (var word : words) {
            // TODO: build up an occurance count of each word
            // in the map 'counts'
        }
    }

    int getCount(String word) {
        return counts.get(word);
    }

    int maxCount() {
        // TODO: return the count for the most repeated word
        return 35;
    }

    String mostCommon() {
        // TODO: return the most repeated word
        return "charmander";
    }
    
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
