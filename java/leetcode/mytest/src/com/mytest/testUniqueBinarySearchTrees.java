package com.mytest;

/**
 * Created by ray on 6/28/14.
 */
public class testUniqueBinarySearchTrees {

    private static int[] cache;

private static int numTrees_helper(int n) {
    if (n == 0) return 1;
    if (n == 1) return 1;
    if (cache[n] != 0) return cache[n];
    int count = 0;
    for (int i = 0; i < n; i++) {
        count += numTrees_helper(i) * numTrees_helper(n - i - 1);
    }
    cache[n] = count;
    return count;
}

public static int numTrees(int n) {
    // IMPORTANT: Please reset any member data you declared, as
    // the same Solution instance will be reused for each test case.
    cache = new int[n + 1];
    return numTrees_helper(n);
}
    public static void main(String[] args){

        System.out.println(numTrees(4));
    }
}
