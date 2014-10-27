import java.io.*;
import java.util.*;

/*
https://www.hackerrank.com/challenges/insertionsort2/leaderboard

other one solution:
https://codepair.hackerrank.com/paper/pV8Ns7TD?b=eyJyb2xlIjoiY2FuZGlkYXRlIiwibmFtZSI6InpvbGlicmEiLCJlbWFpbCI6InpvbGlicmFAZ21haWwuY29tIn0%3D
 */
public class InsertionSort {

    public static void insertionSortPart2(int[] ar)
    {
        for(int i = 1 ; i<ar.length; i++){
            int key = ar[i];
            int j = i-1;
            while(j>=0 && ar[j]>key){
                ar[j+1] = ar[j];
                j--;
            }
            ar[j+1] = key;
        }
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt();
        }
        insertionSortPart2(ar);
        System.out.print(Arrays.toString(ar));
    }

}
