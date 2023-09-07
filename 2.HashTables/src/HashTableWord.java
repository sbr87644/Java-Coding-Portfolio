//� A+ Computer Science  -  www.apluscompsci.com
//Name -  
//Date -
//Class - 
//Lab  -

import java.util.LinkedList;
import java.util.Scanner;
import static java.lang.System.*;

public class HashTableWord {

    private LinkedList[] table;

    public HashTableWord() {
        table = new LinkedList[10];
    }

    public void add(Object obj) {
        Word word = new Word((String) obj);
        int i = word.hashCode();
        if (table[i] == null) {
            table[i] = new LinkedList();
            //table[i].add(word.getValue());
            //table[i].add(0);
        }
        table[i].add(word.getValue());
        //table[i].add((Integer)table[i].remove(1) + 1);
    }

    public String toString() {
        String output = "HASHTABLE\n";
        int i = 0;
        for (LinkedList list : table) {
            output += "bucket " + i + ": ";
            if (list != null) {
                for (Object s : list) {
                    output += s + " ";
                }
            }
            output += "\n";
            i++;
        }
        return output;
    }
}
