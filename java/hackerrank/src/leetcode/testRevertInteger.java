package leetcode;

/**
 * Created by ray on 6/25/14.
 */
public class testRevertInteger {

    public static int reverse(int x){
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

    public static void main(String[] args){
        System.out.println("test begin");
        System.out.println(0x7fffffff);
        System.out.println(reverse(1221245679));
        System.out.println(reverse(-425645639));

    }
}
