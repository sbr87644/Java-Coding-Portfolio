//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -  
//Class -
//Lab  -

import java.util.Stack;
import static java.lang.System.*;

public class StackTest {

    private Stack<String> stack;

    public StackTest() {
        stack = new Stack<>();
        setStack("");
    }

    public StackTest(String line) {
        stack = new Stack<>();
        setStack(line);
    }

    public void setStack(String line) {
        String[] val = line.split(" ");
        for(String s: val)
            stack.push(s);
    }

    public void popEmAll() {
        int size = stack.size();
        out.println("popping all items from the stack");
        for(int i = 0; i < size; i++)
            out.print(stack.pop() + " ");
        out.println("\n\n");
    }

    //add a toString
    public String toString(){
        return stack.toString();   
    }
}
