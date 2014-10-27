import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ray on 10/12/14.
 */
/*
https://www.hackerrank.com/challenges/pangrams
 */
public class Pangrams {
    public static void main(String[] args) {
        try{
            int[] existed = new int[26];
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            char[] input = in.readLine().toLowerCase().toCharArray();
            for(char a : input){
                if (a == ' ')continue;
                existed[a - 'a']++;
            }
            boolean isPangram  = true;
            for(int i = 0 ; i < 24; i++){
                if(existed[i] == 0){
                    isPangram = false;
                }
            }
            System.out.print(isPangram?"pangram ":"not pangram ");
        }catch(IOException e){

        }
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}
