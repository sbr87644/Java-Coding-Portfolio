//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.util.LinkedList;
import static java.lang.System.*;

public class JavaLinkedList {

    private LinkedList<Integer> list;

    public JavaLinkedList() {
        list = new LinkedList<Integer>();
    }

    public JavaLinkedList(int[] nums) {
        list = new LinkedList<Integer>();
        for (int num : nums) {
            list.add(num);
        }
    }

    public double getSum() {
        double total = 0;
        for(int n: list)
            total+= n;
        return total;
    }

    public double getAvg() {
        return getSum()/list.size();
    }

    public int getLargest() {
        int largest = Integer.MIN_VALUE;
        for(int n: list)
            if(n > largest)
                largest = n;
        return largest;
    }

    public int getSmallest() {
        int smallest = Integer.MAX_VALUE;
        for(int n: list)
            if(n < smallest)
                smallest = n;
        return smallest;
    }

    public String toString() {
        String output = "";
        output+= "SUM:: " + getSum() + "\n";
        output+= "AVERAGE:: " + getAvg()+ "\n";
        output+= "SMALLEST:: " + getSmallest()+ "\n";
        output+= "LARGEST:: " + getLargest()+ "\n\n\n";
        return output;
    }
}
