package amazon;

import java.util.Arrays;

/**
 * Created by ray on 10/15/14.
 */
/*
// You are given 3 sorted arrays of integers (with no duplicates within a given array). The size of each set varies. Find the intersection of the 3 sets.

a1 = {2, 3, 4, 5, 9, 99, 18};
a2 = {1, 2, 5, 9, 10};
a3 = {2, 4, 5, 9, 10};

output = {2, 9, 5};
*/
public class IntersectionSortedArrays {

    public static int[] find_intersection(int[] a , int[] b){
        int index_a = 0, index_b = 0, index_result = 0;
        int[] result = new int[Math.min(a.length, b.length)];
        while (index_a < a.length && index_b < b.length){
            if (a[index_a] < b[index_b]){
                index_a++;
            }else if (a[index_a]> b[index_b]){
                index_b++;
            }else{
                result[index_result++] = a[index_a];
                index_a++;
                index_b++;
            }
        }
        return Arrays.copyOfRange(result, 0, index_result);
    }

    public static void main(String[] args) {
        int[] a1 = new int[]{2, 3, 4, 5, 9, 99, 18};
        int[] a2 = new int[]{1, 2, 5, 9, 10};
        int[] a3 = new int[]{2, 4, 5, 9, 10};

        int[] b1 = find_intersection(a1, a2);
        for (int i = 0; i < b1.length; i++) {
            System.out.println(b1[i]);
        }
    }
}
