package lab13;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.zip.GZIPInputStream;

/**
 * Interact with sample word list.
 *
 * @author Nat Tuck
 */
public class Files {
    /**
     * Read sample word list.
     *
     * @return List of words
     */
    static List<String> readWords() {
        try {
            InputStream raw = App.class
                    .getResourceAsStream("/words.txt.gz");
            GZIPInputStream unz = new GZIPInputStream(raw);
            InputStreamReader rdr = new InputStreamReader(unz);
            BufferedReader buf = new BufferedReader(rdr);
            return buf.lines().toList();
        }

        catch (Exception ee) {
            throw new RuntimeException("read failed");
        }
    }

    /**
     * Read lines of text from resource file.
     *
     * @param path The path to be read.
     * @return List of lines
     */
    static List<String> readLines(String path) {
        try {
            InputStream raw = App.class
                    .getResourceAsStream("/" + path);
            InputStreamReader rdr = new InputStreamReader(raw);
            BufferedReader buf = new BufferedReader(rdr);
            return buf.lines().toList();
        }

        catch (Exception ee) {
            throw new RuntimeException("read failed");
        }
    }
}
