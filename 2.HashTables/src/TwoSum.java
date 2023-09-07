
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sathvik Reddy
 */
public class TwoSum {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("twosum.txt"));
        HashSet<Integer> set = new HashSet();
        while (file.hasNextInt()) {
            set.add(file.nextInt());
        }
    }
}
