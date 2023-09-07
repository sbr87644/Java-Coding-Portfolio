//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class GraphRunner {

    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("graph1.dat"));
        int howManyTimes = file.nextInt();
        file.nextLine();
        String test = "";
        Graph g;
        for (int x = 0; x < howManyTimes; x++) {
            //add code here
            g = new Graph(file.nextLine());
            test = file.nextLine();
            String first = test.charAt(0) + "";
            String second = test.charAt(1) + "";
            out.print(first + " connects to " + second + " == ");
            if (g.connected(first, second)) {
                out.print("yes" + "\n");
            } else {
                out.print("no" + "\n");
            }
        }
    }
}
