package com.matthewyao.leetcode;

/**
 * Created by matthewyao on 2017/2/5.
 */
public class L122_BestTimeToBuyAndSellStock_II {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{2,1,3,6}));
        System.out.println(maxProfit(new int[]{1,7,2,5}));
        System.out.println(maxProfit(new int[]{1,2,5,4,9}));
        System.out.println(maxProfit(new int[]{9,3,6,2,5}));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int profit = 0,minPrice = prices[0],maxPrice;
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            if (price > minPrice){
                maxPrice = price;
                if (i == (prices.length - 1) || maxPrice > prices[i+1]){
                    profit += (price - minPrice);
                    //每次出售后要清零最低价
                    if (i < prices.length - 1){
                        minPrice = prices[i+1];
                    }
                }
            }else {
                minPrice = price;
            }
        }
        return profit;
    }
}
