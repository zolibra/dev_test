import java.util.Scanner;

/**
 * Created by ray on 10/2/14.
 */
public class MaximizingXOR {


    static int maxXor(int l, int r) {
        int ret = l;
        for (int i = l ; i <= r ; i++){
            for (int j = i ; j <= r ; j++){
                if (ret < (i^j)){
                    ret = (i^j);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int _l;
        _l = Integer.parseInt(in.nextLine());

        int _r;
        _r = Integer.parseInt(in.nextLine());

        res = maxXor(_l, _r);
        System.out.println(res);

    }
}
