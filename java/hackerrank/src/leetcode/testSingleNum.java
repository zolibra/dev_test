package leetcode;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * <p/>
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */

public class testSingleNum {

    public static int singleNumber(int[] A) {
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            result ^= A[i];
        }
        return result;

    }


    public static void main(String[] args) {
        int[] testData = {2,2,1};

        System.out.println("test begin");
        System.out.println(singleNumber(testData));

    }
}
