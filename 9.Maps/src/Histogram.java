//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import static java.lang.System.*;

public class Histogram {

    private Map<Character, Integer> histogram;

    public Histogram() {
        histogram = new TreeMap();
    }

    public Histogram(String sent) {
        setSentence(sent);
    }

    public void setSentence(String sent) {
        for (char c : sent.toCharArray()) {
            if (histogram.containsKey(c)) {
                histogram.put(c, histogram.get(c) + 1);
            } else {
                histogram.put(c, 1);
            }
        }
    }

    public String toString() {
        String output = "";
        String allStars = "";
        for (char k : histogram.keySet()) {
            if (k != ' ') {
                output += k + "    ";
                for (int i = 0; i < histogram.get(k); i++) {
                    output += "*";
                }
                output += "\n";
            }
        }
        return output + "\n\n";
    }
}
