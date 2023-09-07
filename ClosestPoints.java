
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *

 */
public class ClosestPoints {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("point.txt"));
        int size = file.nextInt();
        Point[] p = new Point[size];
        for (int i = 0; i < size; i++) {
            p[i] = new Point(file.nextInt(), file.nextInt());
        }
    }
}
