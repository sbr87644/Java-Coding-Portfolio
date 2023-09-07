import java.util.*;

public class DotProduct {
    private static long maxDotProduct(int[] a, int[] b) {
        //write your code here
        long result = 0;
        int maxA = 0, maxB = 0;
        for (int i = 0; i < a.length; i++) {
             for(int j = 0; j < a.length; j++){
                if(a[j] > a[maxA])
                    maxA = j;
             }
             for(int j = 0; j < b.length; j++){
                if(b[j] > b[maxB])
                    maxB = j;
             }
             result+= (a[maxA]* b[maxB]);
             a[maxA] = Integer.MIN_VALUE;
             b[maxB] = Integer.MIN_VALUE;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(maxDotProduct(a, b));
    }
}

