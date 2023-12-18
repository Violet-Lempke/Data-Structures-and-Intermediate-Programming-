package lab14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.List;
import kotlin.Pair;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import static kotlin.collections.MapsKt.mapOf;

/**
 * App class.
 *
 * @author Nat Tuck
 * @author Erica Guenther
 * @author Violet Lempke
 */
public class App {
    final static String URL = "https://words.homework.quest/socket/websocket";
    //final static String URL = "http://localhost:4000/socket/websocket";

    static Chan chan = null;
    static List<String> words;

    /**
     * Main method.
     *
     * @author Nat Tuck
     * @author Erica Guenther
     * @author Violet Lempke
     *
     * @param args An array of strings.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int zz = (int)(1000 * Math.random());
        chan = new Chan(URL, "162FINAL", "bob" + zz);
    }

    /**
     * Method called when joined to server.
     *
     * @author Nat Tuck
     * @author Erica Guenther
     * @author Violet Lempke
     *
     * @param msg Map variable containing active, puzzle, guesses.
     * @throws IOException
     */
    public static void onJoin(Map<String, Object> msg) throws IOException {
        
        try {
            System.out.println("keys here: " + msg.keySet());
            words = readWords();
            words = intitDelete(puzGetArray(msg), words);
        }
        catch (Exception ee) {
            System.out.println("error: " + ee);
            ee.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * Updates game when a guess is made.
     *
     * @author Nat Tuck
     * @author Erica Guenther
     * @author Violet Lempke
     *
     * @param msg Map variable containing active, puzzle, guesses.
     */
    public static void onView(Map<String, Object> msg) {
        
        System.out.println("keys: " + msg.keySet());
        System.out.println("puzzle: " + (String) msg.get("puzzle"));
        @SuppressWarnings("unchecked")
        var gs = new HashSet<String>((List<String>) msg.get("guesses"));
        System.out.println("guesses: " + gs);
        System.out.println("");
        words = continueDelete(puzGetArray(msg), words);
        
        if (msg.get("active").equals("162FINAL")) {
            if (((String) msg.get("puzzle")).contains("-")) {
                String[] let = puzGetArray(msg);
                
                chan.guess(frequency(words, gs));
            }
            else {
                System.out.println("Game done");
                System.exit(0);
            }
        }
        else {
            if (!((String) msg.get("puzzle")).contains("-")) {
                System.out.println("Game done");
                System.exit(0);
            }
        }
    }

    /**
     * Deletes all words that are not the same length as
     * any word in the pattern.
     *
     * @author Erica Guenther
     * @author Violet Lempke
     *
     * @param puz The puzzle.
     * @param words The words included in words.txt.
     * @return a List of Strings(words) that match the pattern.
     */
    public static List<String> intitDelete(String[] puz, List<String> words) {
        List<String> newList = new ArrayList<String>();
        for (var word : words) {
            for (int ii = 0; ii < puz.length; ++ii) {
                if (word.length() == puz[ii].length()) {
                    newList.add(word);
                }
            }
        }
        
        return newList;
    }  

    /**
     * Determines which letter occurs most
     * often in the list of potential words.
     *
     * @author Erica Guenther
     * @author Violet Lempke
     *
     * @param words The list of potential words.
     * @param gs The guessed letters.
     * @return The letter.
     */
    public static String frequency(List<String> words, HashSet<String> gs)  {
        String[] alphabet = "abcdefghijklmnopqrstuvwxyz".split("");
        ArrayList<String> alpha = new ArrayList<>();
        int intFreq = 0;
        String letFreq = "";
        ArrayList<String> vowels = new ArrayList<String>();

        for (var letter : alphabet) {
            if (!gs.contains(letter)) {
                alpha.add(letter);
            }
        }

        for (var letter : alpha) {
            var letterFreq = detFreq(words, letter);
            if (letterFreq > intFreq) {
                if (vowel(letter)) {
                    vowels.add(letter);
                }
                else {
                    intFreq = letterFreq;
                    letFreq = letter;
                }
            }
        }

        if (intFreq == 0) {
            return vowels.get(0);
        }

        return letFreq;
    }
    
    /**
     * Determines if a given letter 
     * is a vowel.
     *
     * @author Erica Guenther
     * @author Violet Lempke
     *
     * @param letter The letter.
     * @return True => vowel, False => consonant.
     */
    public static boolean vowel(String letter) {
        if (letter.equals("a")) {
            return true;
        }
        else if (letter.equals("e")) {
            return true;
        }
        else if (letter.equals("i")) {
            return true;
        }
        else if (letter.equals("o")) {
            return true;
        }
        else if (letter.equals("u")) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Determines the frequency of a letter
     * in a list of Strings/words.
     *
     * @author Erica Guenther
     * @author Violet Lempke
     *
     * @param words The list of potential words.
     * @param letter The letter.
     * @return The frequency of the letter.
     */
    public static int detFreq(List<String> words, String letter) {
        int freq = 0;
        for (var word : words) {
            String[] broken = word.split("");
            for (int ii = 0; ii < broken.length; ii++) {
                if (broken[ii].equals(letter)) {
                    freq++;
                }
            }
        }
        return freq;
    }

    /**
     * Deletes all the words that don't
     * fit the pattern.
     *
     * @author Erica Guenther
     * @author Violet Lempke
     *
     * @param puz The puzzle.
     * @param words The list of words.
     * @return The updated list of words.
     */
    public static List<String> continueDelete(String[] puz, List<String> words) {
        List<String> newList = new ArrayList<String>();
        boolean flag = false;
        for (var word : words) {
            for (int ii = 0; ii < puz.length; ++ii) {
                if (puz[ii].length() == word.length()) {
                    for (int j = 0; j < puz[ii].length(); j++) {
                        if ((puz[ii].charAt(j) == '-') || (word.charAt(j) == puz[ii].charAt(j))) {
                            flag = true;
                        }
                        else {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        newList.add(word);
                    }
                }
            }
        }
        
        return newList;
    }

    /**
     * Gets the puzzle as an array of
     * strings.
     *
     * @author Erica Guenther
     * @author Violet Lempke
     *
     * @param msg Map variable containing active, puzzle, guesses.
     * @return The puzzle.
     */
    public static String[] puzGetArray(Map<String, Object> msg) {
        String puz = ((String) msg.get("puzzle"));
        String[] let = puz.split(" ");
        return let;
    }

    /**
     * Creates a list of words from a text file.
     *
     * @author Erica Guenther
     * @author Violet Lempke
     *
     * @return A list of strings/the words.
     * @throws IOException
     */
    public static List<String> readWords() throws IOException {
        InputStream txt = App.class.getResourceAsStream("/words.txt");
        InputStreamReader rdr = new InputStreamReader(txt);
        BufferedReader buf = new BufferedReader(rdr);
        return buf.lines().toList();
    }
}
