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

public class HashTableRunner {

    public static void main(String[] args) throws FileNotFoundException {
        //make a new table		
//            Scanner file = new Scanner(new File("numbers.dat"));
//            //read from the file			
//            //load stuff into the table			
//            //print out the table
//            
//        HashTable table = new HashTable();
//        while(file.hasNextInt()){
//                table.add(file.nextInt());   
//            }
//            out.println(table);
        ListNode x = new ListNode(10.3, null);

ListNode y = new ListNode(11.0, x);

ListNode z = new ListNode(2.5, y);

out.println(z.getValue());
    }
}
