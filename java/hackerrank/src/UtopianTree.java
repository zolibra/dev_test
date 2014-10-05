import java.util.Scanner;

/**
 * Created by ray on 10/2/14.
 */

public class UtopianTree {

     public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
         Scanner in = new Scanner(System.in);
         int num = in.nextInt();
         for (int i = 0 ; i < num; i++){
             int n = in.nextInt();
                 System.out.println(getHeight_iteration(n));
         }
    }
//my first solution using recursive, the time limit is exceeded!
    public static int getHeight_recursive(int n){
        if(n == 0){
            return 1;
        }

        if(n%2 == 1){
            return getHeight_recursive(n-1) *2;
        }else if(n%2 == 0){
            return getHeight_recursive(n-1) +1;
        }

        return 0;
    }

        public static int getHeight_iteration(int n){
         int sum = 1;
         for(int i = 1 ; i <= n; i++){
                if(i%2 == 0){
                    sum++;
                }else if (i%2 == 1){
                 sum = sum*2;
             }
            }
         return sum;
        }

}
