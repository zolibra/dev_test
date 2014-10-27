package leetcode;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class testMaximumSubarray {
    public static void main(String[] args){
        int[] array = {1,2,-1,4,5,-3,4,5,6,-1,6};
//        System.out.print(maxSubarray_DivideConquer(array, 0 , array.length-1));
        System.out.print(maxSubarray(array));

    }
//Simple way
    public static int maxSubarray(int[] array){
        int sum = 0,ans=array[0];
        for(int i = 0; i < array.length; i++){
            sum+=array[i];
            ans = Math.max(sum, ans);
            if (sum < 0){
                sum = 0;
            }
        }
        return ans;
    }
/*
Divided and Conquer

Step1. Select the middle element of the array. So the maximum subarray may contain that middle element or not.

Step 2.1 If the maximum subarray does not contain the middle element, then we can apply the same algorithm to the the subarray to the left of the middle element and the subarray to the right of the middle element.

Step 2.2 If the maximum subarray does contain the middle element, then the result will be simply the maximum suffix subarray of the left subarray plus the maximum prefix subarray of the right subarray

Step 3 return the maximum of those three answer.
 */
    public static int maxSubarray_DivideConquer(int[] array, int low, int high){
        if (low == high)return array[high];
        int mid = (low + high)/2;
        int lowans = maxSubarray_DivideConquer(array, low , mid);
        int highans = maxSubarray_DivideConquer(array, mid+1, high);
        int lowmax = 0;
        int highmax = 0;
        int tmpsum = 0;
        for (int i = mid; i >= low; i--){
            tmpsum += array[i];
            if(tmpsum > lowmax)lowmax = tmpsum;
        }
        tmpsum = 0;
        for (int i = mid+1; i <=high; i++){
            tmpsum += array[i];
            if(tmpsum > highmax)highmax = tmpsum;
        }
        return Math.max(Math.max(lowans,highans), lowmax + highmax);
    }
}
