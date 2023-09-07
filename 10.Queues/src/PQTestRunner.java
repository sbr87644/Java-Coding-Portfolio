
import static java.lang.System.out;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -  

public class PQTestRunner {

    public static void main(String[] args) {
        //add test cases	
        PQTester test = new PQTester("one two three four five six seven");
        out.println("toString() - " + test);
        out.println("getMin() - " + test.getMin());
        out.println("getNaturalOrder() - " + test.getNaturalOrder() + "\n\n");
        
        test.setPQ("one two three four five 1 2 3 4 5");
        out.println("toString() - " + test);
        out.println("getMin() - " + test.getMin());
        out.println("getNaturalOrder() - " + test.getNaturalOrder() + "\n\n");
        
        test.setPQ("a p h j e f m c i d k l g n o b");
        out.println("toString() - " + test);
        out.println("getMin() - " + test.getMin());
        out.println("getNaturalOrder() - " + test.getNaturalOrder() + "\n\n");
    }
}
