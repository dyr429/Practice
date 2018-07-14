package Leetcode;

public class LC122_Stock {
    public static int maxProfit(int[] prices) {
       int profit = 0;
       for(int i=0;i<prices.length-1;i++){
           if(prices[i]<prices[i+1])
               profit += prices[i+1] - prices[i];
       }
        return profit;
    }

    public static void main(String [ ] args){
        int arr[] = {2,1,4};
        System.out.println(maxProfit(arr));
    }
}
