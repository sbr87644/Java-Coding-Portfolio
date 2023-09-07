//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -  
//Lab  -  

import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import static java.lang.System.*;
import java.util.Collections;

public class MathSet {

    private Set<Integer> one;
    private Set<Integer> two;

    public MathSet() {
        one = new TreeSet<>();
        two = new TreeSet<>();
    }

    public MathSet(String o, String t) {
        one = new TreeSet<>();
        two = new TreeSet<>();
        for (String s : o.split( " ")) {
            int n = Integer.parseInt(s);
            one.add(n);
        }
        for (String s : t.split( " ")) {
            int n = Integer.parseInt(s);
            two.add(n);
        }
    }

    public Set<Integer> union() {
        Set<Integer> union = new TreeSet<>();
        union.addAll(one);
        union.addAll(two);
        return union;
    }

    public Set<Integer> intersection() {
        Set<Integer> inter = new TreeSet<>();
        Set<Integer> t = new TreeSet<>();
        t.addAll(two);
        for(Integer n : one){
            if(!t.add(n))
                inter.add(n);
        }
        return inter;
    }

    public Set<Integer> differenceAMinusB() {
        Set<Integer> diffAB = new TreeSet<>();
        Set<Integer> inter = intersection();
        for(Integer n : one){
            if(inter.add(n))
                diffAB.add(n);
        }
        return diffAB;
    }

    public Set<Integer> differenceBMinusA() {
        Set<Integer> diffBA = new TreeSet<>();
        Set<Integer> inter = intersection();
        for(Integer n : two){
            if(inter.add(n))
                diffBA.add(n);
        }
        return diffBA;
    }

    public Set<Integer> symmetricDifference() {
        Set<Integer> symmetric = new TreeSet<>();
        symmetric.addAll(differenceAMinusB());
        symmetric.addAll(differenceBMinusA());
        return symmetric;
    }

    public String toString() {
        return "Set one " + one + "\n" + "Set two " + two + "\n";
    }
}
