import java.util.Scanner;

public class Change {
    private static int getChange(int m, int count) {
        //write your code here
        if(m != 0){
           if(m >= 10){   
               return getChange(m - 10, count + 1);
           } else if(m >= 5)
               return getChange(m - 5, count + 1);
           else 
               return getChange(m - 1, count + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m, 0));

    }
}

