import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ray on 10/2/14.
 */
public class isFab {
    //Running time error!
    public static String isFab(int a){
        if (Math.sqrt(5*a*a+4)%1==0 ||Math.sqrt(5*a*a-4)%1==0){
            return "IsFibo";
        }else{
            return "IsNotFibo";
        }
    }

//build a search table to search is the fab exist... not a perfect ans
    public static void main(String arg[]){
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            long[] fiblist = new long[51];
            fiblist[0] = 0;
            fiblist[1] = 1;
            for (int i = 2; i < fiblist.length; i++) {
                fiblist[i] = fiblist[i-2] + fiblist[i-1];
            }
            int num = Integer.parseInt(in.readLine());
            for (int i = 0; i < num; i++) {
                int a = Integer.parseInt(in.readLine());
                //Arrays.binarySearch return value should be >=0, if minus, represent the position to be inserted..
                System.out.println(Arrays.binarySearch(fiblist,a) >= 0?"IsFibo":"IsNotFibo");
            }
        }catch(IOException e){

        }

    }
}
