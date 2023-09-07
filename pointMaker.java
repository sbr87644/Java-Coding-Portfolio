import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;
import edu.princeton.cs.algs4.StdRandom;

public class pointMaker {
    
    public static void main(String[] args) throws IOException{
        FileWriter out = new FileWriter("random.txt");
        Scanner kb = new Scanner(System.in);
        System.out.println("How many points?");
        int points = kb.nextInt();
        
        System.out.println("Enter minimum x/y value:");
        int min = kb.nextInt();
        
        System.out.println("Enter maximum x/y value:");
        int max = kb.nextInt();
        
        out.write(points + "\n");
        
        for(int i = 0; i < points; i++){
            out.write(StdRandom.uniform(min, max + 1) + " " + StdRandom.uniform(min, max + 1) + "\n");
        }
        out.close();
    }
}
