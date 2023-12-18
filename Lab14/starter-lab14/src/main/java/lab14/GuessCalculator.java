package lab14;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class GuessCalculator {
    List<String> tempWordList;
    LinkedList<String> wordList;
    LinkedList<String> wordListFinal;
    ArrayList<String> unguessedCons = new ArrayList<String>();
    ArrayList<String> unguessedVows = new ArrayList<String>();
    ArrayList<String> unguessedConsVol = new ArrayList<String>();
    ArrayList<String> unguessedVowsVol = new ArrayList<String>();
    public GuessCalculator(String fileName) {
        var unguessedConsSetup = ("bcdfghjklmnpqrstvwxyz").split("");
        var unguessedVowsSetup = ("aeiou").split("");
        var unguessedConsVol = unguessedConsSetup;
        var unguessedVowsVol = unguessedVowsSetup;
        for (var ii = 0; ii < 21; ii++) {
            unguessedCons.add(unguessedConsSetup[ii]);
        }
        for (var ii = 0; ii < 5; ii++) {
            unguessedVows.add(unguessedVowsSetup[ii]);
        }
        InputStream txt = App.class.getResourceAsStream("words.txt");
        InputStreamReader rdr = new InputStreamReader(txt);
        BufferedReader buf = new BufferedReader(rdr);
        tempWordList = buf.lines().toList();
        wordList = new LinkedList<String>();
        for (var ii : tempWordList) {
            wordList.add(ii);
        }
            
       wordListFinal = wordList;
        
        
        
    }
    public String getList() {
        return wordList.toString();
    }

    public String bestGuess(String puzzle, String guesses) {
        var guesses1 = guesses.split("");
        var guessesFinal = new ArrayList<String>();
        for (var ii = 0; ii < guesses.length(); ii++) {
            guessesFinal.add(guesses1[ii]);
        }
        for (var ii : guessesFinal) {
            if (unguessedCons.contains(ii)) {
                unguessedConsVol.remove(ii);
            }
            if (unguessedVows.contains(ii)) {
                unguessedVowsVol.remove(ii);
            }
        }
        var puzzle1 = puzzle.split("");
        var successfulGuesses = new ArrayList<String>();
        for (var ii = 0; ii < puzzle.length(); ii++) {
            if (puzzle1[ii] != "" && puzzle1[ii] != "-") {
                successfulGuesses.add(puzzle1[ii]);
            }
        }
        var unsuccessfulGuesses = new ArrayList<String>() ;
        for (var ii : guessesFinal) {
            if (!successfulGuesses.contains(ii)) {
                unsuccessfulGuesses.add(ii);
            }
        }
        
        for (var ii = 0; ii< wordList.size(); ii ++) {
            for (var yy = 0; yy < wordList.get(ii).length(); yy++) {
                 
                    //wordListFinal.remove(word);
                
            }
        }    
        
        for (var ii = 0; ii < wordList.size(); ii++) {
            for (var yy = 0; yy < wordList.get(ii).length(); yy++) {
            for (var zz = 0; zz < successfulGuesses.size(); zz ++) {
                
                if (wordList.get(ii).contains((successfulGuesses.get(zz)))) {
                    wordListFinal.remove(wordList.get(ii));
                }
            }
        }
        }
        
        var guessWeight = new HashMap<String,Integer>();
        for (var word : wordList) {
            var newWord = word.split("");
            for (var ii = 0; ii < word.length(); ii++) {
                if (guesses.contains(newWord[ii])) {
                    continue;
                }
                if (guessWeight.containsKey(newWord[ii])) {
                    var newWeight = (guessWeight.get(newWord[ii]) + 1);
                    guessWeight.replace(newWord[ii], newWeight);
                }
                else {
                    guessWeight.put(newWord[ii], 1);
                }
            }
        }
        
        var keys = guessWeight.keySet();
        var greatestValue = 0;
        var letter = "a";
        for (var key : keys) {
            System.out.println(key);
            System.out.println(guessWeight.keySet());
            if (guessWeight.get(key) > greatestValue) {
                greatestValue = guessWeight.get(key);
                letter = key;
            }
        }
        return letter;
        
    }
}