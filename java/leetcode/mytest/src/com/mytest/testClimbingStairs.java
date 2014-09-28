package com.mytest;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.

   Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class testClimbingStairs {

    //重复计算导致超时,注意退出递归的条件是从 n=1开始 而斐波那契数列： 1 1 2 3 5..
    //f(n) = f(n-1) + f(n-2)
    public static long fibonacci_recursive(long n){

        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }

        return fibonacci_recursive(n - 1) + fibonacci_recursive(n - 2);
    }
    //同样注意初始条件
    public static long fibonacci_iteration(long n){
        long current = 1;
        long prev = 0;
        for (long i = 0; i <n; i++) {
            long tmp = current;
            current = current + prev;
            prev = tmp;
        }

        return current;

    }

    public static long climbStairs(long n) {

        return fibonacci_iteration(n);
    }

    public static void main(String[] args){
        System.out.println(System.currentTimeMillis());
        System.out.println(fibonacci_recursive(50));
        System.out.println(System.currentTimeMillis());
        System.out.println(fibonacci_iteration(50));
        System.out.println(System.currentTimeMillis());

    }
}
