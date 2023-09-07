//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -  
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;
import static java.lang.System.*;
import java.util.Arrays;

public class BiDirectionalGraph {

    private TreeMap<String, TreeSet<String>> map;
    private boolean yahOrNay;

    public BiDirectionalGraph(String line) {
        map = new TreeMap();
        String[] names = line.split(" ");
        for (int i = 0; i < names.length; i += 2) {
            if (!contains(names[i])) {
                map.put(names[i], new TreeSet());
                map.get(names[i]).add(names[i + 1]);
            } else {
                map.get(names[i]).add(names[i + 1]);
            }
            if (!contains(names[i + 1])) {
                map.put(names[i + 1], new TreeSet());
                map.get(names[i + 1]).add(names[i]);
            } else {
                map.get(names[i + 1]).add(names[i]);
            }
        }
    }

    public boolean contains(String name) {
        return map.containsKey(name);
    }
    
    public boolean connected(String first, String second) {
        yahOrNay = false;
        check(first, second, new TreeSet());
        return yahOrNay;
    }

    public void check(String first, String second, TreeSet<String> placesUsed) {
        if (contains(first)) {
            if (map.get(first).contains(second)) {
                yahOrNay = true;
            } else {
                TreeSet<String> list = map.get(first);
                for (String s: list) {
                    if (!placesUsed.contains(s)) {
                        if (map.get(s).contains(second)) {
                            yahOrNay = true;
                            return;
                        } else {
                            placesUsed.add(s);
                            check(s, second, placesUsed);
                        }
                    }
                }
            }
        }
    }

    public String toString() {
        return map.toString();
    }
}
