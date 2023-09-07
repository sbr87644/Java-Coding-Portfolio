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

public class ShortestPathGraph {

    private TreeMap<String, String> map;
    private boolean yayOrNay;
    private int shortest;

    public ShortestPathGraph(String line) {
        map = new TreeMap<>();
        shortest = Integer.MAX_VALUE;
        for (String s : line.split(" ")) {
            if (!contains(s.charAt(0) + "")) {
                map.put(s.charAt(0) + "", s.charAt(1) + "");
            } else {
                if (!map.get(s.charAt(0) + "").contains(s.charAt(1) + "")) {
                    map.put(s.charAt(0) + "", map.get(s.charAt(0) + "") + s.charAt(1) + "");
                }
            }
            if (!contains(s.charAt(1) + "")) {
                map.put(s.charAt(1) + "", s.charAt(0) + "");
            } else {
                if (!map.get(s.charAt(1) + "").contains(s.charAt(0) + "")) {
                    map.put(s.charAt(1) + "", map.get(s.charAt(1) + "") + s.charAt(0) + "");
                }
            }
        }
    }

    public boolean contains(String letter) {
        return map.containsKey(letter);
    }
    
    public boolean connected(String first, String second) {
        yayOrNay = false;
        check(first, second, "", 1);
        return yayOrNay;
    }
    
    public int steps(){
       return shortest;   
    }

    public void check(String first, String second, String placesUsed, int steps) {
        if (contains(first)) {
            if (map.get(first).contains(second)) {
                yayOrNay = true;
                shortest = steps;
            } else {
                String list = map.get(first);
                for (int i = 0; i < list.length(); i++) {
                    String s = list.charAt(i) + "";
                    if (!placesUsed.contains(s)) {
                        if (map.get(s).contains(second) ) {
                            yayOrNay = true;
                            shortest = steps + 1 < shortest ? steps + 1: shortest;
                        } else {
                            check(s, second, placesUsed + s, steps + 1);
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
