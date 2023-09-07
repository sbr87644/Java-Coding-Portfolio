//� A+ Computer Science  -  www.apluscompsci.com
//Name -  
//Date -
//Class - 
//Lab  -

import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.System.*;

public class HashTableRunnerWord {

    public static void main(String[] args) throws FileNotFoundException {
        //make a new table		
        Scanner file = new Scanner(new File("words.dat"));
        file.nextInt();
        //read from the file			
        //load stuff into the table			
        //print out the table          
        HashTableWord table = new HashTableWord();
        while (file.hasNext()) {
            table.add(file.next());
        }
        out.println(table);
    }
}
