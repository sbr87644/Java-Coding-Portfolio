//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -  
//Lab  -

import java.util.Map;
import java.util.TreeMap;

public class Graph {

    private TreeMap<String, String> map;
    private boolean yayOrNay;

    public Graph(String line) {
        map = new TreeMap<>();
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
        check(first, second, "");
        return yayOrNay;
    }

    public void check(String first, String second, String placesUsed) {
        if (contains(first)) {
            if (map.get(first).contains(second)) {
                yayOrNay = true;
            } else {
                String list = map.get(first);
                for (int i = 0; i < list.length(); i++) {
                    String s = list.charAt(i) + "";
                    if (!placesUsed.contains(s)) {
                        if (map.get(s).contains(second)) {
                            yayOrNay = true;
                            return;
                        } else {
                            check(s, second, placesUsed + s);
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
