//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -  
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class SpanRunner {

    public static void main(String args[]) throws IOException {
        Scanner file = new Scanner(new File("spantoeng.dat"));
        int size = file.nextInt();
        file.nextLine();
        SpanishToEnglish test = new SpanishToEnglish();
        for(int i = 0; i < size; i++){
              test.putEntry(file.nextLine());
        }
        out.println(test);
        
        while(file.hasNextLine()){
            out.println(test.translate(file.nextLine()));   
        }
    }
}
