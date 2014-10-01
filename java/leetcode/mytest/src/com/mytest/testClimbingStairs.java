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
    //Dynamic Programming, cache middle result
    static long fib[] = new long[100];
    public static long fibonacci_DP(int n){
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        if(fib[n] !=0){
            return  fib[n];
        }
        fib[n] = fibonacci_DP(n -1) + fibonacci_DP(n-2);
        return fib[n];
    }


    public static void main(String[] args){
        long bt= System.currentTimeMillis();
        System.out.println(fibonacci_recursive(50));
        long et = System.currentTimeMillis();
        System.out.println(String.format("calculate time: %d", et-bt));
        bt= System.currentTimeMillis();
        System.out.println(fibonacci_DP(50));
        et = System.currentTimeMillis();
        System.out.println(String.format("calculate time: %d", et-bt));
        bt= System.currentTimeMillis();
        System.out.println(fibonacci_iteration(50));
        et = System.currentTimeMillis();
        System.out.println(String.format("calculate time: %d", et-bt));

    }
}
