package com.mytest;

/**
 * Created by ray on 7/2/14.
 */
public class testSearchInsertPosition {

    public static int searchInsert(int A[], int target){

        int low = 0;
        int high = A.length - 1;

        //notice this side effect
        if (target > A[A.length - 1]){
            return A.length;
        }

        while(low < high - 1){
            int checkpoint = ((low+high)>>1);
            if (A[checkpoint] > target){
                high = checkpoint;
            }else{
                low = checkpoint;
            }
        }
        return (A[low] < target)?low+1:low;
    }

    public static void main(String[] args){
        System.out.println("Test Begin");
        int[] A = {1,2,4,6,7,8};
        System.out.println(searchInsert(A, 5));

        return;
    }
}
