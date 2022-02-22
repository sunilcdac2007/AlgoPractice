package com.interview.feb13;

public class BuySellStockProfit {
    public static void main(String[] args) {

        int[] stockPrice = {7,10, 15, 10, 11, 90, 7, 9,3, 18};
        System.out.println(maxOneTimeProfit(stockPrice));
        System.out.println(profitManyTransaction(stockPrice));
        System.out.println(maxProfitWithKTransaction(stockPrice, 2));
    }
  public static int maxOneTimeProfit(int[] price){
        int maxProfit=0;
        int minPrice =price[0];
        int maxPrice = -1;
        for(int i=0; i < price.length; i++){
            if(price[i] > minPrice && price[i] > maxPrice){
                maxProfit = Math.max(maxProfit, price[i] - minPrice);
                maxPrice=price[i];
            } else if(price[i] < minPrice){
               minPrice=price[i];
               maxPrice = -1;
            }
        }
        return maxProfit;
  }

  public static int profitManyTransaction(int[] price){
        int maxProfit=0;

        for(int i=1; i < price.length; i++){
            if(price[i] > price[i-1]){
                maxProfit += price[i] - price[i-1];
            }
        }
        return maxProfit;
  }

  public static int maxProfitWithKTransaction(int[] price, int k){
        int n = price.length;
      // table to store results of subproblems
      // profit[t][i] stores maximum profit
      // using atmost t transactions up to day
      // i (including day i)
      int profit[][] = new int[k + 1][ n + 1];

      // For day 0, you can't earn money
      // irrespective of how many times you trade
      for (int i = 0; i <= k; i++)
          profit[i][0] = 0;

      // profit is 0 if we don't do any
      // transaction (i.e. k =0)
      for (int j = 0; j <= n; j++)
          profit[0][j] = 0;

      // fill the table in bottom-up fashion
      for (int i = 1; i <= k; i++)
      {
          int prevDiff = Integer.MIN_VALUE;
          for (int j = 1; j < n; j++)
          {
              prevDiff = Math.max(prevDiff,
                      profit[i - 1][j - 1] -
                              price[j - 1]);
              profit[i][j] = Math.max(profit[i][j - 1],
                      price[j] + prevDiff);
          }
      }

      return profit[k][n - 1];
  }

}
