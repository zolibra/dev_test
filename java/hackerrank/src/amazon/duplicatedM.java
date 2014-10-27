package amazon;

/**
 * Created by ray on 10/14/14.
 */

/*
数组有N+M个数字, 数字的范围为1 ... N,打印重复的元素,要求O(M + N),不可以用额外的空间。
initial: 5,5,3,4,4,1,2,5
step 0:  4,5,3,4,5,1,2,5
step 1:  4,5,3,4,5,1,2,5 nochange
step 2:  4,5,3,4,5,1,2,5 nochange
step 3:  4,5,3,4,5,1,2,5 nochange
step 4:  4,5,3,4,5,1,2,5 nochange
step 5:  1,5,3,4,5,4,2,5
step 6:  1,2,3,4,5,4,5,5
step 7:  1,2,3,4,5,4,5,5 nochange

 */
public class duplicatedM {


    public static void findDuplicated(int[] input, int N, int M){
        for (int i = 0; i < N+M;i++) {

            if(input[i] == input[input[i]-1]||input[i] == i+1)
                continue;
            else {
                //swap input[i] and input[input[i]-1]
                int tmp = input[input[i] -1];
                input[input[i] -1] = input[i];
                input[i] = tmp;
            }
        }
    }
    public static void main(String[] args){
        int[] a = new int[]{5,5,3,4,4,1,2,5};
        int N =5;
        int M = 3;
        findDuplicated(a, N, M);
        for (int i = 0 ; i < N+M; i++) {
            System.out.println(a[i]);
        }

    }
}
