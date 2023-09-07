//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;
import java.util.*;

public class DupRunner {

    public static void main(String args[]) {
        String words = "a b c d e f g h a b c d e f g h i j k";
        String[] word = words.split(" ");
        out.println(Arrays.toString(word));
        out.println(UniquesDupes.getUniques(words));
        out.println(UniquesDupes.getDupes(words));
        
        words = "one two three one two three six seven one two";
        word = words.split(" ");
        out.println(Arrays.toString(word));
        out.println(UniquesDupes.getUniques(words));
        out.println(UniquesDupes.getDupes(words));
        
        words = "1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 6";
        word = words.split(" ");
        out.println(Arrays.toString(word));
        out.println(UniquesDupes.getUniques(words));
        out.println(UniquesDupes.getDupes(words));
    }
}
