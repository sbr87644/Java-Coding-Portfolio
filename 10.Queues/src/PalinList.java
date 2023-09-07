//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -  
//Lab  -

import static java.lang.System.out;
import java.util.Queue;
import java.util.Stack;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;

public class PalinList {

    private Queue<String> queue;
    private Stack<String> stack;

    public PalinList() {
        setList("");
    }

    public PalinList(String list) {
        setList(list);
    }

    public void setList(String list) {
        queue = new LinkedList<>();
        stack = new Stack<>();
        for (String s : list.split(" ")) {
            queue.offer(s);
            stack.push(s);
        }
    }

    public boolean isPalin() {
        Queue<String> temp = new LinkedList<>(queue);
        for (int i = 0; i < queue.size(); i++) {
            if (!stack.pop().equals(temp.poll())) {
                return false;
            }
        }
        return true;
    }

    //write a toString method
    public String toString() {
        if (isPalin()) {
            return queue + " is a palinlist.";
        } else{
            return queue + " is not a palinlist.";
        }
    }
}
