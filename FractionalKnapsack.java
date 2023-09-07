
import java.util.Scanner;

public class FractionalKnapsack {

    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        //write your code here
        double[] ratio = new double[values.length];
        for (int i = 0; i < ratio.length; i++) {
            ratio[i] = values[i] / weights[i];
        }
        int w = 0, maxR = 0;
        while (w < capacity) {
            for (int i = 0; i < ratio.length; i++) {
                if (ratio[i] > ratio[maxR]) {
                    maxR = i;
                }
            }
            if(weights[maxR] <= capacity){
                value+= values[maxR];
                w+= weights[maxR];
            } else{
                value+= ratio[maxR] * capacity;
                break;
            }
            ratio[maxR] = -1;
        }
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
}
