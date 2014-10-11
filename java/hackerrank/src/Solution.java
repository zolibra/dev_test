import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
        public static void main(String[] args) throws Exception {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String[] array = in.readLine().split(" ");
            int[] numbers = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                numbers[i] = Integer.parseInt(array[i]);
            }
            System.out.print(binarySearch(numbers, 0 , numbers.length -1, 9));

        }
    public static int binarySearch(int[] arrray, int low , int high, int target){
        while (low < high){
            int mid = (low + high)/2;
            if (arrray[mid] == target)
                return mid;

            else if (arrray[mid] < target){
                low = mid +1;
            }
            else if(arrray[mid] > target){
                high = mid -1;
            }

        }
        return -1;
    }
}
