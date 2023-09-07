//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -  
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class AcroRunner {

    public static void main(String args[]) throws IOException {
        //add test cases
        Scanner file = new Scanner(new File("acro.dat"));
        int size = file.nextInt();
        file.nextLine();
        Acronyms test = new Acronyms();
        for (int i = 0; i < size; i++) {
            test.putEntry(file.nextLine());
        }
        out.println(test);
        while (file.hasNextLine()) {
            out.println(test.convert(file.nextLine()));
        }
    }
}
