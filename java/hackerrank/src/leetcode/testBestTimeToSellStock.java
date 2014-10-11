package leetcode;

/**
 * Created by ray on 6/28/14.
 */
public class testBestTimeToSellStock {

    public static int maxProfit(int[] prices) {

        int total = 0;

        for (int i = 0 ; i < prices.length - 1 ; i++){

            if (prices[i+1] > prices[i]){
                total += prices[i+1] - prices[i];
            }
        }
        return total;

    }

    public static void main(String[] args){

        int[] stock = {2,5,3,7,3,6,8,9};
        System.out.println(maxProfit(stock));
    }
}
