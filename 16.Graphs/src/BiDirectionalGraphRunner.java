//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -  
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;
import static java.lang.System.*;

public class BiDirectionalGraphRunner {

    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("bidgraph.dat"));
        int howManyTimes = file.nextInt();
        file.nextLine();
        String test = "";
        BiDirectionalGraph g;
        for (int x = 0; x < howManyTimes; x++) {
            //add code here
            g = new BiDirectionalGraph(file.nextLine());
            test = file.nextLine();
            String first = test.split(" ")[0];
            String second = test.split(" ")[1];
            out.print(first + " CONNECTS TO " + second + " == ");
            if (g.connected(first, second)) {
                out.print("YAH" + "\n");
            } else {
                out.print("NAH" + "\n");
            }
        }
    }
}
