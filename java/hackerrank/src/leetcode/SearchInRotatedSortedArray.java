package leetcode;

/**
 * Created by ray on 10/20/14.
 */


public class SearchInRotatedSortedArray {


    public int binarySearch(int[] array , int low, int high, int target){
        int mid = (low + high)/2;
        if(low > high)return -1;
        if(target == array[mid])return mid;
        if(array[low]<array[mid]){
            if(target >= array[low] && target <= array[mid]){
                return binarySearch(array, low, mid-1,target);
            }else{
                return binarySearch(array, mid+1, high,target);
            }
        }else if(array[low]>array[mid]){
            if(target >= array[mid] && target <= array[high]){
                return binarySearch(array, mid+1, high,target);
            }else{
                return binarySearch(array, low, high-1,target);
            }
        }else if(array[low] == array[mid]){
            if(array[mid] != array[high]){
                return binarySearch(array, mid+1,high,target);
            }else{
                int result = binarySearch(array,low,mid-1,target);
                if(result == -1){
                    return binarySearch(array,mid+1,high,target);
                }else{
                    return result;
                }
            }
        }
        return -1;
    }
//Recursive method
    public int search_recursive(int[] arr, int target) {
        if(arr == null||arr.length == 0){
            return -1;
        }
        return binarySearch(arr, 0, arr.length-1,target);
    }

    //Iteration method by @martin5678
    // https://oj.leetcode.com/discuss/5707/algorithm-using-binary-search-accepted-some-suggestions-else
    public int search_iteration(int[] arr, int target) {
        int low = 0;
        int high = arr.length -1;
        while(low <= high){
            int mid = (low+high)/2;
            if(arr[mid] == target)return mid;
            if(arr[low] <= arr[mid]){
                if(arr[low] <= target && target <= arr[mid]){
                    high = mid-1;
                }else{
                    low = mid +1;

                }
            }else{
                if(arr[mid]<=target&&target<=high){
                    low = mid+1;
                }else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray sirsa = new SearchInRotatedSortedArray();
        int[] array  =  new int[]{4,5,6,7,0,1,2};
        System.out.print(sirsa.search_iteration(array,6));
    }
}
