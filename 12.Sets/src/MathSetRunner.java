//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class MathSetRunner {

    public static void main(String args[]) throws IOException {
        //add test cases
        Scanner file = new Scanner(new File("mathsetdata.dat"));
        while(file.hasNextLine()){
            MathSet test = new MathSet(file.nextLine(), file.nextLine());
            out.println(test);
            out.println(test.union());
            out.println(test.intersection());
            out.println(test.differenceAMinusB());
            out.println(test.differenceBMinusA());
            out.println(test.symmetricDifference() + "\n\n");
        }
    }
}
