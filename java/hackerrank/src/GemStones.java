import java.io.ByteArrayInputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Scanner;

/**
 * Created by ray on 10/3/14.
 */
public class GemStones {

         public static void main(String[] args) {
             Scanner in = new Scanner(System.in);
             int n = in.nextInt();
             int flag, gemstone = 0;
             int[][] arr = new int[109][26];
             in.nextLine();
             for (int i = 0 ; i < n ; i ++){
                 char[] rock = in.nextLine().toCharArray();
                 for (int j = 0; j < rock.length; j++) {
                     arr[i][rock[j]-'a']++;
                 }
             }
             for (int i = 0; i <26; i++) {
                 flag = 0;
                 for (int j = 0; j < n; j++) {
                     if (arr[j][i]==0)flag=1;
                 }
                 if (flag==0)
                         gemstone++;
             }
             System.out.println(gemstone);
         }
}
