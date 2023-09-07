
import static java.lang.System.out;


//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -  

public class PalinListRunner {

    public static void main(String[] args) {
        //add test cases	
        PalinList test = new PalinList("one two three two one");
        out.println(test);
        
        test.setList("1 2 3 4 5 one two three four five");
        out.println(test);
        
        test.setList("a b c d e f g x y z g f h");
        out.println(test);
        
        test.setList("racecar is racecar");
        out.println(test);
        
        test.setList("1 2 3 a b c c b a 3 2 1");
        out.println(test);
        
        test.setList("chicken is a chicken");
        out.println(test);

    }
}
