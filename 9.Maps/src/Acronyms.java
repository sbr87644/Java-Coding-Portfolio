//� A+ Computer Science  -  www.apluscompsci.com
//Name -  
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import static java.lang.System.*;

public class Acronyms {

    private Map<String, String> acronymTable;

    public Acronyms() {
        acronymTable = new TreeMap();
    }

    public void putEntry(String entry) {
        String[] acr = entry.split(" - ");
        acronymTable.put(acr[0], acr[1]);
    }

    public String convert(String sent) {
        Scanner chop = new Scanner(sent);
        String output = "";
        while (chop.hasNext()) {
            String s = chop.next();
            String p = "";
            if (s.matches(".*[.?!]")) {
                p+= s.substring(s.length() - 1);
                s = s.substring(0, s.length() - 1);
            }
            if (acronymTable.containsKey(s)) {
                output += acronymTable.get(s) + p + " ";
            } else {
                output += s + p + " ";
            }
        }

        return output;
    }

    public String toString() {
        return acronymTable.toString();
    }
}
