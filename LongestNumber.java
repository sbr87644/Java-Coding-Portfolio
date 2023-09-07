import java.util.*;

public class LongestNumber{
    public static String longestNumber(String[] num) {
        //write your code here
        String result = "";
        Arrays.sort(num, (String a, String b)-> (b + a).compareTo(a + b));
        for(int i = 0; i < num.length; i++){
              result+= num[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(longestNumber(a));
    }

    
}

