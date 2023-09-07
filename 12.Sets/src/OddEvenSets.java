//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -  
//Class -
//Lab  -

import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class OddEvenSets {

    private Set<Integer> odds;
    private Set<Integer> evens;

    public OddEvenSets() {
        odds = new TreeSet<>();
        evens = new TreeSet<>();
    }

    public OddEvenSets(String line) {
        odds = new TreeSet<>();
        evens = new TreeSet<>();
        for (String s : line.split(" ")) {
            int n = Integer.parseInt(s);
            if (n % 2 == 0) {
                evens.add(n);
            } else {
                odds.add(n);
            }
        }
    }

    public String toString() {
        return "ODDS : " + odds + "\nEVENS : " + evens + "\n\n";
    }
}
