//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -  

import java.util.Queue;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class PQTester {

    private Queue<String> pQueue;

    public PQTester() {
        setPQ("");
    }

    public PQTester(String list) {
        setPQ(list);
    }

    public void setPQ(String list) {
        pQueue = new PriorityQueue<>();
        for (String s : list.split(" ")) {
            pQueue.offer(s);
        }
    }

    public Object getMin() {
        return pQueue.peek();
    }

    public String getNaturalOrder() {
        String output = "";
        for (String s : pQueue) {
            output += s + " ";
        }
        return output;
    }

    //write a toString method
    public String toString() {
        return pQueue.toString();
    }
}
