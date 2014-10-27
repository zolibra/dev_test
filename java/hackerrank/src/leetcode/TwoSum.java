package leetcode;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by ray on 10/13/14.
 */
public class TwoSum {
    //this will cased a time limited
    public static int[] twoSum1(int[] numbers, int target) {
        int index1 = 0, index2 = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {

                if ((numbers[i] + numbers[j]) == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
            return null;
        }
    //Sort and binarySearch, can not return index
    public static int[] twoSum_binary(int[] numbers, int target){
        //sort the array
        mergeSort(numbers, 0, numbers.length-1);
        //binray search
        for (int i = 0; i < numbers.length; i++) {
            int result = binarySearch(numbers, 0, numbers.length - 1, (target - numbers[i]));
            if (result != -1){
                return new int []{i+1, result+1};
            }
        }
        return null;
    }

    public static int binarySearch(int[] array,int low, int high, int target){
        while(low <= high){
            int mid = (low + high)/2;
            if(array[mid] == target)
                return mid;
            else if(array[mid] < target){
                low = mid +1;
            }else if(array[mid] > target){
                high = mid -1;
            }
        }
        return -1;
    }
    public static void mergeSort(int[] array, int low, int high){
        if(low < high){
            int mid  = (low + high)/2;
            mergeSort(array, low, mid);
            mergeSort(array, mid+1, high);
            merge(array, low, mid,high);//Merge
        }
    }
    //notice all should be <=
    public static void merge(int[]array, int low, int mid, int high){
        int[] helper = new int[array.length];
        //copy target left and right to helper array
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int helper_left = low;
        int helper_right = mid+1;
        int current = low;

        while(helper_left <= mid && helper_right <= high){
            if(helper[helper_left] <= helper[helper_right]){
                array[current] = helper[helper_left];
                helper_left++;
            }else{
                array[current] = helper[helper_right];
                helper_right++;
            }
            current++;
        }

        int remaining = mid - helper_left;
        for (int i = 0; i <= remaining; i++) {
            array[current+i] = helper[helper_left+i];
        }
    }
    //use a hashmap, space O(< n)
    public static int[] twoSum_hashmap(int[] numbers, int target){
        Map<Integer, Integer> hashmap = new HashMap<Integer, Integer>();

        for (int i = 0; i < numbers.length; i++) {
            if (hashmap.containsKey(target - numbers[i])){
                return new int[]{hashmap.get(target - numbers[i]), i+1};
            }
            hashmap.put(numbers[i], i+1);
        }
        return null;
    }
    public static void main(String[] args){
        int[] a =  twoSum_hashmap(new int[]{2, 3, 6, 1, 5, 11, 12}, 9);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

}
