//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class OddRunner {

    public static void main(String args[]) throws IOException {
        //more test cases
        Scanner file = new Scanner(new File("oddevens.dat"));
        while (file.hasNextLine()) {
            OddEvenSets test = new OddEvenSets(file.nextLine());
            out.println(test);
        }
    }
}
