package Leetcode;

public class LC312_BurstBalloons {

//
//    Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
//
//    Find the maximum coins you can collect by bursting the balloons wisely.
//
//    Note:
//
//    You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
//            0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
//    Example:
//
//    Input: [3,1,5,8]
//    Output: 167
//    Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
//    coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167

    public static int maxCoins(int[] nums) {
        int[] newnums = new int[nums.length+2];
        newnums[0] = 1;
        newnums[newnums.length-1] = 1;
        for(int i = 0; i<nums.length;i++){
            newnums[i+1] = nums[i];
        }
        Integer[][] lookupTable = new Integer[nums.length+2][nums.length+2];
        return maxRangeCoins(newnums,0,newnums.length-1,lookupTable);
    }

    private static int maxRangeCoins(int[] balloons,int start, int end,Integer[][] lookup){
        if(end-start==1){
            return 0;
        }
        if(lookup[start][end]!=null)
            return lookup[start][end];
        int maxCoin = 0;
        for(int i = start+1; i<end; i++){
            int coin = balloons[start] * balloons[end] * balloons[i];

            coin = coin + maxRangeCoins(balloons,start, i,lookup) + maxRangeCoins(balloons,i,end,lookup);
            maxCoin = Math.max(maxCoin,coin);

        }
        lookup[start][end] = maxCoin;
        return maxCoin;
    }

    public static void main(String [ ] args){
        int[] s = {3,1,5,8};
        System.out.println(maxCoins(s));
    }
}
