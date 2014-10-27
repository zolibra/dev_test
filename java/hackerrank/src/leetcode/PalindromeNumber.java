package leetcode;

/**
 * Created by ray on 10/25/14.
 */
public class PalindromeNumber {
    public int reverse(int x){
        if(x < 0)return 0;
        boolean isNagtive = false;
        if (x<0){
            isNagtive = true;
            x = -x;
        }
        long y = 0;
        while (x/10 > 0){
            y = y*10 + x%10;
            x /= 10;
        }
        y = y*10 + x;
        if (y>0x7fffffff) return 0; //overflow check.
        if(isNagtive)y = -y;
        return (int)y;
    }

    public boolean isPalindrome(int x) {
        if(reverse(x) == x)return true;
        return false;
    }
}
