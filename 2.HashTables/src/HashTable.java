//� A+ Computer Science  -  www.apluscompsci.com
//Name -  
//Date -
//Class - 
//Lab  -

import java.util.LinkedList;
import java.util.Scanner;
import static java.lang.System.*;

public class HashTable {

    private LinkedList[] table;

    public HashTable() {
        table = new LinkedList[10];
    }

    public void add(Object obj) {
        Number num = new Number((int) obj);
        int i = num.hashCode();
        if(table[i] == null){
            table[i] = new LinkedList();
        }
        table[i].add(num.getValue());
    }

    public String toString() {
        String output = "HASHTABLE\n";
        int i = 0;
        for(LinkedList list: table){
            output+= "bucket " + i + ": ";
            for(Object n: list){   
                 output+= n + " ";
            }
            output+= "\n";
            i++;
        }
        return output;
    }
}
