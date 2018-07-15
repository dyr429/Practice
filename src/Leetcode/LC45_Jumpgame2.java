package Leetcode;
//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
//        Each element in the array represents your maximum jump length at that position.
//
//        Your goal is to reach the last index in the minimum number of jumps.
//
//        Example:
//
//        Input: [2,3,1,1,4]
//        Output: 2
//        Explanation: The minimum number of jumps to reach the last index is 2.
//        Jump 1 step from index 0 to 1, then 3 steps to the last index.
//        Note:
//
//        You can assume that you can always reach the last index.
public class LC45_Jumpgame2 {
    public static int jump(int[] nums) {
        if(nums == null || nums.length==1)
            return 0;
        else if(nums[0]>=nums.length-1)
            return 1;


        int currentBest = 0;
        int steps = 1;
        int lastRange=nums[0];
        for(int i =0;i<nums.length-1;i++){
            currentBest = Math.max(currentBest,i+nums[i]);
            if(currentBest>=nums.length-1)
                break;
            else if(i==lastRange){
                lastRange = currentBest;
                steps++;
            }
        }
        return steps+1;





    }


    public static void main(String [ ] args){
        //int arr[] = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
        //int arr[] = {2,3,1,1,4};
        //int arr[] = {2,1};
        //int arr[] = {6,9,1,5,6,0,0,5,9};
        //int arr[] = {1,1,2,1,1};
        //int arr[] = {1,1,1,1,1};
    //    System.out.println(jump(arr));
    }
}
