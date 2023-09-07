//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -  
//Lab  -

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Scanner;
import static java.lang.System.*;

public class Relatives {

    private Map<String, Set<String>> map;

    public Relatives() {
        map = new TreeMap();
    }

    public void setPersonRelative(String line) {
        String[] personRelative = line.split(" ");
        if (!map.containsKey(personRelative[0])) {
            map.put(personRelative[0], new TreeSet());
            map.get(personRelative[0]).add(personRelative[1]);
        } else
            map.get(personRelative[0]).add(personRelative[1]);
    }

    public String getRelatives(String person) {
        return map.get(person).toString();
    }

    public String toString() {
        String output = "";
        for(String p: map.keySet()){
            output+= p + " is related to " + getRelatives(p);
            output+="\n";
        }
        return output;
    }
}
