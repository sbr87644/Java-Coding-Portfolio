
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author s652803
 */
public class HangmanManager {

    Set<String> words;
    Set<Character> guesses;
    String pattern;
    int numGuess;

    public HangmanManager(List<String> dictionary2, int length, int max) {
        if (length < 1 || max < 0) {
            throw new IllegalArgumentException();
        }
        pattern = "";
        numGuess = max;
        guesses = new TreeSet<>();
        words = new TreeSet<>();
        for (String d : dictionary2) {
            if (d.length() == length) {
                words.add(d);
            }
        }
        for (int i = 0; i < length; i++) {
            pattern += "-";
        }
    }

    public Set<String> words() {
        return words;
    }

    public int guessesLeft() {
        return numGuess;
    }

    public Set<Character> guesses() {
        return guesses;
    }

    public String pattern() {
        if (pattern.equals("")) {
            throw new IllegalStateException();
        }
        return pattern;
    }


    public int record(char guess) {
        if (numGuess < 1 || words.isEmpty()) {
            throw new IllegalStateException();
        }
        if (!words.isEmpty() && guesses.contains(guess)) {
            throw new IllegalArgumentException();
        }
        guesses.add(guess);
        makePattern(guess);
        int count = countGuess(guess);
        if(count == 0)
            numGuess--;
        return count;
    }

    private void makePattern(char g) {
        Map<String, Set<String>> pat = new TreeMap<>();
        pat.put(pattern, new TreeSet());
        for (String s : words) {
            if (s.contains(g + "")) {
                String p = "";
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == g) {
                        p += g;
                    } else {
                        p += pattern.charAt(i);
                    }
                }
                if (pat.containsKey(p)) {
                    pat.get(p).add(s);
                } else {
                    pat.put(p, new TreeSet());
                    pat.get(p).add(s);
                }
            } else {
                pat.get(pattern).add(s);
            }
        }
        String longest = findLongest(pat);
        pattern = longest;
        words = pat.get(pattern);
    }

    private String findLongest(Map<String, Set<String>> pat) {
        String longest = "";
        for (String s : pat.keySet()) {
            if (longest.equals("")) {
                longest = s;
            } else if (pat.get(s).size() > pat.get(longest).size()) {
                longest = s;
            }
        }
        return longest;
    }
    
    private int countGuess(char g){
        int count = 0;
        for(int i = 0; i < pattern.length(); i++){
            if(pattern.charAt(i) == g)
                count++;
        }
        return count;
    }
}
