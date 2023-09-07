
import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.System.*;
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author s652803
 */
public class Inversions {

    private static long count;

    public static void mergeSort(int[] ary) {
        count = 0;
        mergeSort(ary, 0, ary.length);
    }

    private static void mergeSort(int[] ary, int left, int right) {
        int m = (left + right) / 2;
        if (left < m) {
            mergeSort(ary, left, m);
            mergeSort(ary, m, right);
            merge(ary, left, m, right);
        }
    }

    private static void merge(int[] ary, int left, int m, int right) {
        int i = left;
        int j = m;
        int index = 0;
        int[] temp = new int[right - left];
        while (i < m && j < right) {
            if (ary[i] < ary[j]) {
                temp[index++] = ary[i++];
            } else {
                count += m - i;
                temp[index++] = ary[j++];
            }
        }
        while (i < m) {
            temp[index++] = ary[i++];
        }
        while (j < right) {
            temp[index++] = ary[j++];
        }
        arraycopy(temp, 0, ary, left, temp.length);
    }

    public static void main(String[] args) throws FileNotFoundException {
        int[] ary = {90, 40, 20, 30, 10, 67};
        mergeSort(ary);
        out.println(count + " inversions");

        int[] ary2 = {3, 15, 61, 11, 7, 9, 2};
        mergeSort(ary2);
        out.println(count + " inversions");

        Scanner file = new Scanner(new File("IntegerArray.txt"));
        int[] ary3 = new int[100000];
        for (int i = 0; i < ary3.length; i++) {
            ary3[i] = file.nextInt();
        }
        mergeSort(ary3);
        out.println(count + " inversions");
    }
}
