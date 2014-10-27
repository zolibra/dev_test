package leetcode;

/**
 * Created by ray on 6/28/14.
 */
/*
Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
design an algorithm to find the maximum profit.
 */
public class testBestTimeToSellStock2 {

    public static int maxProfit(int[] prices) {

        int maxProfit = 0;
        int currentMinPrice = prices[0];
            for (int i = 0 ; i < prices.length - 1 ; i++){
                currentMinPrice = Math.min(prices[i], currentMinPrice);
                maxProfit = Math.max(maxProfit, prices[i] - currentMinPrice);
        }

        return maxProfit;

    }

    public static void main(String[] args){

        int[] stock = {2,5,3,7,3,6,8,9};
        System.out.println(maxProfit(stock));
    }
}
