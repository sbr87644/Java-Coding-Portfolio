
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;
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
public class Grammar {

    Map<String, List<String>> rules;

    public Grammar(List<String> r) {
        if (r.isEmpty()) {
            throw new IllegalArgumentException();
        }
        rules = new TreeMap<>();
        for (String s : r) {
            String[] list = s.split("::=");
            if (!rules.containsKey(list[0])) {
                rules.put(list[0], new ArrayList());
            }
            for (String w : list[1].split("[|]")) {
                rules.get(list[0]).add(w);
            }
        }
    }

    public boolean isNonTerminal(String symbol) {
        if (symbol.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return rules.containsKey(symbol);
    }

    public String toString() {
        return rules.keySet().toString();
    }

    public String getRandom(String nonterminal) {
        if (nonterminal.isEmpty() || !isNonTerminal(nonterminal)) {
            throw new IllegalArgumentException();
        }
        String rand = "";
        String r = rules.get(nonterminal).get((int) (Math.random() * rules.get(nonterminal).size()));
        for (String term : r.split(" ")) {
            if (isNonTerminal(term)) {
                rand += getRandom(term);
            } else {
                rand += term + " ";
            }
        }
        return rand;
    }

    public List<String> getRandom(int number, String nonterminal) {
        if (number < 0 || !isNonTerminal(nonterminal) || nonterminal.isEmpty()) {
            throw new IllegalArgumentException();
        }
        List<String> random = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            random.add(getRandom(nonterminal));
        }
        return random;
    }
}
