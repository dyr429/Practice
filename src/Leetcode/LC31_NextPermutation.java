package Leetcode;

import java.util.Arrays;

public class LC31_NextPermutation {
    public static void nextPermutation(int[] nums) {
        if(nums.length == 2){
            int temp = nums[0];
            nums[0] = nums[1];
            nums[1] = temp;
        }
        else if(nums.length>2){
            boolean last = true;
            int head = nums.length-2;
            for(; head>=0; head--){
                if(nums[head]<nums[head+1]){
                    int nextHead = nums.length-1;
                    while(nums[nextHead]<=nums[head]){
                        nextHead--;
                    }

                    int temp = nums[nextHead];
                    nums[nextHead] = nums[head];
                    nums[head] = temp;
                    Arrays.sort(nums,head+1,nums.length);
                    last = false;
                    break;
                }
            }

            if(last){
                Arrays.sort(nums);
            }

        }

    }

    public static void main(String [ ] args){
        int arr[] = {3,2,1};
        nextPermutation(arr);
        int n = 0;
    }
}
